package Controlador;

public class Usuario {
    protected String id;
    protected String usuario;
    protected String contraseña;

    public Usuario(String id, String usuario, String contraseña) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }
}
