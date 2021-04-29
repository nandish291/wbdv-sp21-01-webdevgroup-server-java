package com.webdevgroup.sp2101webdevegroupserverjava.services;

import com.webdevgroup.sp2101webdevegroupserverjava.mapper.UserUserBasicMapper;
import com.webdevgroup.sp2101webdevegroupserverjava.models.*;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.CommentRepository;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Boolean addFollow(Long userId, Long targetId) {
        User user=repository.findById(userId).orElse(null);
        User target=repository.findById(targetId).orElse(null);
        if(user!=null && target !=null) {
            user.getFollowing().add(target);
            target.getFollowers().add(user);
            repository.save(user);
            repository.save(target);
            return true;
        }
        return false;
    }

    public Boolean deleteFollow(Long userId, Long targetId) {
        User user=repository.findById(userId).orElse(null);
        User target=repository.findById(targetId).orElse(null);
        if(user!=null && target !=null) {
            user.getFollowing().remove(target);
            target.getFollowers().remove(user);
            repository.save(user);
            repository.save(target);
            return true;
        }
        return false;
    }

    public UserDetails getUserDetails(Long userId) {
        UserDetails userDetails=new UserDetails();
        userDetails.setUser(repository.findById(userId).orElse(null));
        userDetails.setFollowers(repository.findById(userId).orElse(null).getFollowers());
        userDetails.setFollowing(repository.findById(userId).orElse(null).getFollowing());
        return userDetails;
    }
}
