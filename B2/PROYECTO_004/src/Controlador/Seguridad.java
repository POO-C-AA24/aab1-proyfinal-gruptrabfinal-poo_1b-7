package Controlador;

public abstract class Seguridad {
    protected abstract String creador_contraseñas();
    protected abstract String creador_usuarios(int id);
    public abstract String verificador(String user, String contraseña);
}
