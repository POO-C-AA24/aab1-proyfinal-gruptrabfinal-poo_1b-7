package Controlador;

public class Usuario_administrativo extends Usuario {
    private String titulo;

    public Usuario_administrativo(String id, String usuario, String contraseña, String titulo) {
        super(id, usuario, contraseña);
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }
}
