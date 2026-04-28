package controller;

import DAO.ProductoDAO;
import model.Producto;

import java.util.List;

public class ProductoController {

    private final ProductoDAO productoDAO = new ProductoDAO();

    // Crear producto con validaciones
    public boolean crearProducto(String nombre, String categoria, String unidadMedida) {

        if (nombre == null || nombre.isBlank()) {
            System.out.println("El nombre no puede estar vacío.");
            return false;
        }

        if (categoria == null || categoria.isBlank()) {
            System.out.println("La categoría no puede estar vacía.");
            return false;
        }

        if (unidadMedida == null || unidadMedida.isBlank()) {
            System.out.println("La unidad de medida no puede estar vacía.");
            return false;
        }

        // Evitar duplicados por nombre
        List<Producto> existentes = productoDAO.findAll();
        boolean duplicado = existentes.stream()
                .anyMatch(p -> p.getNombre().equalsIgnoreCase(nombre));

        if (duplicado) {
            System.out.println("Ya existe un producto con ese nombre.");
            return false;
        }

        Producto nuevo = new Producto(nombre, categoria, unidadMedida);
        return productoDAO.create(nuevo);
    }

    // Listar productos
    public List<Producto> listarProductos() {
        return productoDAO.findAll();
    }

    // Buscar por ID
    public Producto buscarProducto(int id) {
        if (id <= 0) {
            System.out.println("ID inválido.");
            return null;
        }
        return productoDAO.findById(id);
    }

    // Actualizar producto
    public boolean actualizarProducto(int id, String nombre, String categoria, String unidadMedida) {

        Producto existente = productoDAO.findById(id);
        if (existente == null) {
            System.out.println("No existe un producto con ese ID.");
            return false;
        }

        if (nombre != null && !nombre.isBlank()) existente.setNombre(nombre);
        if (categoria != null && !categoria.isBlank()) existente.setCategoria(categoria);
        if (unidadMedida != null && !unidadMedida.isBlank()) existente.setUnidadMedida(unidadMedida);

        return productoDAO.update(existente);
    }

    // Eliminar producto
    public boolean eliminarProducto(int id) {

        Producto existente = productoDAO.findById(id);
        if (existente == null) {
            System.out.println("No existe un producto con ese ID.");
            return false;
        }

        boolean borrado = productoDAO.delete(id);

        if (!borrado) {
            System.out.println("No se puede borrar el producto porque tiene registros asociados.");
        }

        return borrado;
    }

    // MÉTODOS DE CONSOLA

    public void crearProductoConsola(java.util.Scanner teclado) {
        System.out.print("Nombre del producto: ");
        String nombre = teclado.nextLine();

        System.out.print("Categoría: ");
        String categoria = teclado.nextLine();

        System.out.print("Unidad de medida: ");
        String unidad = teclado.nextLine();

        boolean ok = crearProducto(nombre, categoria, unidad);

        if (ok) {
            System.out.println("Producto creado correctamente.");
        } else {
            System.out.println("No se pudo crear el producto.");
        }
    }

    public void eliminarProductoConsola(java.util.Scanner teclado) {
        System.out.print("ID del producto a eliminar: ");
        int id = Integer.parseInt(teclado.nextLine());

        boolean ok = eliminarProducto(id);

        if (ok) {
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("No se pudo eliminar el producto.");
        }
    }

    public void listarProductosConsola() {
        List<Producto> lista = listarProductos();

        if (lista.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.println("\n--- LISTA DE PRODUCTOS ---");
        for (Producto p : lista) {
            System.out.println("ID: " + p.getId() +
                    " | Nombre: " + p.getNombre() +
                    " | Categoría: " + p.getCategoria() +
                    " | Unidad: " + p.getUnidadMedida());
        }
    }


}

