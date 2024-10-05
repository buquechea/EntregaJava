package com.PrimeraEntrega.PrimeraEntrega.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PrimeraEntrega.PrimeraEntrega.model.Cliente;
import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByDisqueriaId(Long disqueriaId);
    List<Cliente> findByNombre(String nombre);

}