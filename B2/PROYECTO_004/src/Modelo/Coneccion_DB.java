package Modelo;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Coneccion_DB {

    private String url = "jdbc:sqlite:bd/nombre_bd.db";
    private Connection wifi;

    public void coneccion_db() {
        // Verifica si la carpeta 'bd' existe, si no, la crea
        File directory = new File("bd");
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Carpeta 'bd' creada con éxito");
            } else {
                System.out.println("Error al crear la carpeta 'bd'");
                return;
            }
        }

        int maxRetries = 5;
        int retries = 0;
        boolean connected = false;

        while (retries < maxRetries && !connected) {
            try {
                wifi = DriverManager.getConnection(url);
                System.out.println("Conexion establecida con exito");
                connected = true;
            } catch (SQLException e) {
                System.out.println("Error al conectar a la base de datos: " + e.getMessage());
                retries++;
                try {
                    Thread.sleep(1000);  // Esperar 1 segundo antes de reintentar
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }

        if (!connected) {
            System.out.println("No se pudo establecer la conexión después de " + maxRetries + " intentos.");
        }
    }

    public Connection getConnection() {
        if (wifi == null) {
            coneccion_db();
        }
        return this.wifi;
    }


}
