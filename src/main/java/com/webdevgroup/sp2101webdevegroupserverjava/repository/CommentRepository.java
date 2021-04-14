package com.webdevgroup.sp2101webdevegroupserverjava.repository;

import com.webdevgroup.sp2101webdevegroupserverjava.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment,Long> {
}
