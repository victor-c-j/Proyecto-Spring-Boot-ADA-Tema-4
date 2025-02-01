package com.example.demo.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Mapeo.CompetidorJuegoOlimpico;
import com.example.demo.Mapeo.Region;
import com.example.demo.Repository.CompetidorJuegoOlimpicoRepository;
import com.example.demo.Repository.RegionRepository;

@RestController
@RequestMapping("/olimpiadaSpring/competidor")
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
    public CompetidorJuegoOlimpico create(@RequestBody CompetidorJuegoOlimpico competidor) {
        return competidorRepository.save(competidor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetidorJuegoOlimpico> getById(@PathVariable Integer id) {
        return competidorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompetidorJuegoOlimpico> update(@PathVariable Integer id, @RequestBody CompetidorJuegoOlimpico competidorDetails) {
        return competidorRepository.findById(id).map(competidor -> {
            competidor.setAtleta(competidorDetails.getAtleta());
            competidor.setIdJuegoOlimpico(competidorDetails.getIdJuegoOlimpico());
            competidor.setEdad(competidorDetails.getEdad());
            return ResponseEntity.ok(competidorRepository.save(competidor));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (competidorRepository.existsById(id)) {
            competidorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
