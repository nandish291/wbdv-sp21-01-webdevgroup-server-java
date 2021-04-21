package com.webdevgroup.sp2101webdevegroupserverjava.services;

import com.webdevgroup.sp2101webdevegroupserverjava.models.User;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    UserRepository repository;

    public User findUserById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public User findUserByUserName(String username) {
        return repository.findByUsername(username);
    }

    public List<User> findAllUsers() {
        return (List<User>)repository.findAll();
    }

    public User createUser(User user) {
        return repository.save(user);
    }


    //chayank
    public User updateUser(User user) {

        if(!repository.findById(user.getId()).isPresent())
        {
            //check user here
            return null;
        }

        repository.save(user);
        return user;
    }
}
