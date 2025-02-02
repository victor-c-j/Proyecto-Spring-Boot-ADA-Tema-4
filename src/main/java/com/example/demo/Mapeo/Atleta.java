package com.example.demo.Mapeo;

import jakarta.persistence.*;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "atleta")
public class Atleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Debe estar presente
    @Column(name = "id_atleta")
    private Integer id;

    @NotNull(message = "El género no puede ser nulo")
    @Pattern(regexp = "M|F", message = "El género debe ser 'M' o 'F'")
    @Column(name = "genero", nullable = false)
    private char genero;

    @NotNull(message = "La altura no puede ser nula")
    @Min(value = 0, message = "La altura debe ser positiva")
    @Column(name = "altura", nullable = false)
    private Float altura;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    @Column(name = "nombre_completo", nullable = false)
    private String nombreCompleto;

    @ManyToMany
    @JoinTable(name = "region_atleta", // Nombre de la tabla que ya has creado en la base de datos
            joinColumns = @JoinColumn(name = "id_atleta"), // Columna que se refiere a la entidad Atleta
            inverseJoinColumns = @JoinColumn(name = "id_region") // Columna que se refiere a la entidad Region
    )
    @JsonIgnoreProperties("atletas") // Ignora la lista de atletas en Region para evitar ciclos
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
