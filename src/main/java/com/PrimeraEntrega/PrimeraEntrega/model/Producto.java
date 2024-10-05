package com.PrimeraEntrega.PrimeraEntrega.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nombre;
    private Double precio;
    private String genero;
    private String artista;

    public Producto() {
    }

    public Producto(Long id, String nombre, Double precio, String genero, String artista, Disqueria disqueria) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.genero = genero;
        this.artista = artista;
        this.disqueria = disqueria;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "disqueria_id")
    private Disqueria disqueria;

    public int getStock() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStock'");
    }

    public void setStock(int i) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setStock'");
    }

}