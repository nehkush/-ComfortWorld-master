package com.app.controller;

import com.app.model.Laptop;
import com.app.service.ILaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:5173")
@RequestMapping("/laptops")
public class LaptopController {

    private final ILaptopService laptopService;

    @Autowired
    public LaptopController(ILaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @PostMapping
    public ResponseEntity<Laptop> createLaptop(@RequestBody Laptop laptop) {
        Laptop createdLaptop = laptopService.createLaptop(laptop);
        return new ResponseEntity<>(createdLaptop, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Laptop> getLaptopById(@PathVariable Long id) {
        Optional<Laptop> laptop = laptopService.getLaptopById(id);
        return laptop.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Laptop>> getAllLaptops() {
        List<Laptop> laptops = laptopService.getAllLaptops();
        return new ResponseEntity<>(laptops, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Laptop> updateLaptop(@PathVariable Long id, @RequestBody Laptop updatedLaptop) {
        Laptop laptop = laptopService.updateLaptop(id, updatedLaptop);
        return laptop != null ?
                new ResponseEntity<>(laptop, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLaptop(@PathVariable Long id) {
        laptopService.deleteLaptop(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byBrand")
    public ResponseEntity<List<Laptop>> getLaptopsByBrand(@RequestParam String brand) {
        List<Laptop> laptops = laptopService.getLaptopsByBrand(brand);
        return new ResponseEntity<>(laptops, HttpStatus.OK);
    }
}
