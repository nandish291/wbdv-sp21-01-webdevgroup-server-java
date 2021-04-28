package com.webdevgroup.sp2101webdevegroupserverjava.services;

import com.webdevgroup.sp2101webdevegroupserverjava.mapper.UserUserBasicMapper;
import com.webdevgroup.sp2101webdevegroupserverjava.models.*;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.CommentRepository;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final CommentRepository commentRepository;
    private final UserUserBasicMapper mapper;

    public User findUserById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public User findUserByUserName(String username) {
        return repository.findByUserName(username);
    }

    public boolean findByEmail(String email){
        return repository.findByEmail(email)!=null;
    }

    public List<UserBasic> findAllUsers() {
        return mapper.UserToUserBasicSet((List<User>)repository.findAll());
    }

    public User createUser(User user) {
        return repository.save(user);
    }


    //chayank
    public User updateUser(User user) {

        User updateUser=repository.findById(user.getId()).orElse(null);
        if(updateUser==null)
        {
            //check user here
            return null;
        }
        user.setAttending(updateUser.getAttending());
        user.setInterested(updateUser.getInterested());
        repository.save(user);
        return user;
    }

    public EventBasic findEventsForUser(Long id) {
        EventBasic eventBasic=new EventBasic();
        User user=repository.findById(id).orElse(null);
        int i=0;
        for(Event event:user.getAttending())
        {
            eventBasic.eventIds[i]=(event.getId());
            eventBasic.eventNames[i]=event.getTitle();
            i++;
            if(i==2)
                break;
        }
        return eventBasic;
    }

    public void deleteUser(Long id) {
        User user=repository.findById(id).orElse(null);
        List<Comment> comments= commentRepository.findCommentByUserName(user.getUserName());
        for(Comment comment:comments)
            commentRepository.deleteById(comment.getId());
        repository.deleteById(id);
    }

    public User findUserByEmail(String username) {
        return repository.findByEmail(username);
    }
}
