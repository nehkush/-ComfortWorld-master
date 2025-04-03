package com.app.controller;

import com.app.model.WashingMachine;
import com.app.service.IWashingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:5173")
@RequestMapping("/washing-machines")
public class WashingMachineController {

    private final IWashingMachineService washingMachineService;

    @Autowired
    public WashingMachineController(IWashingMachineService washingMachineService) {
        this.washingMachineService = washingMachineService;
    }

    @PostMapping
    public ResponseEntity<WashingMachine> createWashingMachine(@RequestBody WashingMachine washingMachine) {
        WashingMachine createdWashingMachine = washingMachineService.createWashingMachine(washingMachine);
        return new ResponseEntity<>(createdWashingMachine, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WashingMachine> getWashingMachineById(@PathVariable Long id) {
        Optional<WashingMachine> washingMachine = washingMachineService.getWashingMachineById(id);
        return washingMachine.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<WashingMachine>> getAllWashingMachines() {
        List<WashingMachine> washingMachines = washingMachineService.getAllWashingMachines();
        return new ResponseEntity<>(washingMachines, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WashingMachine> updateWashingMachine(@PathVariable Long id,
                                                              @RequestBody WashingMachine updatedWashingMachine) {
        WashingMachine washingMachine = washingMachineService.updateWashingMachine(id, updatedWashingMachine);
        return washingMachine != null ?
                new ResponseEntity<>(washingMachine, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWashingMachine(@PathVariable Long id) {
        washingMachineService.deleteWashingMachine(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byBrand")
    public ResponseEntity<List<WashingMachine>> getWashingMachinesByBrand(@RequestParam String brand) {
        List<WashingMachine> washingMachines = washingMachineService.getWashingMachinesByBrand(brand);
        return new ResponseEntity<>(washingMachines, HttpStatus.OK);
    }
}
