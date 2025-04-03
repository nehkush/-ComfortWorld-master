package com.app.service;

import com.app.model.Worker;

import java.util.List;
import java.util.Optional;

public interface IWorkerService {

    // Create
    Worker createWorker(Worker worker);

    // Read
    Optional<Worker> getWorkerById(Long id);

    Optional<Worker> getWorkerByEmail(String email);

    List<Worker> getAllWorkers();

    // Update
    Worker updateWorker(Long id, Worker updatedWorker);

    // Delete
    void deleteWorker(Long id);
}
