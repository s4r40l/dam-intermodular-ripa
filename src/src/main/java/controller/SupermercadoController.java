package controller;

import DAO.SupermercadoDAO;
import model.Supermercado;

import java.util.List;

public class SupermercadoController {

    private final SupermercadoDAO supermercadoDAO = new SupermercadoDAO();

    // Crear supermercado con validaciones
    public boolean crearSupermercado(String nombre) {

        if (nombre == null || nombre.isBlank()) {
            System.out.println("El nombre del supermercado no puede estar vacío.");
            return false;
        }

        // Evitar duplicados por nombre
        List<Supermercado> existentes = supermercadoDAO.findAll();
        boolean duplicado = existentes.stream()
                .anyMatch(s -> s.getNombre().equalsIgnoreCase(nombre));

        if (duplicado) {
            System.out.println("Ya existe un supermercado con ese nombre.");
            return false;
        }

        Supermercado nuevo = new Supermercado(nombre);
        return supermercadoDAO.create(nuevo);
    }

    // Listar supermercados
    public List<Supermercado> listarSupermercados() {
        return supermercadoDAO.findAll();
    }

    // Buscar por ID
    public Supermercado buscarSupermercado(int id) {
        if (id <= 0) {
            System.out.println("ID inválido.");
            return null;
        }
        return supermercadoDAO.findById(id);
    }

    // Actualizar supermercado
    public boolean actualizarSupermercado(int id, String nuevoNombre) {

        Supermercado existente = supermercadoDAO.findById(id);
        if (existente == null) {
            System.out.println("No existe un supermercado con ese ID.");
            return false;
        }

        if (nuevoNombre == null || nuevoNombre.isBlank()) {
            System.out.println("El nombre no puede estar vacío.");
            return false;
        }

        existente.setNombre(nuevoNombre);
        return supermercadoDAO.update(existente);
    }

    // Eliminar supermercado
    public boolean eliminarSupermercado(int id) {

        Supermercado existente = supermercadoDAO.findById(id);
        if (existente == null) {
            System.out.println("No existe un supermercado con ese ID.");
            return false;
        }

        boolean borrado = supermercadoDAO.delete(id);

        if (!borrado) {
            System.out.println("No se puede borrar el supermercado porque tiene registros asociados.");
        }

        return borrado;
    }

    // ░░░░░░░░░░ MÉTODOS DE CONSOLA ░░░░░░░░░░

    public void crearSupermercadoConsola(java.util.Scanner sc) {
        System.out.print("Nombre del supermercado: ");
        String nombre = sc.nextLine();

        boolean ok = crearSupermercado(nombre);

        if (ok) {
            System.out.println("Supermercado creado correctamente.");
        } else {
            System.out.println("No se pudo crear el supermercado.");
        }
    }

    public void eliminarSupermercadoConsola(java.util.Scanner sc) {
        System.out.print("ID del supermercado a eliminar: ");
        int id = Integer.parseInt(sc.nextLine());

        boolean ok = eliminarSupermercado(id);

        if (ok) {
            System.out.println("Supermercado eliminado.");
        } else {
            System.out.println("No se pudo eliminar el supermercado.");
        }
    }

    public void listarSupermercadosConsola() {
        List<Supermercado> lista = listarSupermercados();

        if (lista.isEmpty()) {
            System.out.println("No hay supermercados registrados.");
            return;
        }

        System.out.println("\n--- LISTA DE SUPERMERCADOS ---");
        for (Supermercado s : lista) {
            System.out.println("ID: " + s.getId() +
                    " | Nombre: " + s.getNombre());
        }
    }


}
