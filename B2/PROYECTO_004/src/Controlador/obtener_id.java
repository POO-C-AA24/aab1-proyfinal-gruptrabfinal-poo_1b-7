package Controlador;

import Modelo.obtener_identifi;

public class obtener_id {
    public int c() {
        obtener_identifi p = new obtener_identifi();
        int id = p.obtenerSiguienteNumeroDeFila();
        return id;
    }
}
