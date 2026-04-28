package DAO;

import model.Producto;
import model.Supermercado;
import model.RegistroPrecio;

import java.time.LocalDate;
import java.util.List;

public class TestRegistroPrecioDAO {

    public static void main(String[] args) {

        ProductoDAO productoDAO = new ProductoDAO();
        SupermercadoDAO supermercadoDAO = new SupermercadoDAO();
        RegistroPrecioDAO registroDAO = new RegistroPrecioDAO();

        System.out.println("=== CREAR PRODUCTO TEMPORAL ===");
        Producto p = new Producto("ProductoTempRP", "Test", "unidad");
        productoDAO.create(p);

        List<Producto> productos = productoDAO.findAll();
        Producto ultimoProducto = productos.get(productos.size() - 1);
        System.out.println("Producto temporal: " + ultimoProducto);

        System.out.println("\n=== CREAR SUPERMERCADO TEMPORAL ===");
        Supermercado s = new Supermercado("SuperTempRP");
        supermercadoDAO.create(s);

        List<Supermercado> supermercados = supermercadoDAO.findAll();
        Supermercado ultimoSuper = supermercados.get(supermercados.size() - 1);
        System.out.println("Supermercado temporal: " + ultimoSuper);

        System.out.println("\n=== CREAR REGISTRO DE PRECIO TEMPORAL ===");
        RegistroPrecio rp = new RegistroPrecio(
                ultimoProducto,
                ultimoSuper,
                LocalDate.now(),
                9.99
        );

        boolean creado = registroDAO.create(rp);
        System.out.println("Registro creado: " + creado);

        System.out.println("\n=== LISTAR TODOS LOS REGISTROS ===");
        registroDAO.findAll().forEach(System.out::println);

        System.out.println("\n=== BUSCAR REGISTRO POR PRODUCTO ===");
        List<RegistroPrecio> registrosProducto = registroDAO.findByProducto(ultimoProducto.getId());
        registrosProducto.forEach(System.out::println);

        // Obtener el ID del registro recién creado
        RegistroPrecio ultimoRegistro = registrosProducto.get(registrosProducto.size() - 1);
        System.out.println("\nRegistro temporal encontrado: " + ultimoRegistro);

        System.out.println("\n=== ACTUALIZAR REGISTRO ===");
        ultimoRegistro.setPrecio(7.49);
        boolean actualizado = registroDAO.update(ultimoRegistro);
        System.out.println("Actualizado: " + actualizado);

        System.out.println("\n=== BORRAR REGISTRO ===");
        boolean borradoRegistro = registroDAO.delete(ultimoRegistro.getId());
        System.out.println("Registro borrado: " + borradoRegistro);

        System.out.println("\n=== BORRAR PRODUCTO Y SUPERMERCADO TEMPORALES ===");
        boolean borradoProducto = productoDAO.delete(ultimoProducto.getId());
        boolean borradoSuper = supermercadoDAO.delete(ultimoSuper.getId());

        System.out.println("Producto temporal borrado: " + borradoProducto);
        System.out.println("Supermercado temporal borrado: " + borradoSuper);
    }
}

