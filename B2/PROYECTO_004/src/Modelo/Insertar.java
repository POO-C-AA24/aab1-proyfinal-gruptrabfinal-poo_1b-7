/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.Gestion_postulante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author COSAS DE LA Y
 */
public class Insertar {
    public void guardar_postulante(Gestion_postulante p) {
        Coneccion_DB conexion = new Coneccion_DB();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = conexion.getConnection();
            if (conn != null) {
                conn.setAutoCommit(false);  // Inicia la transacción
                String query = "INSERT INTO postulantes (nombre, fecha, bachillerato, abanderado, discapacidad, carrera, usuario, contraseña, nota, estado, mensaje) ";
                ps = conn.prepareStatement(query);
                ps.setString(1, p.nombre);
                ps.setString(2, p.fecha);
                ps.setString(3, p.bachillerato);
                ps.setString(4, p.abanderado);
                ps.setString(5, p.discapacidad);
                ps.setString(6, p.carrera);
                ps.setString(7, p.usuario);
                ps.setString(8, p.contraseña);
                ps.setInt(9, p.nota);
                ps.setBoolean(10, p.estado);
                ps.setString(11, p.mensaje);
                ps.executeUpdate();
                conn.commit();  // Finaliza la transacción
                System.out.println("Datos guardados con éxito");
            } else {
                System.out.println("Error: No se pudo establecer la conexión a la base de datos.");
            }
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();  // Revertir la transacción en caso de error
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.setAutoCommit(true);  // Restablecer el modo de autocommit
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
