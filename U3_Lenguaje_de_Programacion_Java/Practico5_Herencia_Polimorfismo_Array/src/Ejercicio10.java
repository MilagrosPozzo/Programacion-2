/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
// EJERCICIO 10 - Identificador: Ej10
// Clase Sensor con atributo valor y método medir(); implementamos SensorTemperatura y SensorPresion.
import java.util.Random; // import para generar valores simulados

public class Ejercicio10 { // clase pública Ejercicio10
    public static void main(String[] args) { // método main
        Sensor[] sensores = new Sensor[] { // arreglo polimórfico de sensores
            new SensorTemperatura(), // sensor de temperatura
            new SensorPresion(), // sensor de presión
            new SensorTemperatura(), // otro sensor de temperatura
            new SensorPresion() // otro sensor de presión
        }; // fin arreglo

        // recorremos el arreglo y mostramos la medición de cada sensor
        for (int i = 0; i < sensores.length; i++) { // bucle sobre sensores
            double valor = sensores[i].medir(); // medimos (implementación propia en cada subclase)
            System.out.println("Sensor " + (i+1) + " (" + sensores[i].getClass().getSimpleName() + "): " + valor);
            // imprimimos la clase del sensor y el valor obtenido
        } // fin for
    } // fin main
} // fin clase Ejercicio10

// Clase base Sensor (abstracta) con atributo valor.
abstract class Sensor { // clase base abstracta
    protected double valor; // atributo para almacenar la última medición
    public abstract double medir(); // método abstracto que debe devolver la medición
} // fin Sensor

// SensorTemperatura genera un valor simulado de temperatura en °C.
class SensorTemperatura extends Sensor { // subclase de Sensor
    private Random rnd = new Random(); // generador aleatorio propio

    @Override
    public double medir() { // implementación que simula temperatura
        // generamos temperatura entre -10.0 y 40.0 °C
        valor = -10.0 + rnd.nextDouble() * (40.0 + 10.0); // fórmula para rango
        // redondeamos a 2 decimales para presentación
        valor = Math.round(valor * 100.0) / 100.0; // redondeo
        return valor; // devolvemos el valor medido
    } // fin medir
} // fin SensorTemperatura

// SensorPresion genera un valor simulado de presión atmosférica en hPa.
class SensorPresion extends Sensor { // subclase de Sensor
    private Random rnd = new Random(); // generador aleatorio

    @Override
    public double medir() { // implementación que simula presión
        // generamos presión entre 950.0 y 1050.0 hPa
        valor = 950.0 + rnd.nextDouble() * 100.0; // fórmula para rango 950-1050
        // redondeamos a 1 decimal
        valor = Math.round(valor * 10.0) / 10.0; // redondeo
        return valor; // devolvemos el valor medido
    } // fin medir
} // fin SensorPresion