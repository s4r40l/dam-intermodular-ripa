package DAO;

import model.Producto;

import java.util.List;

public class TestProductoDAO {

    public static void main(String[] args) {

        ProductoDAO productoDAO = new ProductoDAO();

        System.out.println("=== TEST: CREAR PRODUCTO ===");
        Producto p = new Producto("Manzanas", "Fruta", "kg");
        boolean creado = productoDAO.create(p);
        System.out.println("Producto creado: " + creado);

        System.out.println("\n=== TEST: LISTAR TODOS ===");
        productoDAO.findAll().forEach(System.out::println);

        System.out.println("\n=== TEST: BUSCAR POR ID ===");
        Producto encontrado = productoDAO.findById(1); // cambia el ID según tus datos
        System.out.println("Encontrado: " + encontrado);

        System.out.println("\n=== TEST: ACTUALIZAR ===");
        if (encontrado != null) {
            encontrado.setNombre("Manzanas Golden");
            boolean actualizado = productoDAO.update(encontrado);
            System.out.println("Actualizado: " + actualizado);
        }

        System.out.println("=== TEST: CREAR PRODUCTO TEMPORAL ===");
        Producto temp = new Producto("ProductoTemporal", "Test", "unidad");
        boolean creadoTemp = productoDAO.create(temp);
        System.out.println("Producto temporal creado: " + creadoTemp);

        System.out.println("\n=== OBTENER ID DEL PRODUCTO TEMPORAL ===");
        List<Producto> lista = productoDAO.findAll();
        Producto ultimo = lista.get(lista.size() - 1);
        System.out.println("Último producto: " + ultimo);

        System.out.println("\n=== TEST: BORRAR PRODUCTO TEMPORAL ===");
        boolean borradoTemp = productoDAO.delete(ultimo.getId());
        System.out.println("Producto temporal borrado: " + borradoTemp);

        System.out.println("\n=== TEST: BORRAR ===");
        boolean borrado = productoDAO.delete(1); // cambia el ID según tus datos
        System.out.println("Borrado: " + borrado);

    }
}

