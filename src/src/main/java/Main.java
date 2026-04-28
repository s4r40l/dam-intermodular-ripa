import controller.ProductoController;
import controller.SupermercadoController;
import controller.RegistroPrecioController;
import xml.XMLExporter;
import xml.XMLImporter;

import java.util.Scanner;

public class Main {

    private static final Scanner teclado = new Scanner(System.in);

    private static final ProductoController productoController = new ProductoController();
    private static final SupermercadoController supermercadoController = new SupermercadoController();
    private static final RegistroPrecioController registroPrecioController = new RegistroPrecioController();

    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n===== RIPA - Registro Inteligente de Precios de Alimentos =====");
            System.out.println("1. Gestión de productos");
            System.out.println("2. Gestión de supermercados");
            System.out.println("3. Registro de precios");
            System.out.println("4. Listados");
            System.out.println("5. Exportar datos a XML");
            System.out.println("6. Importar datos desde XML");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1 -> menuProductos();
                case 2 -> menuSupermercados();
                case 3 -> menuRegistroPrecios();
                case 4 -> menuListados();
                case 5 -> exportarXML();
                case 6 -> importarXML();
                case 7 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 7);
    }

    // MENÚ PRODUCTOS
    private static void menuProductos() {
        int opcion;

        do {
            System.out.println("\n--- Gestión de Productos ---");
            System.out.println("1. Crear producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Volver");
            System.out.print("Elige una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1 -> productoController.crearProductoConsola(teclado);
                case 2 -> productoController.listarProductosConsola();
                case 3 -> productoController.eliminarProductoConsola(teclado);
                case 4 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 4);
    }

    // MENÚ SUPERMERCADOS
    private static void menuSupermercados() {
        int opcion;

        do {
            System.out.println("\n--- Gestión de Supermercados ---");
            System.out.println("1. Crear supermercado");
            System.out.println("2. Listar supermercados");
            System.out.println("3. Eliminar supermercado");
            System.out.println("4. Volver");
            System.out.print("Elige una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1 -> supermercadoController.crearSupermercadoConsola(teclado);
                case 2 -> supermercadoController.listarSupermercadosConsola();
                case 3 -> supermercadoController.eliminarSupermercadoConsola(teclado);
                case 4 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 4);
    }

    // MENÚ REGISTRO DE PRECIOS
    private static void menuRegistroPrecios() {
        int opcion;

        do {
            System.out.println("\n--- Registro de Precios ---");
            System.out.println("1. Registrar precio");
            System.out.println("2. Listar registros");
            System.out.println("3. Eliminar registro");
            System.out.println("4. Volver");
            System.out.print("Elige una opción: ");

            opcion = leerEntero();

            switch (opcion) {
                case 1 -> registroPrecioController.crearRegistroConsola(teclado);
                case 2 -> registroPrecioController.listarRegistrosConsola();
                case 3 -> registroPrecioController.eliminarRegistroConsola(teclado);
                case 4 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 4);
    }

    // LISTADOS
    private static void menuListados() {
        System.out.println("\n--- LISTADOS COMPLETOS ---");
        productoController.listarProductosConsola();
        supermercadoController.listarSupermercadosConsola();
        registroPrecioController.listarRegistrosConsola();
    }

    // UTILIDAD PARA LEER ENTEROS
    private static int leerEntero() {
        try {
            return Integer.parseInt(teclado.nextLine());
        } catch (Exception e) {
            System.out.println("Entrada inválida. Introduce un número.");
            return -1;
        }
    }

    // EXPORTACIÓN E IMPORTACIÓN

    private static void exportarXML() {
        XMLExporter exporter = new XMLExporter();
        boolean ok = exporter.exportarXML("ripa_importar.xml");

        if (ok) {
            System.out.println("XML exportado correctamente a ripa_exportado.xml");
        } else {
            System.out.println("Error al exportar XML.");
        }
    }

    private static void importarXML() {
        XMLImporter importer = new XMLImporter();
        boolean ok = importer.importarXML("ripa_importar.xml");

        if (ok) {
            System.out.println("XML importado correctamente desde ripa_importar.xml");
        } else {
            System.out.println("Error al importar XML.");
        }
    }

}