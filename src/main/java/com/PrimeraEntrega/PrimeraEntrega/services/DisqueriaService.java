package com.PrimeraEntrega.PrimeraEntrega.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrimeraEntrega.PrimeraEntrega.model.Disqueria;
import com.PrimeraEntrega.PrimeraEntrega.model.repository.DisqueriaRepository;
import java.util.List;
import java.util.Optional;

@Service
public class DisqueriaService {
    @Autowired
    private DisqueriaRepository disqueriaRepository;

    public List<Disqueria> getAllDisquerias(){
        return disqueriaRepository.findAll();
    }

    public Optional<Disqueria> getDisqueriaById(Long id){
        return disqueriaRepository.findById(id);
    }

    public Disqueria saveDisqueria(Disqueria disqueria){
        return disqueriaRepository.save(disqueria);
    }
    
    public void deleteDisqueria(Long id){
        if (disqueriaRepository.existsById(id)){
            disqueriaRepository.deleteById(id);
        } else {
            System.out.println("La disqueria no existe");
        }
    }

    public List<Disqueria> findPanaderiaByNombre(String nombre){
        return disqueriaRepository.findByNombre(nombre);
    }
}