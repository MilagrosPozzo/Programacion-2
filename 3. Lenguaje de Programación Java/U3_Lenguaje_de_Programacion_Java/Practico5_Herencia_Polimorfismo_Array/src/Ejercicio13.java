/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
// EJERCICIO 13 - Identificador: Ej13
// VehiculoAereo abstracto con Avion y Helicoptero; mostramos orden de despegue según posición en arreglo.
public class Ejercicio13 { // clase pública Ejercicio13
    public static void main(String[] args) { // método main
        VehiculoAereo[] flota = new VehiculoAereo[] { // arreglo polimórfico de vehículos aéreos
            new Avion("Boeing 737"), // posición 0
            new Helicoptero("Apache"), // posición 1
            new Avion("Airbus A320"), // posición 2
            new Helicoptero("Bell 206") // posición 3
        }; // fin arreglo

        // mostramos el orden de despegue según la posición en el arreglo (orden de índice)
        for (int i = 0; i < flota.length; i++) { // iteramos por índice
            System.out.println("Turno de despegue " + (i+1) + ":"); // número de turno
            flota[i].despegar(); // llamamos al método despegar de cada vehículo (polimórfico)
            System.out.println(); // separación visual
        } // fin for
    } // fin main
} // fin clase Ejercicio13

// clase abstracta VehiculoAereo con método despegar()
abstract class VehiculoAereo { // definición de la clase base
    protected String identificador; // nombre o identificador de la aeronave

    public VehiculoAereo(String id) { // constructor que inicializa identificador
        this.identificador = id; // asignación del identificador
    } // fin constructor

    public abstract void despegar(); // método abstracto que realizan las subclases
} // fin VehiculoAereo

// Avion implementa despegar con procedimiento típico de pista
class Avion extends VehiculoAereo { // subclase Avion
    public Avion(String id) { // constructor
        super(id); // invoca constructor base
    } // fin constructor

    @Override
    public void despegar() { // acción de despegue para avión
        System.out.println("Avión " + identificador + " acelera por la pista y despega.");
    } // fin despegar
} // fin Avion

// Helicoptero implementa despegar con despegue vertical
class Helicoptero extends VehiculoAereo { // subclase Helicoptero
    public Helicoptero(String id) { // constructor
        super(id); // invoca constructor base
    } // fin constructor

    @Override
    public void despegar() { // acción de despegue para helicóptero
        System.out.println("Helicóptero " + identificador + " eleva verticalmente y despega.");
    } // fin despegar
} // fin Helicoptero