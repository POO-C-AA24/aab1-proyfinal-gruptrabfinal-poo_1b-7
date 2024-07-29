/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Generar_list;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Requerimineto {

    Generar_list g = new Generar_list();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public boolean verifi_fechas(String fecha) {

        String[] fechasArray = g.listaFechas();

        try {
            //se importa el formato
            Date fechaAComparar = dateFormat.parse(fecha);
            //se recorre el arreglo
            for (int i = 0; i < fechasArray.length; i += 2) {
                Date fechaInicio = dateFormat.parse(fechasArray[i]);
                Date fechaFinal = dateFormat.parse(fechasArray[i + 1]);
                
                if (fechaAComparar.compareTo(fechaInicio) >= 0 && fechaAComparar.compareTo(fechaFinal) <= 0) {
                    return true;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int examen(String carrera, String discapacidad, String bachillerato, String abanderado) {
        int nota = 0;

        if (abanderado.equals("SI")) {
            nota += 5;
            if (discapacidad.equals("SI")) {
                nota += 3;
            }
        }

        switch (bachillerato) {
            //aqui se busca cuantos puntos se ganaron escogiendo la acrrea
            case "B.I":
                nota += obtenerNotaPorCarrera(g.listFacuExactas(), carrera);
                nota += obtenerNotaPorCarrera(g.listFacuIngenierias(), carrera);
                break;

            case "B.G.U":
                nota += obtenerNotaPorCarrera(g.listFacuSociales(), carrera);
                nota += obtenerNotaPorCarrera(g.listFacuJuridicas(), carrera);
                break;

            case "B.T":
                nota += obtenerNotaPorCarrera(g.listFacuIngenierias(), carrera);
                nota += obtenerNotaPorCarrera(g.listFacuEconomicas(), carrera);
                break;

            case "B.C.A":
                nota += obtenerNotaPorCarrera(g.listFacuExactas(), carrera);
                nota += obtenerNotaPorCarrera(g.listFacuIngenierias(), carrera);
                break;

            default:
                break;
        }

        // Añadir un número aleatorio entre 1 y 10 a la nota
        Random random = new Random();
        int numeroAleatorio = random.nextInt(10) + 1;
        nota += numeroAleatorio;

        // Asegurarse de que la nota no sea mayor a 10
        if (nota > 10) {
            int x = random.nextInt(6) + 1;
            nota = 10;
        }

        return nota;
    }

    public int obtenerNotaPorCarrera(ArrayList<Facultad> facultades, String carrera) {
        for (Facultad f : facultades) {
            if (f.carrera.equals(carrera)) {
                return 2;
            }
        }
        return 0;
    }

    public String mensaje(String carrera, int nota) {
        ArrayList<Facultad> facultades = g.list_No_Diagnostico();

        // Buscar la carrera en la lista de facultades
        for (Facultad f : facultades) {
            if (carrera.equals(f.carrera)) {
                // Verificar la nota
                if (nota < 0.3) {
                    return "Usted debe aprobar el curso 0";
                } else  {
                    return "Usted está aprobado";
                }
            }

        }

        // Si la carrera no está en la lista
        return "Carrera no encontrada";
    }

    public boolean estado(int nota, String carrera) {
        ArrayList<Facultad> c = new ArrayList<>();
        c = g.list_No_Diagnostico();
        for (Facultad h : c) {
            if (h.carrera.equals(carrera)) {
                return true;
            } else {
                if (nota > 7) {
                    return true;
                } else {

                    return false;
                }
            }
        }
        return false;
    }

}
