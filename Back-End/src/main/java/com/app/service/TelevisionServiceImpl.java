package com.app.service;

import com.app.model.Television;
import com.app.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TelevisionServiceImpl implements ITelevisionService {

    private final TelevisionRepository televisionRepository;

    @Autowired
    public TelevisionServiceImpl(TelevisionRepository televisionRepository) {
        this.televisionRepository = televisionRepository;
    }

    @Override
    public Television createTelevision(Television television) {
        return televisionRepository.save(television);
    }

    @Override
    public Optional<Television> getTelevisionById(Long id) {
        return televisionRepository.findById(id);
    }

    @Override
    public List<Television> getAllTelevisions() {
        return televisionRepository.findAll();
    }

    @Override
    public Television updateTelevision(Long id, Television updatedTelevision) {
        if (televisionRepository.existsById(id)) {
            updatedTelevision.setId(id);
            return televisionRepository.save(updatedTelevision);
        } else {
            // Handle the case where the television with the given ID doesn't exist
            return null;
        }
    }

    @Override
    public void deleteTelevision(Long id) {
        televisionRepository.deleteById(id);
    }

    @Override
    public List<Television> getTelevisionsByBrand(String brand) {
        return televisionRepository.findByBrand(brand);
    }
}
