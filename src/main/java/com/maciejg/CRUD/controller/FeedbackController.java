package com.maciejg.CRUD.controller;

import java.util.List;

import javax.validation.Valid;

import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maciejg.CRUD.EntityFeedback;
import com.maciejg.CRUD.repository.FeedbackRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class FeedbackController {
	
	@Autowired
	FeedbackRepository feedbackRepository;
	
	@GetMapping("/feedback")
	public List<EntityFeedback> getfeedback(){
		return feedbackRepository.findAll();
		}
	
	@PostMapping("/feedback")
	public EntityFeedback feedback( @RequestBody EntityFeedback entityFeedback) {
		
		return feedbackRepository.save(entityFeedback);
	}
}
