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

import com.example.demo.Mapeo.CompetidorJuegoOlimpico;
import com.example.demo.Repository.CompetidorJuegoOlimpicoRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/olimpiadas/competidor")
public class CompetidorJuegoOlimpicoController {
    private final CompetidorJuegoOlimpicoRepository competidorRepository;

    public CompetidorJuegoOlimpicoController(CompetidorJuegoOlimpicoRepository competidorRepository) {
        this.competidorRepository = competidorRepository;
    }

    @GetMapping
    public List<CompetidorJuegoOlimpico> getAll() {
        return competidorRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CompetidorJuegoOlimpico competidor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(competidorRepository.save(competidor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        return competidorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Competidor no encontrado"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody CompetidorJuegoOlimpico competidorDetails) {
        return competidorRepository.findById(id).map(competidor -> {
            competidor.setAtleta(competidorDetails.getAtleta());
            competidor.setIdJuegoOlimpico(competidorDetails.getIdJuegoOlimpico());
            competidor.setEdad(competidorDetails.getEdad());
            return ResponseEntity.ok(competidorRepository.save(competidor));
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Competidor no encontrado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!competidorRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Competidor no encontrado");
        }
        competidorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
