package com.example.demo.Mapeo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_region")
    private Integer id;

    @NotBlank(message = "El NOC no puede estar vacío")
    @Size(min = 3, max = 3, message = "El NOC debe tener exactamente 3 caracteres")
    @Column(name = "noc", nullable = false, length = 3)
    private String noc;

    @NotBlank(message = "El nombre de la región no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    @Column(name = "nombre_region", nullable = false, length = 100)
    private String nombreRegion;

    @ManyToMany(mappedBy = "regiones")
    @JsonIgnoreProperties("regiones") // Ignora la lista de regiones en Atleta
    private Set<Atleta> atletas;

    public Region() {
    }

    public Region(Integer id, String noc, String nombreRegion, Set<Atleta> atletas) {
        this.id = id;
        this.noc = noc;
        this.nombreRegion = nombreRegion;
        this.atletas = atletas;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoc() {
        return this.noc;
    }

    public void setNoc(String noc) {
        this.noc = noc;
    }

    public String getNombreRegion() {
        return this.nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    public Set<Atleta> getAtletas() {
        return this.atletas;
    }

    public void setAtletas(Set<Atleta> atletas) {
        this.atletas = atletas;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", noc='" + getNoc() + "'" +
                ", nombreRegion='" + getNombreRegion() + "'" +
                ", atletas='" + getAtletas() + "'" +
                "}";
    }

}
