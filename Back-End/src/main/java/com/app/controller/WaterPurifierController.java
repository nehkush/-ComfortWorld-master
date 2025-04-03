package com.app.controller;

import com.app.model.WaterPurifier;
import com.app.service.IWaterPurifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:5173")
@RequestMapping("/water-purifiers")
public class WaterPurifierController {

    private final IWaterPurifierService waterPurifierService;

    @Autowired
    public WaterPurifierController(IWaterPurifierService waterPurifierService) {
        this.waterPurifierService = waterPurifierService;
    }

    @PostMapping
    public ResponseEntity<WaterPurifier> createWaterPurifier(@RequestBody WaterPurifier waterPurifier) {
        WaterPurifier createdWaterPurifier = waterPurifierService.createWaterPurifier(waterPurifier);
        return new ResponseEntity<>(createdWaterPurifier, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WaterPurifier> getWaterPurifierById(@PathVariable Long id) {
        Optional<WaterPurifier> waterPurifier = waterPurifierService.getWaterPurifierById(id);
        return waterPurifier.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<WaterPurifier>> getAllWaterPurifiers() {
        List<WaterPurifier> waterPurifiers = waterPurifierService.getAllWaterPurifiers();
        return new ResponseEntity<>(waterPurifiers, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WaterPurifier> updateWaterPurifier(@PathVariable Long id,
                                                              @RequestBody WaterPurifier updatedWaterPurifier) {
        WaterPurifier waterPurifier = waterPurifierService.updateWaterPurifier(id, updatedWaterPurifier);
        return waterPurifier != null ?
                new ResponseEntity<>(waterPurifier, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWaterPurifier(@PathVariable Long id) {
        waterPurifierService.deleteWaterPurifier(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byBrand")
    public ResponseEntity<List<WaterPurifier>> getWaterPurifiersByBrand(@RequestParam String brand) {
        List<WaterPurifier> waterPurifiers = waterPurifierService.getWaterPurifiersByBrand(brand);
        return new ResponseEntity<>(waterPurifiers, HttpStatus.OK);
    }
}
