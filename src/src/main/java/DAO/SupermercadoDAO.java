package DAO;

import database.ConexionBD;
import model.Supermercado;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupermercadoDAO {

    // CREATE
    public boolean create(Supermercado supermercado) {
        String sql = "INSERT INTO supermercado (nombre) VALUES (?)";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, supermercado.getNombre());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al crear supermercado: " + e.getMessage());
            return false;
        }
    }

    // READ by ID
    public Supermercado findById(int id) {
        String sql = "SELECT * FROM supermercado WHERE id_supermercado = ?";
        Supermercado supermercado = null;

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                supermercado = new Supermercado(
                        rs.getInt("id_supermercado"),
                        rs.getString("nombre")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar supermercado: " + e.getMessage());
        }

        return supermercado;
    }

    public Supermercado findByName(String nombre) {
        String sql = "SELECT * FROM supermercado WHERE nombre = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Supermercado(
                        rs.getInt("id_supermercado"),
                        rs.getString("nombre")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar supermercado por nombre: " + e.getMessage());
        }

        return null;
    }


    // READ ALL
    public List<Supermercado> findAll() {
        List<Supermercado> supermercados = new ArrayList<>();
        String sql = "SELECT * FROM supermercado";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                supermercados.add(new Supermercado(
                        rs.getInt("id_supermercado"),
                        rs.getString("nombre")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener supermercados: " + e.getMessage());
        }

        return supermercados;
    }

    // UPDATE
    public boolean update(Supermercado supermercado) {
        String sql = "UPDATE supermercado SET nombre = ? WHERE id_supermercado = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, supermercado.getNombre());
            stmt.setInt(2, supermercado.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar supermercado: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean delete(int id) {
        String sql = "DELETE FROM supermercado WHERE id_supermercado = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar supermercado: " + e.getMessage());
            return false;
        }
    }
}
