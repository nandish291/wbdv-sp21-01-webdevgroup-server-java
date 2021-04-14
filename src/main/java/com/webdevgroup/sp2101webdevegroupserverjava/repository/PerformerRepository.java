package com.webdevgroup.sp2101webdevegroupserverjava.repository;

import com.webdevgroup.sp2101webdevegroupserverjava.models.Performer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformerRepository extends JpaRepository<Performer,Long> {
}
