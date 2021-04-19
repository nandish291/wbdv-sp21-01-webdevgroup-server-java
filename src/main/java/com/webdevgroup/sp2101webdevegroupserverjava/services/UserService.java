package com.webdevgroup.sp2101webdevegroupserverjava.services;

import com.webdevgroup.sp2101webdevegroupserverjava.models.User;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User findUserById(Long id) {
        return repository.findUserById(id);
    }
    public User findUserByUserName(String username) {
//        User foundUser = repository.findUserByUserName(username);
        User foundUser = repository.findByUsername(username);
        return foundUser;
    }

    public List<User> findAllUsers() {
        return repository.findAllUsers();
    }

    public User createUser(User user) {
        return repository.save(user);
    }
}
