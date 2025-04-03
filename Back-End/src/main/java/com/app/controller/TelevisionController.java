package com.app.controller;

import com.app.model.Television;
import com.app.service.ITelevisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:5173")
@RequestMapping("/televisions")
public class TelevisionController {

    private final ITelevisionService televisionService;

    @Autowired
    public TelevisionController(ITelevisionService televisionService) {
        this.televisionService = televisionService;
    }

    @PostMapping
    public ResponseEntity<Television> createTelevision(@RequestBody Television television) {
        Television createdTelevision = televisionService.createTelevision(television);
        return new ResponseEntity<>(createdTelevision, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevisionById(@PathVariable Long id) {
        Optional<Television> television = televisionService.getTelevisionById(id);
        return television.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Television>> getAllTelevisions() {
        List<Television> televisions = televisionService.getAllTelevisions();
        return new ResponseEntity<>(televisions, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television updatedTelevision) {
        Television television = televisionService.updateTelevision(id, updatedTelevision);
        return television != null ?
                new ResponseEntity<>(television, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id) {
        televisionService.deleteTelevision(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byBrand")
    public ResponseEntity<List<Television>> getTelevisionsByBrand(@RequestParam String brand) {
        List<Television> televisions = televisionService.getTelevisionsByBrand(brand);
        return new ResponseEntity<>(televisions, HttpStatus.OK);
    }
}
