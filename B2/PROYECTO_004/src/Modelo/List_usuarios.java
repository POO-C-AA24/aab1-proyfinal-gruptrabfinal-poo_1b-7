package Modelo;

import Controlador.Postulante;
import Controlador.Usuario_administrativo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class List_usuarios {

    public ArrayList<Postulante> lista_postulantes() {
        ArrayList<Postulante> listaPostulantes = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Conexión a la base de datos
            conn = DriverManager.getConnection("jdbc:sqlite:bd/nombre_bd.db");

            // Consulta SQL
            String sql = "SELECT * FROM Postulantes";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            // Iterar sobre el resultado y agregar cada postulante a la lista
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String fecha = rs.getString("fecha");
                String bachillerato = rs.getString("bachillerato");
                String abanderado = rs.getString("abanderado");
                String discapacidad = rs.getString("discapacidad");
                String carrera = rs.getString("carrera");
                String usuario = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");
                int nota = rs.getInt("nota");
                boolean estado = rs.getBoolean("estado");
                String mensaje = rs.getString("mensaje");

                Postulante postulante = new Postulante(nombre, fecha, bachillerato, abanderado, discapacidad, carrera, usuario, contraseña, nota, estado, mensaje);
               
                listaPostulantes.add(postulante);
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         //esta lista la debo enviar a Gestion_usuario para que se la pueda utlizar en el metodo verificador
        return listaPostulantes;
    }

    public ArrayList<Usuario_administrativo> lista_admin() {
        ArrayList<Usuario_administrativo> listaUsuarios = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Conexión a la base de datos
            conn = DriverManager.getConnection("jdbc:sqlite:bd/nombre_bd.db");

            // Consulta SQL
            String sql = "SELECT * FROM usuarios_admin";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            // Iterar sobre el resultado y agregar cada usuario a la lista
            while (rs.next()) {
                String id = rs.getString("id");
                String usuario = rs.getString("usuario");
                String contraseña = rs.getString("contraseña");
                String titulo = rs.getString("titulo");

                Usuario_administrativo user = new Usuario_administrativo(id, usuario, contraseña, titulo);
                listaUsuarios.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         //esta lista la debo enviar a Gestion_usuario para que se la pueda utlizar en el metodo verificador
        return listaUsuarios;
    }
}
