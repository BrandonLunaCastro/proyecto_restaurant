package repository;

import model.Plato;
import utils.ConexionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlatoRepository {

    public List<Plato> getPlatos() {
        List<Plato> lista = new ArrayList<>();
        String sql = "SELECT id_producto, nombre, precio, id_categoria FROM productos";

        try (Connection conn = ConexionDB.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Plato(
                        rs.getInt("id_producto"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        String.valueOf(rs.getInt("id_categoria"))
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    // --- AGREGAR ---
    public void add(Plato plato) {
        String sql = "INSERT INTO productos (nombre, precio, id_categoria, stock_cantidad) VALUES (?, ?, ?, 0)";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, plato.getName());
            ps.setDouble(2, plato.getPrice());
            ps.setInt(3, Integer.parseInt(plato.getCategory()));
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al agregar: " + e.getMessage());
        }
    }

    // --- ELIMINAR ---
    public void delete(int id) {
        String sql = "DELETE FROM productos WHERE id_producto = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
        }
    }

    // --- EDITAR ---
    public void update(Plato plato) {
        String sql = "UPDATE productos SET nombre = ?, precio = ?, id_categoria = ? WHERE id_producto = ?";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, plato.getName());
            ps.setDouble(2, plato.getPrice());
            ps.setInt(3, Integer.parseInt(plato.getCategory()));
            ps.setInt(4, plato.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Error al editar: " + e.getMessage());
        }
    }
}