/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */

// EJERCICIO 15 - Identificador: Ej15
// Simulamos una carrera de Vehiculo (Auto y Moto) con 5 rondas y distancia aleatoria por turno.
import java.util.Random; // import para números aleatorios

public class Ejercicio15 { // clase pública Ejercicio15
    public static void main(String[] args) { // método main
        Vehiculo[] competidores = new Vehiculo[] { // arreglo polimórfico de competidores
            new Auto("Auto1"), // auto 1
            new Moto("Moto1"), // moto 1
            new Auto("Auto2"), // auto 2
            new Moto("Moto2") // moto 2
        }; // fin arreglo

        Random rnd = new Random(); // generador aleatorio para las distancias
        int rondas = 5; // número de rondas a simular

        // inicializamos distancias recorridas a cero
        for (Vehiculo v : competidores) { // para cada competidor
            v.setDistanciaRecorrida(0.0); // ponemos distancia inicial en 0.0
        } // fin for

        // simulamos las rondas
        for (int r = 1; r <= rondas; r++) { // bucle de rondas (1..5)
            System.out.println("=== Ronda " + r + " ==="); // encabezado de ronda
            for (Vehiculo v : competidores) { // cada competidor avanza una distancia aleatoria
                double avance = 1.0 + rnd.nextDouble() * 9.0; // avance entre 1.0 y 10.0
                v.avanzar(avance); // el vehículo avanza esa distancia (método polimórfico puede modificar)
                System.out.println(v.getNombre() + " avanza " + String.format("%.2f", avance) 
                                   + " m (Total: " + String.format("%.2f", v.getDistanciaRecorrida()) + " m)");
                // mostramos avance y total acumulado
            } // fin for competidores
            System.out.println(); // línea en blanco entre rondas
        } // fin for rondas

        // determinamos el ganador (mayor distancia acumulada)
        Vehiculo ganador = competidores[0]; // asumimos primer competidor como candidato inicial
        for (int i = 1; i < competidores.length; i++) { // recorremos el resto
            if (competidores[i].getDistanciaRecorrida() > ganador.getDistanciaRecorrida()) { // comparativa
                ganador = competidores[i]; // actualizamos ganador si encontramos mayor distancia
            } // fin if
        } // fin for

        // mostramos el resultado final
        System.out.println("GANADOR: " + ganador.getNombre() + " con " + 
                           String.format("%.2f", ganador.getDistanciaRecorrida()) + " m recorridos.");
    } // fin main
} // fin clase Ejercicio15

// Clase base Vehiculo con nombre y distancia acumulada.
abstract class Vehiculo { // clase base para vehículos
    protected String nombre; // nombre identificador del vehículo
    protected double distanciaRecorrida; // distancia total acumulada

    public Vehiculo(String nombre) { // constructor
        this.nombre = nombre; // asignación nombre
        this.distanciaRecorrida = 0.0; // inicializamos distancia en 0.0
    } // fin constructor

    public String getNombre() { // getter del nombre
        return nombre; // devuelve nombre
    } // fin getNombre

    public double getDistanciaRecorrida() { // getter de distancia acumulada
        return distanciaRecorrida; // devuelve distancia
    } // fin getDistanciaRecorrida

    public void setDistanciaRecorrida(double d) { // setter de distancia (uso inicial)
        this.distanciaRecorrida = d; // asigna distancia
    } // fin setter

    // avanzar añade la distancia al acumulador; puede sobrescribirse si se desea
    public void avanzar(double metros) { // método que actualiza la distancia
        this.distanciaRecorrida += metros; // sumamos metros recorridos
    } // fin avanzar
} // fin Vehiculo

// Subclase Auto (no modifica el comportamiento por defecto)
class Auto extends Vehiculo { // Auto extiende Vehiculo
    public Auto(String nombre) { // constructor Auto
        super(nombre); // invoca constructor base
    } // fin constructor

    // podemos sobrescribir avanzar() si queremos reglas especiales; aquí usamos la base
} // fin Auto

// Subclase Moto (podríamos darle ventaja o penalización, pero mantendremos simple)
class Moto extends Vehiculo { // Moto extiende Vehiculo
    public Moto(String nombre) { // constructor Moto
        super(nombre); // invoca constructor base
    } // fin constructor

    // ejemplo: podríamos sobrescribir avanzar para que motos tengan ligera ventaja:
    @Override
    public void avanzar(double metros) { // sobrescribimos avanzar para motos
        double bonus = 0.05 * metros; // la moto añade un 5% extra de avance (simulado)
        this.distanciaRecorrida += metros + bonus; // aplicamos avance + bonus
    } // fin avanzar
} // fin Moto