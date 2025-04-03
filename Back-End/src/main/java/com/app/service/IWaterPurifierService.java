package com.app.service;

import com.app.model.WaterPurifier;

import java.util.List;
import java.util.Optional;

public interface IWaterPurifierService {

    // Create
    WaterPurifier createWaterPurifier(WaterPurifier waterPurifier);

    // Read
    Optional<WaterPurifier> getWaterPurifierById(Long id);

    List<WaterPurifier> getAllWaterPurifiers();

    // Update
    WaterPurifier updateWaterPurifier(Long id, WaterPurifier updatedWaterPurifier);

    // Delete
    void deleteWaterPurifier(Long id);

    // Additional methods (if needed)
    // Example: Find water purifiers by brand
    List<WaterPurifier> getWaterPurifiersByBrand(String brand);
}
