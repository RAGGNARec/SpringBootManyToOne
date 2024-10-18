package com.uisrael.TareaSemanaIII_ManyToOne.pruebas;

import com.uisrael.TareaSemanaIII_ManyToOne.entities.Cliente;
import com.uisrael.TareaSemanaIII_ManyToOne.entities.Pedido;
import com.uisrael.TareaSemanaIII_ManyToOne.repositories.ClienteRepository;
import com.uisrael.TareaSemanaIII_ManyToOne.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class Prueba implements CommandLineRunner {
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    public void run(String... args) throws Exception {
        // Crear cliente y pedido
        Cliente cliente = crearCliente();
        Pedido pedido = crearPedido(cliente);

        // Guardar en la base de datos
        pedidoRepository.save(pedido);
        System.out.println("Pedido guardado: " + pedido.getNombre() + " para el cliente: " + cliente.getNombre());

        // Editar el pedido
        editarPedido(pedido.getId(), "Pollo 1l con ensalada", 12.50);

        // Eliminar el pedido
        eliminarPedido(pedido.getId());

        // Eliminar cliente
        eliminarCliente(cliente.getId());
    }

    private Cliente crearCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Javier Alejandro");
        cliente.setDireccion("Cdl ibarra barrio la Merced");
        cliente.setTelefono("0979134557");
        cliente.setEmail("javier@gmail.com");
        return cliente;
    }

    private Pedido crearPedido(Cliente cliente) {
        Pedido pedido = new Pedido();
        pedido.setNombre("Pollo 1l con papas fritas");
        pedido.setTotal(10.50);
        pedido.setFechaPedido(LocalDate.now());
        pedido.setEstado("Activo");
        pedido.setCliente(cliente);
        return pedido;
    }

    private void editarPedido(Long pedidoId, String nuevoNombre, double nuevoTotal) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(pedidoId);
        if (pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();
            pedido.setNombre(nuevoNombre);
            pedido.setTotal(nuevoTotal);
            pedidoRepository.save(pedido);
            System.out.println("Pedido editado: " + pedido.getNombre());
        } else {
            System.out.println("Pedido no encontrado");
        }
    }

    private void eliminarPedido(Long pedidoId) {
        if (pedidoRepository.existsById(pedidoId)) {
            pedidoRepository.deleteById(pedidoId);
            System.out.println("Pedido eliminado con ID: " + pedidoId);
        } else {
            System.out.println("Pedido no encontrado");
        }
    }

    private void eliminarCliente(Long clienteId) {
        if (clienteRepository.existsById(clienteId)) {
            clienteRepository.deleteById(clienteId);
            System.out.println("Cliente eliminado con ID: " + clienteId);
        } else {
            System.out.println("Cliente no encontrado");
        }
    }
}
