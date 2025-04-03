package com.app.service;

import com.app.model.Geyser;
import com.app.repository.GeyserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeyserServiceImpl implements IGeyserService {

    private final GeyserRepository geyserRepository;

    @Autowired
    public GeyserServiceImpl(GeyserRepository geyserRepository) {
        this.geyserRepository = geyserRepository;
    }

    @Override
    public Geyser createGeyser(Geyser geyser) {
        return geyserRepository.save(geyser);
    }

    @Override
    public Optional<Geyser> getGeyserById(Long id) {
        return geyserRepository.findById(id);
    }

    @Override
    public List<Geyser> getAllGeysers() {
        return geyserRepository.findAll();
    }

    @Override
    public Geyser updateGeyser(Long id, Geyser updatedGeyser) {
        if (geyserRepository.existsById(id)) {
            updatedGeyser.setId(id);
            return geyserRepository.save(updatedGeyser);
        } else {
            // Handle the case where the geyser with the given ID doesn't exist
            return null;
        }
    }

    @Override
    public void deleteGeyser(Long id) {
        geyserRepository.deleteById(id);
    }

    @Override
    public List<Geyser> getGeysersByBrand(String brand) {
        return geyserRepository.findByBrand(brand);
    }
}
