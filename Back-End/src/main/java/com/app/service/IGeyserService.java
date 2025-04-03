package com.app.service;

import com.app.model.Geyser;

import java.util.List;
import java.util.Optional;

public interface IGeyserService {

    // Create
    Geyser createGeyser(Geyser geyser);

    // Read
    Optional<Geyser> getGeyserById(Long id);

    List<Geyser> getAllGeysers();

    // Update
    Geyser updateGeyser(Long id, Geyser updatedGeyser);

    // Delete
    void deleteGeyser(Long id);

    // Additional methods (if needed)
    // Example: Find geysers by brand
    List<Geyser> getGeysersByBrand(String brand);
}
