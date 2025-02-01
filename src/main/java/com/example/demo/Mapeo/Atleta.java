package com.example.demo.Mapeo;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "atleta")
public class Atleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atleta")
    private Integer id;

    @Column(name = "genero", nullable = false)
    private char genero;

    @Column(name = "altura", nullable = false)
    private float altura;

    @Column(name = "nombre_completo", nullable = false, length = 100)
    private String nombreCompleto;

    @ManyToMany
    @JoinTable(
        name = "atleta_region",
        joinColumns = @JoinColumn(name = "id_atleta"),
        inverseJoinColumns = @JoinColumn(name = "id_region")
    )
    private Set<Region> regiones;


    public Atleta() {
    }

    public Atleta(Integer id, char genero, float altura, String nombreCompleto, Set<Region> regiones) {
        this.id = id;
        this.genero = genero;
        this.altura = altura;
        this.nombreCompleto = nombreCompleto;
        this.regiones = regiones;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public char getGenero() {
        return this.genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public float getAltura() {
        return this.altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Set<Region> getRegiones() {
        return this.regiones;
    }

    public void setRegiones(Set<Region> regiones) {
        this.regiones = regiones;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", genero='" + getGenero() + "'" +
            ", altura='" + getAltura() + "'" +
            ", nombreCompleto='" + getNombreCompleto() + "'" +
            ", regiones='" + getRegiones() + "'" +
            "}";
    }

}
