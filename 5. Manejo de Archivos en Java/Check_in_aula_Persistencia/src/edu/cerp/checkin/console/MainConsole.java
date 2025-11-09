package edu.cerp.checkin.console;

import edu.cerp.checkin.logic.SesionService;
import edu.cerp.checkin.model.Inscripcion;

import java.util.List;
import java.util.Scanner;

/**
 * Modo consola para el sistema de Check-in Aula.
 * Permite registrar, listar, buscar y ver resumen de inscripciones.
 */
public class MainConsole {
    public static void run(SesionService service) {
        Scanner sc = new Scanner(System.in);
        int op = -1;

        System.out.println("✅ Datos cargados: " + service.listar().size() + " inscripciones."); // línea informativa

        while (op != 0) {
            System.out.println("\n== Check-in Aula (Consola) ==");
            System.out.println("1) Registrar  2) Listar  3) Buscar  4) Resumen  0) Salir");
            System.out.print("> ");
            String s = sc.nextLine().trim();
            if (s.isEmpty()) continue;

            try { 
                op = Integer.parseInt(s); 
            } catch (Exception e) { 
                op = -1; 
            }

            switch (op) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String n = sc.nextLine();
                    System.out.print("Documento: ");
                    String d = sc.nextLine();
                    System.out.print("Curso [Prog 1/Prog 2/Base de Datos]: ");
                    String c = sc.nextLine();

                    service.registrar(n, d, c);
                    System.out.println("✔ Registrado correctamente.");
                }
                case 2 -> listar(service.listar());
                case 3 -> {
                    System.out.print("Buscar: ");
                    String q = sc.nextLine();
                    listar(service.buscar(q));
                }
                case 4 -> System.out.println(service.resumen());
                case 0 -> System.out.println("👋 Adiós");
                default -> System.out.println("❌ Opción inválida");
            }
        }
    }

    // Método auxiliar para mostrar lista de inscripciones
    private static void listar(List<Inscripcion> ls) {
        System.out.println("Nombre | Documento | Curso | Hora");
        for (Inscripcion i : ls) {
            System.out.println(i.getNombre() + " | " + i.getDocumento() + " | " + i.getCurso() + " | " + i.getFechaHora());
        }
    }
}