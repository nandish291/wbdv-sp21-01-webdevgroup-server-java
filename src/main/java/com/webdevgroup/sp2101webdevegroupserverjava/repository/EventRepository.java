package com.webdevgroup.sp2101webdevegroupserverjava.repository;

import com.webdevgroup.sp2101webdevegroupserverjava.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
