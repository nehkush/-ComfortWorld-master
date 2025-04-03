package com.app.service;

import com.app.model.WaterPurifier;
import com.app.repository.WaterPurifierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WaterPurifierServiceImpl implements IWaterPurifierService {

    private final WaterPurifierRepository waterPurifierRepository;

    @Autowired
    public WaterPurifierServiceImpl(WaterPurifierRepository waterPurifierRepository) {
        this.waterPurifierRepository = waterPurifierRepository;
    }

    @Override
    public WaterPurifier createWaterPurifier(WaterPurifier waterPurifier) {
        return waterPurifierRepository.save(waterPurifier);
    }

    @Override
    public Optional<WaterPurifier> getWaterPurifierById(Long id) {
        return waterPurifierRepository.findById(id);
    }

    @Override
    public List<WaterPurifier> getAllWaterPurifiers() {
        return waterPurifierRepository.findAll();
    }

    @Override
    public WaterPurifier updateWaterPurifier(Long id, WaterPurifier updatedWaterPurifier) {
        if (waterPurifierRepository.existsById(id)) {
            updatedWaterPurifier.setId(id);
            return waterPurifierRepository.save(updatedWaterPurifier);
        } else {
            // Handle the case where the water purifier with the given ID doesn't exist
            return null;
        }
    }

    @Override
    public void deleteWaterPurifier(Long id) {
        waterPurifierRepository.deleteById(id);
    }

    @Override
    public List<WaterPurifier> getWaterPurifiersByBrand(String brand) {
        return waterPurifierRepository.findByBrand(brand);
    }
}
