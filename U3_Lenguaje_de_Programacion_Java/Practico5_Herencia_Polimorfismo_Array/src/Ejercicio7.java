/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
// EJERCICIO 7 - Identificador: Ej7
// Programa que crea un arreglo polimórfico de Personaje y ejecuta accionEspecial() en todos.
public class Ejercicio7 { // clase pública del archivo Ejercicio7.java
    public static void main(String[] args) { // método main para ejecutar el ejemplo
        // creamos un arreglo de Personaje con 4 elementos (polimórfico)
        Personaje[] equipo = new Personaje[4]; // arreglo capaz de almacenar Mago y Guerrero
        equipo[0] = new Mago("Merlín", 12); // primer elemento: Mago
        equipo[1] = new Guerrero("Asterix", 9); // segundo elemento: Guerrero
        equipo[2] = new Mago("Morgana", 7); // tercero: otro Mago
        equipo[3] = new Guerrero("Leonidas", 11); // cuarto: otro Guerrero

        // iteramos el arreglo y hacemos que cada personaje ejecute su accionEspecial()
        for (int i = 0; i < equipo.length; i++) { // bucle sobre índices del arreglo
            System.out.print("Personaje " + (i+1) + ": "); // mostramos índice legible
            equipo[i].accionEspecial(); // llamada polimórfica al método implementado por cada subclase
        } // fin del for
    } // fin del main
} // fin de la clase Ejercicio7

// Reuso las mismas clases Personaje, Mago y Guerrero (no públicas, definidas aquí).
abstract class Personaje { // clase base abstracta
    protected String nombre; // nombre del personaje
    protected int nivel; // nivel del personaje

    public Personaje(String nombre, int nivel) { // constructor
        this.nombre = nombre; // asignación nombre
        this.nivel = nivel; // asignación nivel
    } // fin constructor

    public abstract void accionEspecial(); // método abstracto a implementar
} // fin Personaje

class Mago extends Personaje { // subclase Mago
    public Mago(String nombre, int nivel) { // constructor Mago
        super(nombre, nivel); // invoca constructor de Personaje
    } // fin constructor

    @Override
    public void accionEspecial() { // acción especial del mago
        System.out.println("Mago " + nombre + " conjura un rayo místico."); // imprime acción
    } // fin metodo
} // fin Mago

class Guerrero extends Personaje { // subclase Guerrero
    public Guerrero(String nombre, int nivel) { // constructor Guerrero
        super(nombre, nivel); // invoca constructor base
    } // fin constructor

    @Override
    public void accionEspecial() { // acción especial del guerrero
        System.out.println("Guerrero " + nombre + " ejecuta una embestida."); // imprime acción
    } // fin metodo
} // fin Guerrero