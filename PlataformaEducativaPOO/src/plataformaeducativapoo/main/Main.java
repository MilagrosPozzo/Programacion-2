/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Milagros Pozzo
 */
package plataformaeducativapoo.main;
// Este archivo pertenece al paquete principal del sistema, donde comienza la ejecución de la aplicación.

import plataformaeducativapoo.controlador.GestorPreguntas;
import plataformaeducativapoo.modelo.Pregunta;
// Importamos las clases que nosotros mismos creamos: GestorPreguntas y Pregunta.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Importamos clases de Java: ArrayList y List (para los arreglos), y Scanner para leer desde teclado.

public class Main {
    // Declaramos la clase principal con el mismo nombre del archivo: Main

    public static void main(String[] args) {
        // Método principal. Es el punto de entrada del programa Java.

        GestorPreguntas gestor = new GestorPreguntas();
        // Creamos un nuevo objeto de tipo GestorPreguntas, que manejará nuestro "banco" de preguntas.

        List<String> opciones1 = new ArrayList<>();
        // Creamos una lista de tipo String que va a guardar las opciones de respuesta para una pregunta.
        // Usamos ArrayList porque permite guardar varios datos y manipularlos fácilmente.

        opciones1.add("Encapsulamiento");
        opciones1.add("Herencia");
        opciones1.add("Abstracción");
        opciones1.add("Polimorfismo");
        // Agregamos 4 opciones a la lista usando el método add. Cada opción es un String.

        Pregunta p1 = new Pregunta("¿Cuál es un concepto fundamental de la POO?", opciones1, 2);
        // Creamos una nueva pregunta usando nuestro constructor. Le pasamos:
        // 1. El enunciado de la pregunta (String)
        // 2. La lista de opciones
        // 3. El índice de la respuesta correcta (en este caso 2 = "Abstracción")

        gestor.agregarPregunta(p1);
        // Agregamos la pregunta al banco de preguntas del gestor, usando el método personalizado agregarPregunta.

        Scanner scanner = new Scanner(System.in);
        // Creamos un objeto Scanner que permite leer lo que el usuario escribe por teclado.

        System.out.println("Bienvenido al sistema de preguntas POO");
        System.out.println("-------------------------------------------------");
        // Mensajes de bienvenida que se muestran en consola

        List<Pregunta> preguntas = gestor.obtenerAleatorias(1);
        // Usamos el método obtenerAleatorias para sacar una sola pregunta al azar de las que están en el banco.
        // Se devuelve una lista con esa(s) pregunta(s)

        for (Pregunta pregunta : preguntas) {
            // Recorremos la lista de preguntas con un ciclo for-each. En este caso solo hay una.

            System.out.println(pregunta.getEnunciado());
            // Mostramos el texto de la pregunta usando el getter que definimos antes.

            List<String> opciones = pregunta.getOpciones();
            // Obtenemos la lista de opciones de respuesta usando el getter de la clase Pregunta.

            for (int i = 0; i < opciones.size(); i++) {
                System.out.println((i + 1) + ". " + opciones.get(i));
            }
            // Recorremos la lista de opciones con un ciclo for clásico.
            // Imprimimos cada opción, numerada desde 1 (por eso usamos i + 1)

            System.out.print("Tu respuesta (ingresá el número): ");
            int respuesta = scanner.nextInt() - 1;
            // Leemos la respuesta del usuario y le restamos 1 para convertirla al índice de la lista

            if (pregunta.esCorrecta(respuesta)) {
                System.out.println("¡Correcto!");
            } else {
                System.out.println("Incorrecto. La respuesta correcta era: " + opciones.get(pregunta.getIndiceCorrecto()));
            }
            // Verificamos si la respuesta es correcta usando el método esCorrecta de la clase Pregunta.
            // Si no lo es, mostramos la opción correcta accediendo a la posición guardada.

        }

        System.out.println("Gracias por participar.");
        // Mensaje final para cerrar la actividad
    }
}