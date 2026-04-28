package controller;

import model.Producto;

public class TestProductoController {

    public static void main(String[] args) {

        ProductoController controller = new ProductoController();

        System.out.println("=== CREAR PRODUCTO TEMPORAL ===");
        boolean creado = controller.crearProducto("ProductoTest", "Test", "unidad");
        System.out.println("Creado: " + creado);

        System.out.println("\n=== LISTAR PRODUCTOS ===");
        controller.listarProductos().forEach(System.out::println);

        System.out.println("\n=== BUSCAR PRODUCTO ===");
        Producto ultimo = controller.listarProductos().get(controller.listarProductos().size() - 1);
        System.out.println("Encontrado: " + controller.buscarProducto(ultimo.getId()));

        System.out.println("\n=== ACTUALIZAR PRODUCTO ===");
        boolean actualizado = controller.actualizarProducto(ultimo.getId(), "ProductoTestEditado", "Test", "unidad");
        System.out.println("Actualizado: " + actualizado);

        System.out.println("\n=== BORRAR PRODUCTO ===");
        boolean borrado = controller.eliminarProducto(ultimo.getId());
        System.out.println("Borrado: " + borrado);
    }
}
