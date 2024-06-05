package Controller;

import java.io.Serializable;
import java.util.Random;

public class Postulante implements Serializable {

    int dia;
    int mes;
    int año;
    String nombre;
    String carrera;
    String facultad;
    String abanderado;
    String bachillerato;
    double discapacidad;
    int puntaje;
    boolean aprobado;

    public Postulante(int dia, int mes, int año, String nombre, String carrera, String facultad, String abanderado, String bachillerato, double discapacidad, int puntaje, boolean aprobado) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.nombre = nombre;
        this.carrera = carrera;
        this.facultad = facultad;
        this.abanderado = abanderado;
        this.bachillerato = bachillerato;
        this.discapacidad = discapacidad;
        this.puntaje = puntaje;
        this.aprobado = aprobado;
    }

    public static Postulante[] crearPostulantesRandom(String[] nombres, String[] carrerasND, String[] carrerasCD, String[] facultades, String[] abanderados, String[] bachilleratos, int numP) {
        Random random = new Random();
        Postulante[] postulantes = new Postulante[numP];

        for (int i = 0; i < numP; i++) {
            String nombre = nombres[random.nextInt(nombres.length)];
            String carrera;
            if (random.nextBoolean()) {
                carrera = carrerasND[random.nextInt(carrerasND.length)];
            } else {
                carrera = carrerasCD[random.nextInt(carrerasCD.length)];
            }
            String facultad = facultades[random.nextInt(facultades.length)];
            String bachillerato = bachilleratos[random.nextInt(bachilleratos.length)];
            int dia = random.nextInt(28) + 1;
            int mes = random.nextInt(12) + 1;
            int año = 2024;
            double discapacidad = random.nextDouble() * 100;
            boolean aprobado = false;
            String abanderado = abanderados[random.nextInt(abanderados.length)];
            Postulante postulante = new Postulante(dia, mes, año, nombre, carrera, facultad, abanderado, bachillerato, discapacidad, 0, aprobado);
            postulante.puntaje = postulante.asignarNota(carrerasND, carrerasCD);
            postulantes[i] = postulante;
        }

        return postulantes;
    }

    public void calcularMeritos(String[] facultadesCiencias, String[] facultadesIngenieria) {
        for (String carrera : facultadesCiencias) {
            if (this.carrera.equals(carrera) && this.bachillerato.equals("Ciencia")) {
                puntaje += 2;
            }
        }
        for (String carrera : facultadesIngenieria) {
            if (this.carrera.equals(carrera) && this.bachillerato.equals("Tecnico")) {
                puntaje += 2;
            }
        }
        if (discapacidad >= 35) {
            puntaje += 3;
        }
        if (abanderado.equals("si")) {
            puntaje += 5;
        }
    }

    // ND = no diagnóstico, CD = con diagnóstico
    public int asignarNota(String[] carrerasND, String[] carrerasCD) {
        Random random = new Random();
        if (random.nextBoolean()) {
            puntaje = random.nextInt(101);
        } else {
            puntaje = random.nextInt(101);
        }
        if (puntaje >= 100) {
            aprobado = true;
        } else if (puntaje < 30) {
            aprobado = false;
        } else {
            aprobado = true;
        }
        return puntaje;
    }

    @Override
    public String toString() {
        return "Postulante{" +
                "dia=" + dia +
                ", mes=" + mes +
                ", año=" + año +
                ", nombre='" + nombre + '\'' +
                ", carrera='" + carrera + '\'' +
                ", facultad='" + facultad + '\'' +
                ", abanderado='" + abanderado + '\'' +
                ", bachillerato='" + bachillerato + '\'' +
                ", discapacidad=" + discapacidad +
                ", puntaje=" + puntaje +
                ", aprobado=" + aprobado +
                '}';
    }
}
