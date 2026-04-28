package DAO;

import model.Supermercado;

import java.util.List;

public class TestSupermercadoDAO {

    public static void main(String[] args) {

        SupermercadoDAO supermercadoDAO = new SupermercadoDAO();

        System.out.println("=== TEST: CREAR SUPERMERCADO TEMPORAL ===");
        Supermercado temp = new Supermercado("SuperTemporal");
        boolean creadoTemp = supermercadoDAO.create(temp);
        System.out.println("Supermercado temporal creado: " + creadoTemp);

        System.out.println("\n=== OBTENER ID DEL SUPERMERCADO TEMPORAL ===");
        List<Supermercado> lista = supermercadoDAO.findAll();
        Supermercado ultimo = lista.get(lista.size() - 1);
        System.out.println("Último supermercado: " + ultimo);

        System.out.println("\n=== TEST: BUSCAR POR ID ===");
        Supermercado encontrado = supermercadoDAO.findById(ultimo.getId());
        System.out.println("Encontrado: " + encontrado);

        System.out.println("\n=== TEST: ACTUALIZAR ===");
        encontrado.setNombre("SuperTemporalEditado");
        boolean actualizado = supermercadoDAO.update(encontrado);
        System.out.println("Actualizado: " + actualizado);

        System.out.println("\n=== TEST: BORRAR SUPERMERCADO TEMPORAL ===");
        boolean borradoTemp = supermercadoDAO.delete(ultimo.getId());
        System.out.println("Supermercado temporal borrado: " + borradoTemp);
    }
}
