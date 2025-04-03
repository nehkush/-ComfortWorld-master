package com.app.service;

import com.app.model.Microwave;
import com.app.repository.MicrowaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MicrowaveServiceImpl implements IMicrowaveService {

    private final MicrowaveRepository microwaveRepository;

    @Autowired
    public MicrowaveServiceImpl(MicrowaveRepository microwaveRepository) {
        this.microwaveRepository = microwaveRepository;
    }

    @Override
    public Microwave createMicrowave(Microwave microwave) {
        return microwaveRepository.save(microwave);
    }

    @Override
    public Optional<Microwave> getMicrowaveById(Long id) {
        return microwaveRepository.findById(id);
    }

    @Override
    public List<Microwave> getAllMicrowaves() {
        return microwaveRepository.findAll();
    }

    @Override
    public Microwave updateMicrowave(Long id, Microwave updatedMicrowave) {
        if (microwaveRepository.existsById(id)) {
            updatedMicrowave.setId(id);
            return microwaveRepository.save(updatedMicrowave);
        } else {
            // Handle the case where the microwave with the given ID doesn't exist
            return null;
        }
    }

    @Override
    public void deleteMicrowave(Long id) {
        microwaveRepository.deleteById(id);
    }

    @Override
    public List<Microwave> getMicrowavesByBrand(String brand) {
        return microwaveRepository.findByBrand(brand);
    }
}
