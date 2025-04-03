package com.app.service;

import com.app.model.WashingMachine;
import com.app.repository.WashingMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WashingMachineServiceImpl implements IWashingMachineService {

    private final WashingMachineRepository washingMachineRepository;

    @Autowired
    public WashingMachineServiceImpl(WashingMachineRepository washingMachineRepository) {
        this.washingMachineRepository = washingMachineRepository;
    }

    @Override
    public WashingMachine createWashingMachine(WashingMachine washingMachine) {
        return washingMachineRepository.save(washingMachine);
    }

    @Override
    public Optional<WashingMachine> getWashingMachineById(Long id) {
        return washingMachineRepository.findById(id);
    }

    @Override
    public List<WashingMachine> getAllWashingMachines() {
        return washingMachineRepository.findAll();
    }

    @Override
    public WashingMachine updateWashingMachine(Long id, WashingMachine updatedWashingMachine) {
        if (washingMachineRepository.existsById(id)) {
            updatedWashingMachine.setId(id);
            return washingMachineRepository.save(updatedWashingMachine);
        } else {
            // Handle the case where the washing machine with the given ID doesn't exist
            return null;
        }
    }

    @Override
    public void deleteWashingMachine(Long id) {
        washingMachineRepository.deleteById(id);
    }

    @Override
    public List<WashingMachine> getWashingMachinesByBrand(String brand) {
        return washingMachineRepository.findByBrand(brand);
    }
}
