/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
// EJERCICIO 9 - Identificador: Ej9
// Creamos un arreglo de InstrumentoMusical y hacemos que toquen una secuencia de notas aleatorias.
import java.util.Random; // import para generación de números aleatorios

public class Ejercicio9 { // clase pública Ejercicio9
    public static void main(String[] args) { // método main
        InstrumentoMusical[] orquesta = new InstrumentoMusical[] { // arreglo con distintos instrumentos
            new Guitarra(), // guitarra 1
            new Piano(), // piano 1
            new Guitarra(), // guitarra 2
            new Piano() // piano 2
        }; // fin arreglo

        String[] notas = {"A", "B", "C", "D", "E", "F", "G", "C#", "D#"}; // conjunto de notas posibles
        Random rnd = new Random(); // generador aleatorio

        // hacemos que cada instrumento toque 5 notas aleatorias
        for (int i = 0; i < orquesta.length; i++) { // iteramos instrumentos
            System.out.println("Instrumento " + (i+1) + ":"); // indicamos qué instrumento toca
            for (int j = 0; j < 5; j++) { // cada instrumento tocará 5 notas
                String nota = notas[rnd.nextInt(notas.length)]; // elegimos nota aleatoria
                orquesta[i].tocarNota(nota); // pedimos al instrumento que toque la nota
            } // fin for j
            System.out.println(); // línea en blanco entre instrumentos
        } // fin for i
    } // fin main
} // fin clase Ejercicio9

// Reutilizamos InstrumentoMusical, Guitarra y Piano (no públicas).
abstract class InstrumentoMusical { // clase base abstracta
    public abstract void tocarNota(String nota); // firma del método
} // fin InstrumentoMusical

class Guitarra extends InstrumentoMusical { // Guitarra implementa InstrumentoMusical
    @Override
    public void tocarNota(String nota) { // comportamiento guitarra
        System.out.println("  Guitarra: rasgueo -> " + nota); // imprime acción
    } // fin tocarNota
} // fin Guitarra

class Piano extends InstrumentoMusical { // Piano implementa InstrumentoMusical
    @Override
    public void tocarNota(String nota) { // comportamiento piano
        System.out.println("  Piano: nota teclada -> " + nota); // imprime acción
    } // fin tocarNota
} // fin Piano