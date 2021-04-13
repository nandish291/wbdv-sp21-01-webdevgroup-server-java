package com.webdevgroup.sp2101webdevegroupserverjava.services;

import com.webdevgroup.sp2101webdevegroupserverjava.models.User;
import com.webdevgroup.sp2101webdevegroupserverjava.repositories.UserRepository;
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
        return repository.findUserByUserName(username);
    }

    public List<User> findAllUsers() {
        return repository.findAllUsers();
    }

    public User createUser(String name, String username, String password, String email) {
        User user = new User(name, username, password, email);
        return repository.save(user);
    }
}
