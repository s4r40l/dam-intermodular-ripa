package controller;

import DAO.ProductoDAO;
import DAO.SupermercadoDAO;
import DAO.RegistroPrecioDAO;

import model.Producto;
import model.Supermercado;
import model.RegistroPrecio;

import java.time.LocalDate;
import java.util.List;

public class RegistroPrecioController {

    private final RegistroPrecioDAO registroDAO = new RegistroPrecioDAO();
    private final ProductoDAO productoDAO = new ProductoDAO();
    private final SupermercadoDAO supermercadoDAO = new SupermercadoDAO();

    // Crear registro de precio con validaciones
    public boolean crearRegistro(int idProducto, int idSupermercado, LocalDate fecha, double precio) {

        // Validar producto
        Producto producto = productoDAO.findById(idProducto);
        if (producto == null) {
            System.out.println("El producto no existe.");
            return false;
        }

        // Validar supermercado
        Supermercado supermercado = supermercadoDAO.findById(idSupermercado);
        if (supermercado == null) {
            System.out.println("El supermercado no existe.");
            return false;
        }

        // Validar precio
        if (precio <= 0) {
            System.out.println("El precio debe ser mayor que 0.");
            return false;
        }

        // Validar fecha
        if (fecha == null) {
            System.out.println("La fecha no puede ser nula.");
            return false;
        }

        RegistroPrecio nuevo = new RegistroPrecio(producto, supermercado, fecha, precio);
        return registroDAO.create(nuevo);
    }

    // Listar todos los registros
    public List<RegistroPrecio> listarRegistros() {
        return registroDAO.findAll();
    }

    // Buscar registros por producto
    public List<RegistroPrecio> listarRegistrosPorProducto(int idProducto) {

        if (productoDAO.findById(idProducto) == null) {
            System.out.println("El producto no existe.");
            return null;
        }

        return registroDAO.findByProducto(idProducto);
    }

    // Buscar registro por ID
    public RegistroPrecio buscarRegistro(int idRegistro) {
        if (idRegistro <= 0) {
            System.out.println("ID inválido.");
            return null;
        }
        return registroDAO.findById(idRegistro);
    }

    // Actualizar registro
    public boolean actualizarRegistro(int idRegistro, int idProducto, int idSupermercado, LocalDate fecha, double precio) {

        RegistroPrecio existente = registroDAO.findById(idRegistro);
        if (existente == null) {
            System.out.println("No existe un registro con ese ID.");
            return false;
        }

        // Validar producto
        Producto producto = productoDAO.findById(idProducto);
        if (producto == null) {
            System.out.println("El producto no existe.");
            return false;
        }

        // Validar supermercado
        Supermercado supermercado = supermercadoDAO.findById(idSupermercado);
        if (supermercado == null) {
            System.out.println("El supermercado no existe.");
            return false;
        }

        // Validar precio
        if (precio <= 0) {
            System.out.println("El precio debe ser mayor que 0.");
            return false;
        }

        // Validar fecha
        if (fecha == null || fecha.isAfter(LocalDate.now())) {
            System.out.println("Fecha inválida.");
            return false;
        }

        existente.setProducto(producto);
        existente.setSupermercado(supermercado);
        existente.setFecha(fecha);
        existente.setPrecio(precio);

        return registroDAO.update(existente);
    }

    // Eliminar registro
    public boolean eliminarRegistro(int idRegistro) {

        RegistroPrecio existente = registroDAO.findById(idRegistro);
        if (existente == null) {
            System.out.println("No existe un registro con ese ID.");
            return false;
        }

        return registroDAO.delete(idRegistro);
    }

    // MÉTODOS DE CONSOLA

    public void crearRegistroConsola(java.util.Scanner teclado) {
        System.out.print("ID del producto: ");
        int idProducto = Integer.parseInt(teclado.nextLine());

        System.out.print("ID del supermercado: ");
        int idSuper = Integer.parseInt(teclado.nextLine());

        System.out.print("Precio: ");
        double precio = Double.parseDouble(teclado.nextLine());

        System.out.print("Fecha (YYYY-MM-DD): ");
        String fechaStr = teclado.nextLine();

        LocalDate fecha;
        try {
            fecha = LocalDate.parse(fechaStr);
        } catch (Exception e) {
            System.out.println("Formato de fecha inválido.");
            return;
        }

        boolean ok = crearRegistro(idProducto, idSuper, fecha, precio);

        if (ok) {
            System.out.println("Registro de precio creado correctamente.");
        } else {
            System.out.println("No se pudo crear el registro.");
        }
    }

    public void listarRegistrosConsola() {
        List<RegistroPrecio> lista = listarRegistros();

        if (lista.isEmpty()) {
            System.out.println("No hay registros de precios.");
            return;
        }

        System.out.println("\n--- LISTA DE REGISTROS DE PRECIOS ---");
        for (RegistroPrecio rp : lista) {
            System.out.println("ID: " + rp.getId() +
                    " | Producto: " + rp.getProducto().getNombre() +
                    " | Supermercado: " + rp.getSupermercado().getNombre() +
                    " | Fecha: " + rp.getFecha() +
                    " | Precio: " + rp.getPrecio());
        }
    }

    public void eliminarRegistroConsola(java.util.Scanner teclado) {
        System.out.print("ID del registro a eliminar: ");
        int id = Integer.parseInt(teclado.nextLine());

        boolean ok = eliminarRegistro(id);

        if (ok) {
            System.out.println("Registro eliminado.");
        } else {
            System.out.println("No se pudo eliminar el registro.");
        }
    }


}

