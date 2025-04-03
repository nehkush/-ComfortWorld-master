package com.app.service;

import com.app.model.WashingMachine;

import java.util.List;
import java.util.Optional;

public interface IWashingMachineService {

    // Create
    WashingMachine createWashingMachine(WashingMachine washingMachine);

    // Read
    Optional<WashingMachine> getWashingMachineById(Long id);

    List<WashingMachine> getAllWashingMachines();

    // Update
    WashingMachine updateWashingMachine(Long id, WashingMachine updatedWashingMachine);

    // Delete
    void deleteWashingMachine(Long id);

    // Additional methods (if needed)
    // Example: Find washing machines by brand
    List<WashingMachine> getWashingMachinesByBrand(String brand);
}
