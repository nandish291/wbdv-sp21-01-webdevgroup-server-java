package com.webdevgroup.sp2101webdevegroupserverjava.repository;

import com.webdevgroup.sp2101webdevegroupserverjava.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
