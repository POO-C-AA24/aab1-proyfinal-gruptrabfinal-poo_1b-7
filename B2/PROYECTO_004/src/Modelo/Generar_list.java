package Modelo;

import Controlador.Facultad;
import Controlador.Postulante;
import Controlador.Usuario_administrativo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Generar_list {

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
 private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
 public String[] listaFechas() {
        ArrayList<String> fechasList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:bd/nombre_bd.db");
            String sql = "SELECT fecha_inicio, fecha_final FROM fecha_requerimiento";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String fechaInicio = rs.getString("fecha_inicio");
                String fechaFinal = rs.getString("fecha_final");
                fechasList.add(fechaInicio);
                fechasList.add(fechaFinal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // Convertir la lista a un arreglo y devolverlo
        return fechasList.toArray(new String[0]);
    }
private ArrayList<Facultad> listarCarreras(String tablaFacultad) {
        ArrayList<Facultad> facultades = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:bd/nombre_bd.db");
            String sql = "SELECT carrera FROM " + tablaFacultad;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String carrera = rs.getString("carrera");
                Facultad facultad = new Facultad(carrera);
                facultades.add(facultad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return facultades;
    }

    public ArrayList<Facultad> listFacuSalud() {
        return listarCarreras("CIENCIAS_DE_LA_SALUD");
    }

    public ArrayList<Facultad> listFacuEconomicas() {
        return listarCarreras("CIENCIAS_ECONOMICAS_Y_EMPRESARIALES");
    }

    public ArrayList<Facultad> listFacuExactas() {
        return listarCarreras("CIENCIAS_EXACTAS_Y_NATURALES");
    }

    public ArrayList<Facultad> listFacuSociales() {
        return listarCarreras("CIENCIAS_SOCIALES_EDUCACION_Y_HUMANIDADES");
    }

    public ArrayList<Facultad> listFacuJuridicas() {
        return listarCarreras("CIENCIAS_JURIDICAS_Y_POLITICAS");
    }

    public ArrayList<Facultad> listFacuIngenierias() {
        return listarCarreras("INGENIERIAS_Y_ARQUITECTURAS");
    }
        public ArrayList<Facultad> list_No_Diagnostico() {
        return listarCarreras("CARRERAS_DIAGNOSTICO");
    }
    
    
 
}
