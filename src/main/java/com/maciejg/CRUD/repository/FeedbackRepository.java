package com.maciejg.CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maciejg.CRUD.EntityFeedback;

@Repository
public interface FeedbackRepository extends JpaRepository<EntityFeedback, Long> {

	
}
