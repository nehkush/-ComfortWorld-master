package com.app.service;

import com.app.model.Feedback;
import com.app.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements IFeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Override
    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    @Override
    public Feedback updateFeedback(Long id, Feedback updatedFeedback) {
        if (feedbackRepository.existsById(id)) {
            updatedFeedback.setId(id);
            return feedbackRepository.save(updatedFeedback);
        } else {
            // Handle the case where the feedback with the given ID doesn't exist
            return null;
        }
    }

    @Override
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }

    @Override
    public List<Feedback> getFeedbacksByUserName(String userName) {
        return feedbackRepository.findByName(userName);
    }
}
