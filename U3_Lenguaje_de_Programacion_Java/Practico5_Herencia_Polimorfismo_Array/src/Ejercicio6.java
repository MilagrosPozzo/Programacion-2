/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
/*
 Desafío 6 - Nivel inicial (explicación en lenguaje sencillo)

 Estrategia:
 1) Crear la clase abstracta Personaje con nombre y nivel.
 2) Definir el método abstracto accionEspecial(), sin cuerpo.
 3) Crear las clases Mago y Guerrero que heredan de Personaje.
 4) Cada una implementa su propia versión de accionEspecial().
 5) En el main, instanciamos un Mago y un Guerrero y probamos sus acciones.
*/

// Clase abstracta base: sirve como "plantilla"
abstract class Personaje {
    protected String nombre; // Nombre del personaje
    protected int nivel;     // Nivel del personaje

    // Constructor para inicializar atributos
    public Personaje(String nombre, int nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    // Método abstracto: las clases hijas están obligadas a implementarlo
    public abstract void accionEspecial();

    // Método común: mostrar la información del personaje
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + " | Nivel: " + nivel);
    }
}

// Clase Mago que hereda de Personaje
class Mago extends Personaje {
    public Mago(String nombre, int nivel) {
        super(nombre, nivel);
    }

    // Implementación propia de la acción especial
    @Override
    public void accionEspecial() {
        System.out.println(nombre + " lanza un hechizo de fuego");
    }
}

// Clase Guerrero que hereda de Personaje
class Guerrero extends Personaje {
    public Guerrero(String nombre, int nivel) {
        super(nombre, nivel);
    }

    // Implementación propia de la acción especial
    @Override
    public void accionEspecial() {
        System.out.println(nombre + " realiza un ataque con su espada");
    }
}

// Clase principal con el main para probar
class Desafio6 {
    public static void main(String[] args) {
        // Creamos un Mago y un Guerrero
        Personaje mago = new Mago("Gandalf", 50);
        Personaje guerrero = new Guerrero("Aragorn", 45);

        // Mostramos su información
        mago.mostrarInfo();
        guerrero.mostrarInfo();

        // Cada uno ejecuta su acción especial (polimorfismo en acción)
        mago.accionEspecial();
        guerrero.accionEspecial();
    }
}