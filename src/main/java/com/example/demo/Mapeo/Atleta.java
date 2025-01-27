package com.example.demo.Mapeo;

import jakarta.persistence.*;

@Entity
@Table(name = "atletas")
public class Atleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "nombre_completo", nullable = false, length = 100)
    private String nombreCompleto;

    @Column(name = "region", nullable = false, length = 50)
    private String region;

    @Column(name = "codigo_region", nullable = false, length = 10)
    private String codigoRegion;

    @Column(name = "juegos_olimpicos_participados", nullable = false)
    private int juegosOlimpicosParticipados;

    @Column(name = "primer_juego_olimpico", nullable = false)
    private int primerJuegoOlimpico;

    @Column(name = "oro", nullable = false)
    private int oro;

    @Column(name = "plata", nullable = false)
    private int plata;

    @Column(name = "bronce", nullable = false)
    private int bronce;

    @Column(name = "total_medallas", nullable = false)
    private int totalMedallas;

    @Column(name = "genero", nullable = false, length = 1)
    private char genero;

    @Column(name = "altura", nullable = false)
    private float altura;

    // Constructor por defecto
    public Atleta() {
    }

    // Constructor con todos los parámetros (excepto el ID porque es autogenerado)
    public Atleta(String nombreCompleto, String region, String codigoRegion, int juegosOlimpicosParticipados,
                  int primerJuegoOlimpico, int oro, int plata, int bronce, int totalMedallas, char genero, float altura) {
        this.nombreCompleto = nombreCompleto;
        this.region = region;
        this.codigoRegion = codigoRegion;
        this.juegosOlimpicosParticipados = juegosOlimpicosParticipados;
        this.primerJuegoOlimpico = primerJuegoOlimpico;
        this.oro = oro;
        this.plata = plata;
        this.bronce = bronce;
        this.totalMedallas = totalMedallas;
        this.genero = genero;
        this.altura = altura;
    }

    // Getters y Setters
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCodigoRegion() {
        return codigoRegion;
    }

    public void setCodigoRegion(String codigoRegion) {
        this.codigoRegion = codigoRegion;
    }

    public int getJuegosOlimpicosParticipados() {
        return juegosOlimpicosParticipados;
    }

    public void setJuegosOlimpicosParticipados(int juegosOlimpicosParticipados) {
        this.juegosOlimpicosParticipados = juegosOlimpicosParticipados;
    }

    public int getPrimerJuegoOlimpico() {
        return primerJuegoOlimpico;
    }

    public void setPrimerJuegoOlimpico(int primerJuegoOlimpico) {
        this.primerJuegoOlimpico = primerJuegoOlimpico;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

    public int getPlata() {
        return plata;
    }

    public void setPlata(int plata) {
        this.plata = plata;
    }

    public int getBronce() {
        return bronce;
    }

    public void setBronce(int bronce) {
        this.bronce = bronce;
    }

    public int getTotalMedallas() {
        return totalMedallas;
    }

    public void setTotalMedallas(int totalMedallas) {
        this.totalMedallas = totalMedallas;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Atleta{" +
                "Id=" + Id +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", region='" + region + '\'' +
                ", codigoRegion='" + codigoRegion + '\'' +
                ", juegosOlimpicosParticipados=" + juegosOlimpicosParticipados +
                ", primerJuegoOlimpico=" + primerJuegoOlimpico +
                ", oro=" + oro +
                ", plata=" + plata +
                ", bronce=" + bronce +
                ", totalMedallas=" + totalMedallas +
                ", genero='" + genero + '\'' +
                ", altura=" + altura +
                '}';
    }
}
