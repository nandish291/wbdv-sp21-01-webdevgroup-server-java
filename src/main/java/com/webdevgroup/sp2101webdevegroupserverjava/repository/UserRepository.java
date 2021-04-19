package com.webdevgroup.sp2101webdevegroupserverjava.repository;

import com.webdevgroup.sp2101webdevegroupserverjava.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository
        extends CrudRepository<User, Long> {
    //    @Query(value="SELECT * FROM user", nativeQuery = true)
    @Query(value="SELECT user FROM User user", nativeQuery = true)
    public List<User> findAllUsers();

    @Query(value="SELECT * FROM user WHERE id=:uid", nativeQuery = true)
    public User findUserById(@Param("uid") Long userId);

    @Query(value="SELECT * FROM user WHERE username=:username", nativeQuery = true)
    public User findUserByUserName(@Param("username") String username);

    public User findByUsername(String username);

}
