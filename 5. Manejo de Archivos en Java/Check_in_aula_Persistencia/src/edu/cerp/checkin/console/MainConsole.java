// Paquete correcto: debe coincidir con la carpeta donde está este archivo
package edu.cerp.checkin.console;

import edu.cerp.checkin.logic.SesionService;
import edu.cerp.checkin.model.Inscripcion;

import java.util.List;
import java.util.Scanner;

/**
 * Interfaz de consola para el sistema Check-in Aula.
 * Proporciona un menú interactivo para gestionar inscripciones sin interfaz gráfica.
 */
public class MainConsole {
    
    // === MÉTODO PRINCIPAL DE LA INTERFAZ DE CONSOLA ===
    /**
     * Ejecuta el bucle principal del menú de consola.
     * @param service servicio que gestiona la lógica de negocio
     */
    public static void run(SesionService service) {
        Scanner sc = new Scanner(System.in);
        int op = -1; // Inicializar con valor inválido

        // Mostrar cantidad de datos cargados al inicio (feedback al usuario)
        System.out.println("Datos cargados: " + service.listar().size() + " inscripciones."); // línea informativa

       // === BUCLE PRINCIPAL DEL MENÚ ===
        while (op != 0) {
            // Mostrar menú de opciones
            System.out.println("\n== Check-in Aula (Consola) ==");
            System.out.println("1) Registrar  2) Listar  3) Buscar  4) Resumen  0) Salir");
            System.out.print("> ");
            // Leer entrada del usuario
            String s = sc.nextLine().trim();
            if (s.isEmpty()) continue; // Si presiona Enter sin escribir, volver a mostrar menú

            // Convertir entrada a número con manejo de errores
            try { 
                op = Integer.parseInt(s); 
            } catch (Exception e) { 
                op = -1; // Si no es un número válido, forzar opción inválida
            }

            // === PROCESAR OPCIÓN SELECCIONADA ===
            switch (op) {
                case 1 -> { // Opción 1: Registrar nueva inscripción
                    System.out.print("Nombre: ");
                    String n = sc.nextLine();
                    System.out.print("Documento: ");
                    String d = sc.nextLine();
                    System.out.print("Curso [Prog 1/Prog 2/Base de Datos]: ");
                    String c = sc.nextLine();

                    // Delegar registro al servicio (incluye validaciones y guardado)
                    service.registrar(n, d, c);
                    System.out.println("Registrado correctamente.");
                }
                case 2 -> listar(service.listar()); // Opción 2: Listar todas las inscripciones
                case 3 -> { // Opción 3: Buscar por nombre o documento
                    System.out.print("Buscar: ");
                    String q = sc.nextLine();
                    listar(service.buscar(q)); // Mostrar resultados filtrados
                }
                case 4 -> System.out.println(service.resumen());// Opción 4: Mostrar resumen estadístico
                case 0 -> System.out.println("Adiós"); // Opción 0: Salir del programa
                default -> System.out.println("Opción inválida"); // Cualquier otro número
            }
        }
        // Nota: Scanner se cierra automáticamente al terminar el método
    }

    // === MÉTODO AUXILIAR PARA VISUALIZACIÓN ===
    /**
     * Muestra una lista de inscripciones en formato tabla simple.
     * @param ls lista de inscripciones a mostrar
     */
    private static void listar(List<Inscripcion> ls) {
        // Mostrar encabezado de la tabla
        System.out.println("Nombre | Documento | Curso | Hora");
        
        // Mostrar cada inscripción en una línea
        for (Inscripcion i : ls) {
            System.out.println(i.getNombre() + " | " + i.getDocumento() + " | " + i.getCurso() + " | " + i.getFechaHora());
        }
        // Nota: Si la lista está vacía, solo se muestra el encabezado
    }
}