package controller;

import model.Supermercado;

public class TestSupermercadoController {

    public static void main(String[] args) {

        SupermercadoController controller = new SupermercadoController();

        System.out.println("=== CREAR SUPERMERCADO TEMPORAL ===");
        boolean creado = controller.crearSupermercado("SuperTest");
        System.out.println("Creado: " + creado);

        System.out.println("\n=== LISTAR SUPERMERCADOS ===");
        controller.listarSupermercados().forEach(System.out::println);

        System.out.println("\n=== BUSCAR SUPERMERCADO ===");
        Supermercado ultimo = controller.listarSupermercados().get(controller.listarSupermercados().size() - 1);
        System.out.println("Encontrado: " + controller.buscarSupermercado(ultimo.getId()));

        System.out.println("\n=== ACTUALIZAR SUPERMERCADO ===");
        boolean actualizado = controller.actualizarSupermercado(ultimo.getId(), "SuperTestEditado");
        System.out.println("Actualizado: " + actualizado);

        System.out.println("\n=== BORRAR SUPERMERCADO ===");
        boolean borrado = controller.eliminarSupermercado(ultimo.getId());
        System.out.println("Borrado: " + borrado);
    }
}
