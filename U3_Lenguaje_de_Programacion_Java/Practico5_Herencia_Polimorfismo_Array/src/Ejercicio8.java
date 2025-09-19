/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
// EJERCICIO 8 - Identificador: Ej8
// InstrumentoMusical abstracto con Guitarra y Piano que implementan tocarNota(String).
public class Ejercicio8 { // clase pública Ejercicio8
    public static void main(String[] args) { // método main
        InstrumentoMusical g = new Guitarra(); // instanciamos una Guitarra
        InstrumentoMusical p = new Piano(); // instanciamos un Piano

        g.tocarNota("A"); // la guitarra toca la nota A
        p.tocarNota("A"); // el piano toca la misma nota A (comportamiento distinto)
        g.tocarNota("C#"); // guitarra toca C#
        p.tocarNota("C#"); // piano toca C#
    } // fin main
} // fin clase Ejercicio8

abstract class InstrumentoMusical { // clase base abstracta
    public abstract void tocarNota(String nota); // método abstracto para tocar una nota
} // fin InstrumentoMusical

class Guitarra extends InstrumentoMusical { // implementación de Guitarra
    @Override
    public void tocarNota(String nota) { // comportamiento al tocar nota en guitarra
        // simulamos sonido de guitarra con rasgueo y sustain
        System.out.println("Guitarra: rasgueo de la nota " + nota + " (sonido cálido).");
    } // fin tocarNota
} // fin Guitarra

class Piano extends InstrumentoMusical { // implementación de Piano
    @Override
    public void tocarNota(String nota) { // comportamiento al tocar nota en piano
        // simulamos sonido de piano con ataque definido y decaimiento
        System.out.println("Piano: tecla pulsada -> nota " + nota + " (sonido claro).");
    } // fin tocarNota
} // fin Piano