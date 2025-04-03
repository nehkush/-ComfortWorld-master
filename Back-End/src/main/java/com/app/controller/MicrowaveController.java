package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.app.model.Microwave;
import com.app.service.IMicrowaveService;

@RestController
@CrossOrigin(origins="http://localhost:5173")
@RequestMapping("/microwaves")
public class MicrowaveController {

    private final IMicrowaveService microwaveService;

    @Autowired
    public MicrowaveController(IMicrowaveService microwaveService) {
        this.microwaveService = microwaveService;
    }

    @PostMapping
    public ResponseEntity<Microwave> createMicrowave(@RequestBody Microwave microwave) {
        Microwave createdMicrowave = microwaveService.createMicrowave(microwave);
        return new ResponseEntity<>(createdMicrowave, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Microwave> getMicrowaveById(@PathVariable Long id) {
        Optional<Microwave> microwave = microwaveService.getMicrowaveById(id);
        return microwave.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Microwave>> getAllMicrowaves() {
        List<Microwave> microwaves = microwaveService.getAllMicrowaves();
        return new ResponseEntity<>(microwaves, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Microwave> updateMicrowave(@PathVariable Long id, @RequestBody Microwave updatedMicrowave) {
        Microwave microwave = microwaveService.updateMicrowave(id, updatedMicrowave);
        return microwave != null ?
                new ResponseEntity<>(microwave, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMicrowave(@PathVariable Long id) {
        microwaveService.deleteMicrowave(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byBrand")
    public ResponseEntity<List<Microwave>> getMicrowavesByBrand(@RequestParam String brand) {
        List<Microwave> microwaves = microwaveService.getMicrowavesByBrand(brand);
        return new ResponseEntity<>(microwaves, HttpStatus.OK);
    }
}
