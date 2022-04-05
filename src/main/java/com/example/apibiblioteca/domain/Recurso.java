package com.example.apibiblioteca.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document(collection = "recursos")
public class Recurso {
    @Id
    private String id = UUID.randomUUID().toString().substring(0,10);
    private String titulo;
    private Boolean prestado;
    private LocalDate fechaPrestamos;
    private String tipo;
    private String tematica;

    public Recurso(){

    }

    public Recurso(String id, String titulo, boolean prestado, LocalDate fechaPrestamos, String tipo, String tematica) {
        this.id = id;
        this.titulo = titulo;
        this.prestado = prestado;
        this.fechaPrestamos = fechaPrestamos;
        this.tipo = tipo;
        this.tematica = tematica;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public Boolean getPrestado(){return prestado;}

    public LocalDate getFechaPrestamos() {
        return fechaPrestamos;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTematica() {
        return tematica;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPrestado(Boolean prestado) {
        this.prestado = prestado;
    }

    public void setFechaPrestamos(LocalDate fechaPrestamos) {
        this.fechaPrestamos = fechaPrestamos;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }
}
