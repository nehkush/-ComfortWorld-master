package com.app.service;

import com.app.model.AirConditioner;

import java.util.List;
import java.util.Optional;

public interface IAirConditionerService {

    // Create
    AirConditioner createAirConditioner(AirConditioner airConditioner);

    // Read
    Optional<AirConditioner> getAirConditionerById(Long id);

    List<AirConditioner> getAllAirConditioners();

    // Update
    AirConditioner updateAirConditioner(Long id, AirConditioner updatedAirConditioner);

    // Delete
    void deleteAirConditioner(Long id);

    // Additional methods (if needed)
    // Example: Find air conditioners by brand
    List<AirConditioner> getAirConditionersByBrand(String brand);
}
