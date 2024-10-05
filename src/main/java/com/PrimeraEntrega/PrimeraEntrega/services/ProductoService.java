package com.PrimeraEntrega.PrimeraEntrega.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PrimeraEntrega.PrimeraEntrega.model.repository.ProductoRepository;
import java.util.List;
import java.util.Optional;
import com.PrimeraEntrega.PrimeraEntrega.model.Producto;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getAllProductos(){
        return productoRepository.findAll();
    }

    public Optional<Producto> getProductoById(Long id){
        return productoRepository.findById(id);
    }

    public List<Producto> getProductosByDisqueriaId(Long disqueriaId) {
        return productoRepository.findByDisqueriaId(disqueriaId);
    }

    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void deleteProducto(Long id) {
        if(productoRepository.existsById(id)){
            productoRepository.deleteById(id);
        } else {
            System.out.println("el producto no existe");
        }
    }

    public void updateStockProducto(Long productoId, int nuevoStock){

        Optional<Producto> productoOpt = productoRepository.findById(productoId);

        if (productoOpt.isPresent()) {
            Producto producto = productoOpt.get();
            int stockActual = producto.getStock();
            producto.setStock(stockActual + nuevoStock);
            productoRepository.save(producto);
        } else {
            throw new RuntimeException("Producto no encontrado con id: " + productoId);
        }
    }
}