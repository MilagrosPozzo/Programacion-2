/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Milagros Pozzo
 */

package plataformaeducativapoo.vista;
// Esta clase pertenece al paquete 'vista', porque se encarga de mostrar mensajes al usuario.

import plataformaeducativapoo.controlador.GestorPreguntas;
import plataformaeducativapoo.modelo.Pregunta;
// Importamos nuestras propias clases: GestorPreguntas (controla las preguntas) y Pregunta (representa cada una).

import java.util.List;
import java.util.Scanner;
// Importamos clases de Java: List (para listas) y Scanner (para leer lo que escribe el usuario).

public class MenuConsola {
    // Declaramos una clase pública llamada MenuConsola.

    private GestorPreguntas gestor;
    // Esta variable guarda el objeto que tiene todas las preguntas del sistema.

    private Scanner scanner;
    // Esta variable permite leer lo que el usuario escribe en la consola.

    public MenuConsola(GestorPreguntas gestor) {
        // Este es el constructor. Se usa para crear un nuevo objeto de tipo MenuConsola.
        // Le pasamos el gestor desde afuera para usar sus preguntas.

        this.gestor = gestor;
        // Guardamos el gestor en la variable de la clase.

        this.scanner = new Scanner(System.in);
        // Creamos un lector para poder leer desde el teclado.
    }

    public void mostrar() {
        // Este método se llama "mostrar" y va a encargarse de mostrar el menú y la pregunta al usuario.

        System.out.println("===== Menú de Preguntas sobre POO =====");

        List<Pregunta> preguntas = gestor.obtenerAleatorias(1);
        // Pedimos al gestor una lista con 1 pregunta aleatoria.
        // Usamos una lista porque podrían ser varias.

        for (Pregunta pregunta : preguntas) {
            // Recorremos la lista de preguntas. En este caso solo hay una, pero la estructura permite varias.

            System.out.println(pregunta.getEnunciado());
            // Mostramos en pantalla el texto de la pregunta.

            List<String> opciones = pregunta.getOpciones();
            // Obtenemos la lista de opciones para esa pregunta.

            for (int i = 0; i < opciones.size(); i++) {
                System.out.println((i + 1) + ". " + opciones.get(i));
            }
            // Mostramos cada opción en una línea. El número va de 1 en adelante (por eso usamos i + 1).

            System.out.print("Tu respuesta: ");
            int respuesta = scanner.nextInt() - 1;
            // Leemos la respuesta que elige el usuario. Restamos 1 para que coincida con el índice de la lista.

            if (pregunta.esCorrecta(respuesta)) {
                System.out.println("✅ ¡Correcto!");
            } else {
                System.out.println("❌ Incorrecto. La respuesta correcta era: " +
                        opciones.get(pregunta.getIndiceCorrecto()));
            }
            // Verificamos si la respuesta del usuario es correcta usando un método de la clase Pregunta.
            // Si se equivocó, mostramos cuál era la correcta.
        }

        System.out.println("=======================================");
        System.out.println("Gracias por usar el sistema educativo.");
        // Cerramos el programa con un mensaje final.
    }
}