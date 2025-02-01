package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Mapeo.Region;

public interface RegionRepository extends JpaRepository<Region, Integer> {

}