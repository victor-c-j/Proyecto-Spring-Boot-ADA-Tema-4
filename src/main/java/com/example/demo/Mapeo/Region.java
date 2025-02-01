package com.example.demo.Mapeo;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_region")
    private Integer id;

    @Column(name = "noc", nullable = false, length = 3)
    private String noc;

    @Column(name = "nombre_region", nullable = false, length = 100)
    private String nombreRegion;

    @ManyToMany(mappedBy = "regiones")
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
