package com.PrimeraEntrega.PrimeraEntrega.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrimeraEntrega.PrimeraEntrega.model.Cliente;
import com.PrimeraEntrega.PrimeraEntrega.model.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }
    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }
    public List<Cliente> getClientesByDisqueriaId(Long disqueriaId) {
        return clienteRepository.findByDisqueriaId(disqueriaId);
    }
    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    public void deleteCliente(Long id) {
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        } else {
            System.out.println("el cliente no existe");
        }
    }

    public List<Cliente> findClienteByNombre(String nombre) {
        return clienteRepository.findByNombre(nombre);
    }
}