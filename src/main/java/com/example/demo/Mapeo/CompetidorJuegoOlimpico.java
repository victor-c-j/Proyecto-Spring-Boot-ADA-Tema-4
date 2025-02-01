package com.example.demo.Mapeo;

import jakarta.persistence.*;

@Entity
@Table(name = "competidor_juego_olimpico")
public class CompetidorJuegoOlimpico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_competidores")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_atleta", nullable = false)
    private Atleta atleta;

    @Column(name = "id_juego_olimpico", nullable = false)
    private Integer idJuegoOlimpico;

    @Column(name = "edad", nullable = false)
    private int edad;


    public CompetidorJuegoOlimpico() {
    }

    public CompetidorJuegoOlimpico(Integer id, Atleta atleta, Integer idJuegoOlimpico, int edad) {
        this.id = id;
        this.atleta = atleta;
        this.idJuegoOlimpico = idJuegoOlimpico;
        this.edad = edad;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Atleta getAtleta() {
        return this.atleta;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    public Integer getIdJuegoOlimpico() {
        return this.idJuegoOlimpico;
    }

    public void setIdJuegoOlimpico(Integer idJuegoOlimpico) {
        this.idJuegoOlimpico = idJuegoOlimpico;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", atleta='" + getAtleta() + "'" +
            ", idJuegoOlimpico='" + getIdJuegoOlimpico() + "'" +
            ", edad='" + getEdad() + "'" +
            "}";
    }

}