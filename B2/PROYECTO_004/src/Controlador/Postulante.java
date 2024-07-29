package Controlador;

public class Postulante {
    protected String nombre;
    protected String fecha;
    protected String bachillerato;
    protected String abanderado;
    protected String discapacidad;
    protected String carrera;
    protected String usuario;
    protected String contraseña;
    protected int nota;
    protected boolean estado;
    protected String mensaje;

    public Postulante(String nombre, String fecha, String bachillerato, String abanderado, String discapacidad, String carrera, String usuario, String contraseña, int nota, boolean estado, String mensaje) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.bachillerato = bachillerato;
        this.abanderado = abanderado;
        this.discapacidad = discapacidad;
        this.carrera = carrera;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nota = nota;
        this.estado = estado;
        this.mensaje = mensaje;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }
}
