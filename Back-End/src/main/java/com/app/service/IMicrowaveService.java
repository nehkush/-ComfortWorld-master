package com.app.service;

import com.app.model.Microwave;

import java.util.List;
import java.util.Optional;

public interface IMicrowaveService {

    // Create
    Microwave createMicrowave(Microwave microwave);

    // Read
    Optional<Microwave> getMicrowaveById(Long id);

    List<Microwave> getAllMicrowaves();

    // Update
    Microwave updateMicrowave(Long id, Microwave updatedMicrowave);

    // Delete
    void deleteMicrowave(Long id);

    // Additional methods (if needed)
    // Example: Find microwaves by brand
    List<Microwave> getMicrowavesByBrand(String brand);
}
