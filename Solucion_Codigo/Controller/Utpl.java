package Controller;

import java.io.*;
import java.util.ArrayList;

public class Utpl {

    ArrayList<Postulante> ListaPostulantes;

    public Utpl() {
        this.ListaPostulantes = new ArrayList<>();
    }

    public void llamarPostulantesAleatorios(String[] nombres, String[] carrerasND, String[] carrerasCD, String[] facultades, String[] abanderados, String[] bachilleratos, int numP){
        Postulante[] postulantes = Postulante.crearPostulantesRandom(nombres, carrerasND, carrerasCD, facultades, abanderados, bachilleratos, numP);
        for (Postulante postulante : postulantes) {
            ListaPostulantes.add(postulante);
        }
    }

    public void llamarPostulanteUnico(int dia, int mes, int año, String nombre, String carrera, String facultad, String abanderado, String bachillerato) {
        Postulante postulante = new Postulante(dia, mes, año, nombre, carrera, facultad, abanderado, bachillerato, 0, 0, false);
        ListaPostulantes.add(postulante);
    }

    public void verificarFecha(int diaA, int mesA, int añoA) {
        for (Postulante postulante : ListaPostulantes) {
            if (postulante.dia != diaA || postulante.mes != mesA || postulante.año != añoA) {
                postulante.aprobado = false;
            }
        }
    }

    public void asignarMeritos(String[] facultadesCiencias, String[] facultadesIngenieria) {
        for (Postulante postulante : ListaPostulantes) {
            postulante.calcularMeritos(facultadesCiencias, facultadesIngenieria);
        }
    }

    public void asignarExamen(String[] carrerasND, String[] carrerasCD) {
        for (Postulante postulante : ListaPostulantes) {
            postulante.puntaje = postulante.asignarNota(carrerasND, carrerasCD);
        }
    }

    public void mostrarPostulantes() {
        for (Postulante postulante : ListaPostulantes) {
            System.out.println(postulante);
        }
    }

    public void guardarPostulantesEnArchivoDat(String nombreArchivo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            oos.writeObject(ListaPostulantes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarPostulantesEnArchivosTxt() {
        try (PrintWriter aprobados = new PrintWriter("aprobados.txt");
             PrintWriter desaprobados = new PrintWriter("desaprobados.txt");
             PrintWriter noCumplen = new PrintWriter("noCumplenRequisitos.txt")) {

            for (Postulante postulante : ListaPostulantes) {
                if (postulante.aprobado) {
                    aprobados.println(postulante);
                } else if (postulante.puntaje < 30) {
                    noCumplen.println(postulante);
                } else {
                    desaprobados.println(postulante);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
