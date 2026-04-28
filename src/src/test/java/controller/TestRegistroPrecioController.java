package controller;

import model.RegistroPrecio;
import model.Producto;
import model.Supermercado;

import java.time.LocalDate;

public class TestRegistroPrecioController {

    public static void main(String[] args) {

        RegistroPrecioController controller = new RegistroPrecioController();
        ProductoController productoController = new ProductoController();
        SupermercadoController supermercadoController = new SupermercadoController();

        System.out.println("=== CREAR PRODUCTO Y SUPERMERCADO TEMPORALES ===");
        productoController.crearProducto("ProductoPrecioTest", "Test", "unidad");
        supermercadoController.crearSupermercado("SuperPrecioTest");

        Producto p = productoController.listarProductos().getLast();
        Supermercado s = supermercadoController.listarSupermercados().getLast();

        System.out.println("\n=== CREAR REGISTRO DE PRECIO ===");
        boolean creado = controller.crearRegistro(p.getId(), s.getId(), LocalDate.now(), 2.99);
        System.out.println("Creado: " + creado);

        System.out.println("\n=== LISTAR REGISTROS ===");
        controller.listarRegistros().forEach(System.out::println);

        RegistroPrecio ultimo = controller.listarRegistros().getLast();

        System.out.println("\n=== BUSCAR REGISTRO ===");
        System.out.println("Encontrado: " + controller.buscarRegistro(ultimo.getId()));

        System.out.println("\n=== ACTUALIZAR REGISTRO ===");
        boolean actualizado = controller.actualizarRegistro(
                ultimo.getId(),
                p.getId(),
                s.getId(),
                LocalDate.now(),
                3.49
        );
        System.out.println("Actualizado: " + actualizado);

        System.out.println("\n=== BORRAR REGISTRO ===");
        boolean borrado = controller.eliminarRegistro(ultimo.getId());
        System.out.println("Borrado: " + borrado);
    }
}
