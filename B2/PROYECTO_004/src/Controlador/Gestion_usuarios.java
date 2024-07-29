package Controlador;


import java.util.ArrayList;

public class Gestion_usuarios {



    public String verificador(String user, String contraseña, ArrayList<Postulante> listaPostulantes, ArrayList<Usuario_administrativo> listaUsuariosAdmin) {

        for (Postulante postulante : listaPostulantes) {
            if (postulante.getUsuario().equals(user) && postulante.getContraseña().equals(contraseña)) {
                return "user";
            }
        }

        for (Usuario_administrativo admin : listaUsuariosAdmin) {
            if (admin.getUsuario().equals(user) && admin.getContraseña().equals(contraseña)) {
                return "admin";
            }
        }

        return "Usuario o contraseña incorrectos";
    }
}




