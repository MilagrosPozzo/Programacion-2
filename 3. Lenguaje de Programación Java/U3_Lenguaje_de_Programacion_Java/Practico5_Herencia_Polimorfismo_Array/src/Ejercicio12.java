/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
// EJERCICIO 12 - Identificador: Ej12
// Clase abstracta Robot con subclases RobotLimpieza y RobotCocina; usamos un arreglo y ejecutamos tareas.
public class Ejercicio12 { // clase pública Ejercicio12
    public static void main(String[] args) { // método main
        Robot[] robots = new Robot[] { // arreglo polimórfico de robots
            new RobotLimpieza("Roomba X"), // robot de limpieza
            new RobotCocina("ChefBot 2000"), // robot de cocina
            new RobotLimpieza("CleanMaster"), // otro robot de limpieza
            new RobotCocina("CocinaPro") // otro robot de cocina
        }; // fin arreglo

        // pedimos a cada robot que realice su tarea (polimorfismo)
        for (Robot r : robots) { // iteramos el arreglo
            System.out.println("Robot: " + r.getNombre()); // mostramos nombre del robot
            r.realizarTarea(); // ejecutamos la tarea específica de la subclase
            System.out.println(); // línea en blanco entre robots
        } // fin for
    } // fin main
} // fin clase Ejercicio12

// clase abstracta Robot con atributo nombre y método abstracto realizarTarea()
abstract class Robot { // definición de Robot
    protected String nombre; // atributo para identificar el robot

    public Robot(String nombre) { // constructor que inicializa el nombre
        this.nombre = nombre; // asignación del nombre
    } // fin constructor

    public String getNombre() { // método getter para obtener el nombre
        return nombre; // devolvemos el nombre
    } // fin getNombre

    public abstract void realizarTarea(); // método abstracto a implementar por subclases
} // fin Robot

// RobotLimpieza implementa realizarTarea como barrer y aspirar
class RobotLimpieza extends Robot { // subclase de Robot
    public RobotLimpieza(String nombre) { // constructor
        super(nombre); // llama al constructor base
    } // fin constructor

    @Override
    public void realizarTarea() { // implementación de la tarea de limpieza
        System.out.println(nombre + " está barriendo y aspirando el piso."); // mensaje descriptivo
    } // fin realizarTarea
} // fin RobotLimpieza

// RobotCocina implementa realizarTarea como preparar una receta simple
class RobotCocina extends Robot { // subclase de Robot
    public RobotCocina(String nombre) { // constructor
        super(nombre); // llama al constructor base
    } // fin constructor

    @Override
    public void realizarTarea() { // implementación de la tarea de cocina
        System.out.println(nombre + " está preparando la comida: salteando verduras."); // mensaje
    } // fin realizarTarea
} // fin RobotCocina