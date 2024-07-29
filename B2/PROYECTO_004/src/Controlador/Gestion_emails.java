
package Controlador;


public class Gestion_emails extends Seguridad {

    @Override
    protected String creador_contraseñas() {
       return ""       ;
    }

    @Override
    public String creador_usuarios(int id) {
      String identificativo = String.valueOf(id);
        return "user"+identificativo+"@utpl.edu.ec";
    }

    @Override
    public String verificador(String user, String contraseña) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }




}