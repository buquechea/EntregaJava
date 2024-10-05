package com.PrimeraEntrega.PrimeraEntrega;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.PrimeraEntrega.PrimeraEntrega.model.Cliente;
import com.PrimeraEntrega.PrimeraEntrega.model.Disqueria;
import com.PrimeraEntrega.PrimeraEntrega.model.Producto;
import com.PrimeraEntrega.PrimeraEntrega.services.ClienteService;
import com.PrimeraEntrega.PrimeraEntrega.services.DisqueriaService;
import com.PrimeraEntrega.PrimeraEntrega.services.ProductoService;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class PrimeraEntregaApplication implements CommandLineRunner {
	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProductoService productoService;

	@Autowired
	private DisqueriaService disqueriaService;

	//se hace el override
	public static void main(String[] args) {
		SpringApplication.run(PrimeraEntregaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Creamos las disquerias");

		Disqueria disqueria1 = new Disqueria(null, "Disqueria del prog", "jujuy 5", "89912381238");
		Disqueria disqueria2 = new Disqueria(null, "Disqueria para el mundo", "sarmiento 67", "123812381239");

		disqueria1 = this.disqueriaService.saveDisqueria(disqueria1);
    	disqueria2 = this.disqueriaService.saveDisqueria(disqueria2);

		System.out.println("Creamos los productos/discos para las disquerias");

		Producto producto1 = new Producto(null, "Meddle", 10000.0,"Rock Progresivo", "Pink Floyd", disqueria1);
		Producto producto2 = new Producto(null, "A Love Supreme", 11500.0,"Jazz", "John Coltrane", disqueria1);
		Producto producto3 = new Producto(null, "Nowhere", 12500.0, "Shoegaze", "Ride", disqueria2);
		Producto producto4 = new Producto(null, "(What's The Story) Morning Glory?", 15000.0, "BritPop", "Oasis", disqueria2);

		this.productoService.saveProducto(producto1);
    	this.productoService.saveProducto(producto2);
    	this.productoService.saveProducto(producto3);
    	this.productoService.saveProducto(producto4);

		System.out.println("Creamos los clientes");

		Cliente cliente1 = new Cliente(null, "Pepe", "pepe@email.com", "56966666666", disqueria2);
		Cliente cliente2 = new Cliente(null, "Maria", "Maria@email.com", "56955555555", disqueria1);
		Cliente cliente3 = new Cliente(null, "Pablo", "Pablo@email.com", "56944444444", disqueria2);
		Cliente cliente4 = new Cliente(null, "Juan", "Juan@email.com", "56933333333", disqueria1);

		this.clienteService.saveCliente(cliente1);
		this.clienteService.saveCliente(cliente2);
		this.clienteService.saveCliente(cliente3);
		this.clienteService.saveCliente(cliente4);
		
		System.out.println("buscamos las disquerias");

		List<Disqueria> disquerias = this.disqueriaService.getAllDisquerias();

			for (Disqueria disqueria : disquerias) {
			System.out.println("ID: " + disqueria.getId() + ", Nombre: " + disqueria.getNombre() + ", Dirección: " + disqueria.getDireccion() + ", Teléfono: " + disqueria.getTelefono());
		}

		System.out.println("buscamos clientes de la disqueria 1");

		
		List<Cliente> clientesDisqueria1 = this.clienteService.getClientesByDisqueriaId(1l);

			for (Cliente cliente : clientesDisqueria1) {
				System.out.println("ID: " + cliente.getNombre() + ", Correo: " + cliente.getCorreo() + ", Telefono: " + cliente.getTelefono());
			}
		
		System.out.println("Probamos borrar un cliente que no existe");

		this.clienteService.deleteCliente(5l);

		
		System.out.println("añadimos más stock a un producto");
		
		this.productoService.updateStockProducto(2l, 10);
		
		Optional<Producto> productoBuscar = this.productoService.getProductoById(2l);

		if (productoBuscar.isPresent()) {
			Producto producto = productoBuscar.get();
			System.out.println("Producto ID: " + producto.getId());
			System.out.println("Stock actual: " + producto.getStock());
		} else {
			System.out.println("Producto no encontrado");
		}

	}

}