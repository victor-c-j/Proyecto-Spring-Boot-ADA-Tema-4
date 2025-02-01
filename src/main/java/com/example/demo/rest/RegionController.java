package com.example.demo.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Mapeo.Region;
import com.example.demo.Repository.RegionRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/olimpiadas/region")
public class RegionController {
    private final RegionRepository regionRepository;

    public RegionController(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @GetMapping
    public List<Region> getAll() {
        return regionRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Region region) {
        return ResponseEntity.status(HttpStatus.CREATED).body(regionRepository.save(region));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return regionRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Región no encontrada"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody Region regionDetails) {
        return regionRepository.findById(id).map(region -> {
            region.setNoc(regionDetails.getNoc());
            region.setNombreRegion(regionDetails.getNombreRegion());
            return ResponseEntity.ok(regionRepository.save(region));
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Región no encontrada"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!regionRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Región no encontrada");
        }
        regionRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}