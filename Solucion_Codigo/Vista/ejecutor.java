package Vista;

import Controller.Utpl;
import java.util.Scanner;

public class ejecutor {

    public static void main(String[] args) {
        Utpl utpl = new Utpl();
        Scanner t = new Scanner(System.in);

        String[] facultadesCiencias = {
            "Facultad de Ciencias de la Salud",
            "Facultad de Ciencias Exactas y Naturales",
            "Facultad de Ciencias Agrícolas y Recursos Naturales"
        };
        String[] facultadesIngenieria = {
            "Facultad de Ingenierías y Arquitectura"
        };
        String[] facultades = {
            "Facultad de Ciencias Económicas y Empresariales",
            "Facultad de Ciencias de la Salud",
            "Facultad de Ciencias Exactas y Naturales",
            "Facultad de Ciencias Sociales, Educación y Humanidades",
            "Facultad de Ingenierías y Arquitectura",
            "Facultad de Ciencias Agrícolas y Recursos Naturales"
        };
        String[] carrerasND = {
            "Administración de Empresas",
            "Arquitectura",
            "Biotecnología",
            "Ciencias de la Computación",
            "Ciencias de la Educación",
            "Contabilidad y Auditoría",
            "Derecho",
            "Economía",
            "Ingeniería Ambiental",
            "Ingeniería Civil",
            "Ingeniería Electrónica y Telecomunicaciones",
            "Ingeniería Industrial",
            "Ingeniería Química",
            "Psicología Educativa",
            "Comunicación",
            "Diseño Gráfico"
        };
        String[] carrerasCD = {
            "Medicina",
            "Odontología",
            "Psicología Clínica",
            "Nutrición y Dietética"
        };
        String[] bachilleratos = {"Tecnico", "Ciencia"};
        String[] nombres = {"Juan", "María", "Luis", "Ana", "Carlos", "Laura", "José", "Elena", "Pedro", "Carmen"};
        String[] abanderados = {"si", "no"};

        System.out.println("Ingrese el dia, el mes y el año limite de inscripcion:");
        int diaA = t.nextInt();
        int mesA = t.nextInt();
        int añoA = t.nextInt();

        int opc;
        do {
            System.out.println("Desea ingresar el estudiante de manera manual? [1]");
            System.out.println("Desea generar alumnos aleatorios? [2]");
            opc = t.nextInt();

            switch (opc) {
                case 1:
                    System.out.println("Ingrese el día:");
                    int dia = t.nextInt();
                    System.out.println("Ingrese el mes:");
                    int mes = t.nextInt();
                    System.out.println("Ingrese el año:");
                    int año = t.nextInt();
                    System.out.println("Ingrese el nombre:");
                    String nombre = t.next();
                    System.out.println("Ingrese la carrera:");
                    String carrera = t.next();
                    System.out.println("Ingrese la facultad:");
                    String facultad = t.next();
                    System.out.println("¿Es abanderado? (si/no):");
                    String abanderado = t.next();
                    System.out.println("Ingrese su bachillerato (Ciencia/Tecnico):");
                    String bachillerato = t.next();
                    utpl.llamarPostulanteUnico(dia, mes, año, nombre, carrera, facultad, abanderado, bachillerato);
                    utpl.verificarFecha(diaA, mesA, añoA);
                    utpl.asignarMeritos(facultadesCiencias, facultadesIngenieria);
                    utpl.asignarExamen(carrerasND, carrerasCD);
                    break;
                case 2:
                    System.out.println("¿Cuántos estudiantes desea ingresar?");
                    int numP = t.nextInt();
                    utpl.llamarPostulantesAleatorios(nombres, carrerasND, carrerasCD, facultades, abanderados, bachilleratos, numP);
                    utpl.verificarFecha(diaA, mesA, añoA);
                    utpl.asignarMeritos(facultadesCiencias, facultadesIngenieria);
                    utpl.asignarExamen(carrerasND, carrerasCD);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

            System.out.println("¿Desea realizar otra operación? (si/no)");
            String continuar = t.next();
            if (continuar.equalsIgnoreCase("no")) {
                opc = 0;
            }

        } while (opc != 0);

        utpl.mostrarPostulantes();
        utpl.guardarPostulantesEnArchivoDat("postulantes.dat");
        utpl.guardarPostulantesEnArchivosTxt();
    }
}
