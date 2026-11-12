package com.citafacil.dao;

import com.citafacil.conexion.ConexionBD;
import com.citafacil.modelo.Cita;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {

    // 1. INSERCIÓN (CREATE)
    public boolean insertarCita(Cita cita) {
        String sql = "INSERT INTO cita (id_usuario, id_servicio, id_horario, estado) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, cita.getIdUsuario());
            pstmt.setInt(2, cita.getIdServicio());
            pstmt.setInt(3, cita.getIdHorario());
            pstmt.setString(4, cita.getEstado());
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar cita: " + e.getMessage());
            return false;
        }
    }

    // 2. CONSULTA (READ)
    public List<Cita> listarCitas() {
        List<Cita> listaCitas = new ArrayList<>();
        String sql = "SELECT * FROM cita";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Cita cita = new Cita();
                cita.setIdCita(rs.getInt("id_cita"));
                cita.setIdUsuario(rs.getInt("id_usuario"));
                cita.setIdServicio(rs.getInt("id_servicio"));
                cita.setIdHorario(rs.getInt("id_horario"));
                cita.setEstado(rs.getString("estado"));
                listaCitas.add(cita);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar citas: " + e.getMessage());
        }
        return listaCitas;
    }

    // 3. ACTUALIZACIÓN (UPDATE)
    public boolean actualizarEstadoCita(int idCita, String nuevoEstado) {
        String sql = "UPDATE cita SET estado = ? WHERE id_cita = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, nuevoEstado);
            pstmt.setInt(2, idCita);
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar cita: " + e.getMessage());
            return false;
        }
    }

    // 4. ELIMINACIÓN (DELETE)
    public boolean eliminarCita(int idCita) {
        String sql = "DELETE FROM cita WHERE id_cita = ?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, idCita);
            
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar cita: " + e.getMessage());
            return false;
        }
    }
}