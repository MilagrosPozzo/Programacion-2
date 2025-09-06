/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
// EJERCICIO 6 - Identificador: Ej6
// Clase principal para probar Personaje, Mago y Guerrero.
// Cada línea tiene un comentario explicativo para pegar en NetBeans.
public class Ejercicio6 { // clase pública del archivo Ejercicio6.java
    public static void main(String[] args) { // método main para ejecutar el ejemplo
        Personaje mago = new Mago("Gandalf", 10); // instanciamos un Mago con nombre y nivel
        mago.accionEspecial(); // mostramos la acción especial del mago (polimorfismo)
        Personaje guerrero = new Guerrero("Conan", 8); // instanciamos un Guerrero
        guerrero.accionEspecial(); // mostramos la acción especial del guerrero
    } // fin del main
} // fin de la clase Ejercicio6

// Clase abstracta Personaje con atributos nombre y nivel.
// No se declara 'public' porque ya hay una clase pública en este archivo.
abstract class Personaje { // definición de la clase base abstracta
    protected String nombre; // atributo para almacenar el nombre del personaje
    protected int nivel; // atributo para almacenar el nivel del personaje

    public Personaje(String nombre, int nivel) { // constructor para inicializar atributos
        this.nombre = nombre; // asignación del nombre recibido
        this.nivel = nivel; // asignación del nivel recibido
    } // fin del constructor

    // método abstracto que deberá implementar cada subclase.
    public abstract void accionEspecial(); // firma del método abstracto
} // fin de la clase Personaje

// Implementación de la clase Mago que hereda de Personaje.
class Mago extends Personaje { // Mago extiende Personaje
    public Mago(String nombre, int nivel) { // constructor de Mago
        super(nombre, nivel); // invoca al constructor de la clase base
    } // fin del constructor

    @Override // indicamos que sobrescribimos el método abstracto
    public void accionEspecial() { // implementación concreta para Mago
        // mostramos en pantalla la acción especial del mago utilizando nombre y nivel
        System.out.println("Mago " + nombre + " (nv " + nivel + ") lanza un hechizo de fuego."); 
    } // fin de accionEspecial
} // fin de la clase Mago

// Implementación de la clase Guerrero que hereda de Personaje.
class Guerrero extends Personaje { // Guerrero extiende Personaje
    public Guerrero(String nombre, int nivel) { // constructor de Guerrero
        super(nombre, nivel); // invoca el constructor de la clase base
    } // fin del constructor

    @Override // indicamos que sobrescribimos el método abstracto
    public void accionEspecial() { // implementación concreta para Guerrero
        // mostramos en pantalla la acción especial del guerrero utilizando nombre y nivel
        System.out.println("Guerrero " + nombre + " (nv " + nivel + ") realiza un ataque poderoso."); 
    } // fin de accionEspecial
} // fin de la clase Guerrero
