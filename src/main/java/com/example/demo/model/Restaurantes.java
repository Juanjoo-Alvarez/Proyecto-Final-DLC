package com.example.demo.model;

// Importa las librerías necesarias
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Se crea la clase Restaurantes
@Entity
public class Restaurantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String imagen;
    private Double promedio;
    private Integer numeroResenas; // Nueva columna

//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public Integer getNumeroResenas() {
        return numeroResenas;
    }

    public void setNumeroResenas(Integer numeroResenas) {
        this.numeroResenas = numeroResenas;
    }
}
