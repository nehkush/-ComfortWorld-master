package com.app.controller;

import com.app.model.AirConditioner;
import com.app.service.IAirConditionerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/airConditioners")
public class AirConditionerController {

    private final IAirConditionerService airConditionerService;

    @Autowired
    public AirConditionerController(IAirConditionerService airConditionerService) {
        this.airConditionerService = airConditionerService;
    }

    @PostMapping
    public ResponseEntity<AirConditioner> createAirConditioner(@RequestBody AirConditioner airConditioner) {
        AirConditioner createdAirConditioner = airConditionerService.createAirConditioner(airConditioner);
        return new ResponseEntity<>(createdAirConditioner, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AirConditioner> getAirConditionerById(@PathVariable Long id) {
        Optional<AirConditioner> airConditioner = airConditionerService.getAirConditionerById(id);
        return airConditioner.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<AirConditioner>> getAllAirConditioners() {
        List<AirConditioner> airConditioners = airConditionerService.getAllAirConditioners();
        return new ResponseEntity<>(airConditioners, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AirConditioner> updateAirConditioner(@PathVariable Long id, @RequestBody AirConditioner updatedAirConditioner) {
        AirConditioner airConditioner = airConditionerService.updateAirConditioner(id, updatedAirConditioner);
        return airConditioner != null ?
                new ResponseEntity<>(airConditioner, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirConditioner(@PathVariable Long id) {
        airConditionerService.deleteAirConditioner(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byBrand")
    public ResponseEntity<List<AirConditioner>> getAirConditionersByBrand(@RequestParam String brand) {
        List<AirConditioner> airConditioners = airConditionerService.getAirConditionersByBrand(brand);
        return new ResponseEntity<>(airConditioners, HttpStatus.OK);
    }
}
