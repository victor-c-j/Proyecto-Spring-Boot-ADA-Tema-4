package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Mapeo.Atleta;

public interface AtletaRepository extends JpaRepository<Atleta, Integer> {

}
