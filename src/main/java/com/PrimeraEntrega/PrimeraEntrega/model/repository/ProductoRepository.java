package com.PrimeraEntrega.PrimeraEntrega.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PrimeraEntrega.PrimeraEntrega.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto> findByDisqueriaId(Long disqueriaId);
}
