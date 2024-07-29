package Controlador;

public class Postulante {
    public String nombre;
    public String fecha;
    public String bachillerato;
    public String abanderado;
    public String discapacidad;
    public String carrera;
    public String usuario;
    public String contraseña;
    public int nota;
    public boolean estado;
    public String mensaje;

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
