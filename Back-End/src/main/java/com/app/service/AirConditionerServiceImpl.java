package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.AirConditioner;
import com.app.repository.AirConditionerRepository;

@Service
public class AirConditionerServiceImpl implements IAirConditionerService {

    private final AirConditionerRepository airConditionerRepository;

    @Autowired
    public AirConditionerServiceImpl(AirConditionerRepository airConditionerRepository) {
        this.airConditionerRepository = airConditionerRepository;
    }

    @Override
    public AirConditioner createAirConditioner(AirConditioner airConditioner) {
        return airConditionerRepository.save(airConditioner);
    }

    @Override
    public Optional<AirConditioner> getAirConditionerById(Long id) {
        return airConditionerRepository.findById(id);
    }

    @Override
    public List<AirConditioner> getAllAirConditioners() {
        return airConditionerRepository.findAll();
    }

    @Override
    public AirConditioner updateAirConditioner(Long id, AirConditioner updatedAirConditioner) {
        if (airConditionerRepository.existsById(id)) {
            updatedAirConditioner.setId(id);
            return airConditionerRepository.save(updatedAirConditioner);
        } else {
            // Handle the case where the air conditioner with the given ID doesn't exist
            return null;
        }
    }

    @Override
    public void deleteAirConditioner(Long id) {
        airConditionerRepository.deleteById(id);
    }

    @Override
    public List<AirConditioner> getAirConditionersByBrand(String brand) {
        return airConditionerRepository.findByBrand(brand);
    }
}
