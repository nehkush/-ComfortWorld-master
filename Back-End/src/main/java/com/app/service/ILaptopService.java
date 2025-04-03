package com.app.service;

import com.app.model.Laptop;

import java.util.List;
import java.util.Optional;

public interface ILaptopService {

    // Create
    Laptop createLaptop(Laptop laptop);

    // Read
    Optional<Laptop> getLaptopById(Long id);

    List<Laptop> getAllLaptops();

    // Update
    Laptop updateLaptop(Long id, Laptop updatedLaptop);

    // Delete
    void deleteLaptop(Long id);

    // Additional methods (if needed)
    // Example: Find laptops by brand
    List<Laptop> getLaptopsByBrand(String brand);
}
