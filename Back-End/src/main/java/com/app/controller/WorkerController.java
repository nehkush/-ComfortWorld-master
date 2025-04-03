package com.app.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Worker;
import com.app.service.IWorkerService;

@RestController
@CrossOrigin(origins="http://localhost:5173")
@RequestMapping("/workers")
public class WorkerController {

    private final IWorkerService workerService;

    @Autowired
    public WorkerController(IWorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping
    public ResponseEntity<Worker> createWorker(@RequestBody Worker worker) {
    	
            Worker createdWorker = workerService.createWorker(worker);
            return new ResponseEntity<>(createdWorker, HttpStatus.CREATED);
            
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable Long id) {
        Optional<Worker> worker = workerService.getWorkerById(id);
        return worker.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/byEmail")
    public ResponseEntity<Worker> getWorkerByEmail(@RequestParam String email) {
        Optional<Worker> worker = workerService.getWorkerByEmail(email);
        return worker.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Worker>> getAllWorkers() {
        List<Worker> workers = workerService.getAllWorkers();
        return new ResponseEntity<>(workers, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Worker> updateWorker(@PathVariable Long id, @RequestBody Worker updatedWorker) {
        Worker worker = workerService.updateWorker(id, updatedWorker);
        return worker != null ?
                new ResponseEntity<>(worker, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorker(@PathVariable Long id) {
        workerService.deleteWorker(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
