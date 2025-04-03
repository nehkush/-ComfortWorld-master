package com.app.service;

import com.app.model.Television;

import java.util.List;
import java.util.Optional;

public interface ITelevisionService {

    // Create
    Television createTelevision(Television television);

    // Read
    Optional<Television> getTelevisionById(Long id);

    List<Television> getAllTelevisions();

    // Update
    Television updateTelevision(Long id, Television updatedTelevision);

    // Delete
    void deleteTelevision(Long id);

    // Additional methods (if needed)
    // Example: Find televisions by brand
    List<Television> getTelevisionsByBrand(String brand);
}
