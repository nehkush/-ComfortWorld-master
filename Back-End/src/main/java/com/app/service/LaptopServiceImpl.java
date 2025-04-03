package com.app.service;

import com.app.model.Laptop;
import com.app.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopServiceImpl implements ILaptopService {

    private final LaptopRepository laptopRepository;

    @Autowired
    public LaptopServiceImpl(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @Override
    public Laptop createLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    @Override
    public Optional<Laptop> getLaptopById(Long id) {
        return laptopRepository.findById(id);
    }

    @Override
    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    @Override
    public Laptop updateLaptop(Long id, Laptop updatedLaptop) {
        if (laptopRepository.existsById(id)) {
            updatedLaptop.setId(id);
            return laptopRepository.save(updatedLaptop);
        } else {
            // Handle the case where the laptop with the given ID doesn't exist
            return null;
        }
    }

    @Override
    public void deleteLaptop(Long id) {
        laptopRepository.deleteById(id);
    }

    @Override
    public List<Laptop> getLaptopsByBrand(String brand) {
        return laptopRepository.findByBrand(brand);
    }
}
