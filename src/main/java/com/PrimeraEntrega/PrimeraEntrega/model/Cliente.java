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
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correo;
    private String telefono;

    public Cliente() {
    }

    public Cliente(Long id, String nombre, String correo, String telefono, Disqueria disqueria) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.disqueria = disqueria;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "disqueria_id")
    private Disqueria disqueria;


}