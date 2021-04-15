package com.webdevgroup.sp2101webdevegroupserverjava.services;

import com.webdevgroup.sp2101webdevegroupserverjava.models.User;
import com.webdevgroup.sp2101webdevegroupserverjava.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User findUserById(Long id) {
        return repository.findUserById(id);
    }
    public User findUserByUserName(String username) {
        return repository.findUserByUserName(username);
    }

    public List<User> findAllUsers() {
        return repository.findAllUsers();
    }

    public User createUser(User user) {

        return repository.save(user);
    }
}
