package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class obtener_identifi {
    private Connection concDB;

    public obtener_identifi() {
        Coneccion_DB conexion = new Coneccion_DB();
        this.concDB = conexion.getConnection();
    }

    public int obtenerSiguienteNumeroDeFila() {
        int siguienteNumero = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "SELECT MAX(id) + 1 AS siguiente FROM postulantes";
            ps = concDB.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                siguienteNumero = rs.getInt("siguiente");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (concDB != null) concDB.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return siguienteNumero;
    }
}
