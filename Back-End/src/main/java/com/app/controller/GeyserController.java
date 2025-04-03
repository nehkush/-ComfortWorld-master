package com.app.controller;

import com.app.model.Geyser;
import com.app.service.IGeyserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://localhost:5173")
@RequestMapping("/geysers")
public class GeyserController {

    private final IGeyserService geyserService;

    @Autowired
    public GeyserController(IGeyserService geyserService) {
        this.geyserService = geyserService;
    }

    @PostMapping
    public ResponseEntity<Geyser> createGeyser(@RequestBody Geyser geyser) {
        Geyser createdGeyser = geyserService.createGeyser(geyser);
        return new ResponseEntity<>(createdGeyser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Geyser> getGeyserById(@PathVariable Long id) {
        Optional<Geyser> geyser = geyserService.getGeyserById(id);
        return geyser.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Geyser>> getAllGeysers() {
        List<Geyser> geysers = geyserService.getAllGeysers();
        return new ResponseEntity<>(geysers, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Geyser> updateGeyser(@PathVariable Long id, @RequestBody Geyser updatedGeyser) {
        Geyser geyser = geyserService.updateGeyser(id, updatedGeyser);
        return geyser != null ?
                new ResponseEntity<>(geyser, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGeyser(@PathVariable Long id) {
        geyserService.deleteGeyser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/byBrand")
    public ResponseEntity<List<Geyser>> getGeysersByBrand(@RequestParam String brand) {
        List<Geyser> geysers = geyserService.getGeysersByBrand(brand);
        return new ResponseEntity<>(geysers, HttpStatus.OK);
    }
}
