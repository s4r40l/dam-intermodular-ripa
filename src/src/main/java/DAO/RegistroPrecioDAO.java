package DAO;

import database.ConexionBD;
import model.Producto;
import model.RegistroPrecio;
import model.Supermercado;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegistroPrecioDAO {

    // CREATE
    public boolean create(RegistroPrecio registro) {
        String sql = "INSERT INTO registro_precio (id_producto, id_supermercado, id_usuario, fecha, precio) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, registro.getProducto().getId());
            stmt.setInt(2, registro.getSupermercado().getId());
            stmt.setInt(3, 1); // Usuario por defecto
            stmt.setDate(4, Date.valueOf(registro.getFecha()));
            stmt.setDouble(5, registro.getPrecio());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al crear registro de precio: " + e.getMessage());
            return false;
        }
    }

    // READ by ID
    public RegistroPrecio findById(int id) {
        String sql = """
                SELECT rp.id_registro, rp.fecha, rp.precio,
                       p.id_producto AS p_id, p.nombre AS p_nombre, p.categoria, p.unidad_medida,
                       s.id_supermercado AS s_id, s.nombre AS s_nombre
                FROM registro_precio rp
                JOIN producto p ON rp.id_producto = p.id_producto
                JOIN supermercado s ON rp.id_supermercado = s.id_supermercado
                WHERE rp.id_registro = ?
                """;

        RegistroPrecio registro = null;

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Producto producto = new Producto(
                        rs.getInt("p_id"),
                        rs.getString("p_nombre"),
                        rs.getString("categoria"),
                        rs.getString("unidad_medida")
                );

                Supermercado supermercado = new Supermercado(
                        rs.getInt("s_id"),
                        rs.getString("s_nombre")
                );

                registro = new RegistroPrecio(
                        rs.getInt("id_registro"),
                        producto,
                        supermercado,
                        rs.getDate("fecha").toLocalDate(),
                        rs.getDouble("precio")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar registro de precio: " + e.getMessage());
        }

        return registro;
    }

    // READ ALL
    public List<RegistroPrecio> findAll() {
        List<RegistroPrecio> registros = new ArrayList<>();

        String sql = """
                SELECT rp.id_registro, rp.fecha, rp.precio,
                       p.id_producto AS p_id, p.nombre AS p_nombre, p.categoria, p.unidad_medida,
                       s.id_supermercado AS s_id, s.nombre AS s_nombre
                FROM registro_precio rp
                JOIN producto p ON rp.id_producto = p.id_producto
                JOIN supermercado s ON rp.id_supermercado = s.id_supermercado
                ORDER BY rp.fecha DESC
                """;

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                Producto producto = new Producto(
                        rs.getInt("p_id"),
                        rs.getString("p_nombre"),
                        rs.getString("categoria"),
                        rs.getString("unidad_medida")
                );

                Supermercado supermercado = new Supermercado(
                        rs.getInt("s_id"),
                        rs.getString("s_nombre")
                );

                registros.add(new RegistroPrecio(
                        rs.getInt("id_registro"),
                        producto,
                        supermercado,
                        rs.getDate("fecha").toLocalDate(),
                        rs.getDouble("precio")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener registros de precio: " + e.getMessage());
        }

        return registros;
    }

    // READ by PRODUCTO
    public List<RegistroPrecio> findByProducto(int idProducto) {
        List<RegistroPrecio> registros = new ArrayList<>();

        String sql = """
                SELECT rp.id_registro, rp.fecha, rp.precio,
                       p.id_producto AS p_id, p.nombre AS p_nombre, p.categoria, p.unidad_medida,
                       s.id_supermercado AS s_id, s.nombre AS s_nombre
                FROM registro_precio rp
                JOIN producto p ON rp.id_producto = p.id_producto
                JOIN supermercado s ON rp.id_supermercado = s.id_supermercado
                WHERE p.id_producto = ?
                ORDER BY rp.fecha DESC
                """;

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idProducto);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Producto producto = new Producto(
                        rs.getInt("p_id"),
                        rs.getString("p_nombre"),
                        rs.getString("categoria"),
                        rs.getString("unidad_medida")
                );

                Supermercado supermercado = new Supermercado(
                        rs.getInt("s_id"),
                        rs.getString("s_nombre")
                );

                registros.add(new RegistroPrecio(
                        rs.getInt("id_registro"),
                        producto,
                        supermercado,
                        rs.getDate("fecha").toLocalDate(),
                        rs.getDouble("precio")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener registros por producto: " + e.getMessage());
        }

        return registros;
    }

    // UPDATE
    public boolean update(RegistroPrecio registro) {
        String sql = """
                UPDATE registro_precio
                SET id_producto = ?, id_supermercado = ?, fecha = ?, precio = ?
                WHERE id_registro = ?
                """;

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, registro.getProducto().getId());
            stmt.setInt(2, registro.getSupermercado().getId());
            stmt.setDate(3, Date.valueOf(registro.getFecha()));
            stmt.setDouble(4, registro.getPrecio());
            stmt.setInt(5, registro.getId());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al actualizar registro de precio: " + e.getMessage());
            return false;
        }
    }

    // DELETE
    public boolean delete(int id) {
        String sql = "DELETE FROM registro_precio WHERE id_registro = ?";

        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error al eliminar registro de precio: " + e.getMessage());
            return false;
        }
    }
}
