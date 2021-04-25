package com.webdevgroup.sp2101webdevegroupserverjava.repository;

import com.webdevgroup.sp2101webdevegroupserverjava.models.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;


public interface CommentRepository
        extends CrudRepository<Comment,Long> {

        @Query(value = "SELECT * FROM comments WHERE event_id=:eid", nativeQuery = true)
        public Set<Comment> findCommentsForEvent(@Param("eid") Long eid);

        public void deleteCommentByUserName(String userName);

}
