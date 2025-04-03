package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.app.model.Worker;
import com.app.repository.WorkerRepository;

@Service
public class WorkerServiceImpl implements IWorkerService {

    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public Worker createWorker(Worker worker) {
    	try {
            return workerRepository.save(worker);
        } catch (DataIntegrityViolationException e) {
            // Handle the exception when a duplicate email is detected
            throw new DuplicateKeyException("Email already exists");
        }
    }

    @Override
    public Optional<Worker> getWorkerById(Long id) {
        return workerRepository.findById(id);
    }

    @Override
    public Optional<Worker> getWorkerByEmail(String email) {
        return workerRepository.findByEmail(email);
    }

    @Override
    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }

    @Override
    public Worker updateWorker(Long id, Worker updatedWorker) {
        if (workerRepository.existsById(id)) {
            updatedWorker.setId(id);
            return workerRepository.save(updatedWorker);
        } else {
            // Handle the case where the worker with the given ID doesn't exist
            return null;
        }
    }

    @Override
    public void deleteWorker(Long id) {
        workerRepository.deleteById(id);
    }
}
