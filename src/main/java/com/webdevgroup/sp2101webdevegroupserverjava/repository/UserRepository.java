package com.webdevgroup.sp2101webdevegroupserverjava.repository;

import com.webdevgroup.sp2101webdevegroupserverjava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
//    @Query(value="SELECT * FROM user", nativeQuery = true)
        @Query(value="SELECT user FROM User user", nativeQuery = true)
        public List<User> findAllUsers();

        @Query(value="SELECT * FROM heroku_a6f102cb7f7ae1c.users WHERE id=:uid", nativeQuery = true)
        public User findUserById(@Param("uid") Long userId);

        @Query(value="SELECT * FROM heroku_a6f102cb7f7ae1c.users WHERE username=:username", nativeQuery = true)
        public User findUserByUserName(@Param("username") String username);
}
