package Controlador;

import Modelo.Coneccion_DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Gestion_postulante extends Postulante {

    public Gestion_postulante(String nombre, String fecha, String bachillerato, String abanderado, String discapacidad, String carrera, String usuario, String contraseña, int nota, boolean estado, String mensaje) {
        super(nombre, fecha, bachillerato, abanderado, discapacidad, carrera, usuario, contraseña, nota, estado, mensaje);
    }


    public void guardar_bd() {
        Coneccion_DB conexion = new Coneccion_DB();
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = conexion.getConnection();
            String query = "INSERT INTO postulantes (nombre, fecha, bachillerato, abanderado, discapacidad, carrera, usuario, contraseña, nota, estado, mensaje) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, this.nombre);
            ps.setString(2, this.fecha);
            ps.setString(3, this.bachillerato);
            ps.setString(4, this.abanderado);
            ps.setString(5, this.discapacidad);
            ps.setString(6, this.carrera);
            ps.setString(7, this.usuario);
            ps.setString(8, this.contraseña);
            ps.setInt(9, this.nota);
            ps.setBoolean(10, this.estado);
            ps.setString(11, this.mensaje);
            ps.executeUpdate();
            System.out.println("Datos guardados con éxito");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}




