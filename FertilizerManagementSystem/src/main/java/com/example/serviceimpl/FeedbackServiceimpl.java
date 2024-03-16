package com.example.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Feedback;
import com.example.repository.FeedbackRepository;

@Service
public class FeedbackServiceimpl {
	
	@Autowired
	private FeedbackRepository fedFeedbackRepository;
	
	public Feedback saveFeedback(Feedback feedback) {
		
		return this.fedFeedbackRepository.save(feedback);
		
	}
	
	public List<Feedback> getAllFeedbacks(){
		return this.fedFeedbackRepository.findAll();
	}
	

}
