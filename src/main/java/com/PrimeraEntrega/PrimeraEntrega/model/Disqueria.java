package com.PrimeraEntrega.PrimeraEntrega.model;


import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Disqueria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;
    private String telefono;

    public Disqueria() {
    }

    public Disqueria(Long id, String nombre, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    @OneToMany(mappedBy = "disqueria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Producto> productos;

    @OneToMany(mappedBy = "disqueria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Cliente> clientes;

}