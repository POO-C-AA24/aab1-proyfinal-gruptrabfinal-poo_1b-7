package Controlador;


public class Gestion_contraseñas extends Seguridad {

    @Override
    public String creador_contraseñas() {
        return "contraseña_temp";
    }

    @Override
    protected String creador_usuarios(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String verificador(String user, String contraseña) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
