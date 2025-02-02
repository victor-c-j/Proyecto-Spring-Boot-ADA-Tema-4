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

import com.example.demo.Mapeo.Atleta;
import com.example.demo.Repository.AtletaRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/olimpiadas/atleta")
public class AtletaController {
    private final AtletaRepository atletaRepository;

    public AtletaController(AtletaRepository atletaRepository) {
        this.atletaRepository = atletaRepository;
    }

    @GetMapping
    public List<Atleta> getAll() {
        return atletaRepository.findAll();
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> create(@Valid @RequestBody Atleta atleta) {
        atleta.setId(null); // Asegurar que el ID sea null antes de guardar
        Atleta nuevoAtleta = atletaRepository.save(atleta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAtleta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return atletaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Atleta no encontrado"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody Atleta atletaDetails) {
        return atletaRepository.findById(id).map(atleta -> {
            atleta.setGenero(atletaDetails.getGenero());
            atleta.setAltura(atletaDetails.getAltura());
            atleta.setNombreCompleto(atletaDetails.getNombreCompleto());
            return ResponseEntity.ok(atletaRepository.save(atleta));
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Atleta no encontrado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!atletaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Atleta no encontrado");
        }
        atletaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}