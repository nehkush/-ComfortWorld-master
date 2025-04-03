package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.model.Feedback;

public interface IFeedbackService {

    // Create
    Feedback createFeedback(Feedback feedback);

    // Read
    Optional<Feedback> getFeedbackById(Long id);

    List<Feedback> getAllFeedbacks();

    // Update
    Feedback updateFeedback(Long id, Feedback updatedFeedback);

    // Delete
    void deleteFeedback(Long id);

    // Additional methods (if needed)
    // Example: Find feedbacks by user name
    List<Feedback> getFeedbacksByUserName(String userName);
}
