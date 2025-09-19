/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
// EJERCICIO 14 - Identificador: Ej14
// Creamos un arreglo de Figura (abstracta) con Poligono y Estrella y contamos con instanceof.
public class Ejercicio14 { // clase pública Ejercicio14
    public static void main(String[] args) { // método main
        Figura[] figuras = new Figura[] { // arreglo con mezcla de figuras
            new Poligono(5), // polígono de 5 lados
            new Estrella(5), // estrella de 5 puntas
            new Poligono(3), // polígono triangular
            new Estrella(6), // estrella de 6 puntas
            new Poligono(4) // polígono de 4 lados
        }; // fin arreglo

        int contadorPoligonos = 0; // contador para poligonos
        int contadorEstrellas = 0; // contador para estrellas

        for (Figura f : figuras) { // iteramos el arreglo de figuras
            if (f instanceof Poligono) { // verificamos si es instancia de Poligono
                contadorPoligonos++; // incrementamos contador de polígonos
            } else if (f instanceof Estrella) { // verificamos si es instancia de Estrella
                contadorEstrellas++; // incrementamos contador de estrellas
            } // fin if
        } // fin for

        // mostramos los resultados
        System.out.println("Polígonos: " + contadorPoligonos); // imprime cantidad de polígonos
        System.out.println("Estrellas: " + contadorEstrellas); // imprime cantidad de estrellas
    } // fin main
} // fin clase Ejercicio14

// Figura abstracta base
abstract class Figura { // clase base para figuras
    // podríamos agregar métodos como area() o dibujar(), pero no se pide
} // fin Figura

// Poligono con número de lados
class Poligono extends Figura { // subclase Poligono
    private int lados; // atributo cantidad de lados

    public Poligono(int lados) { // constructor que recibe número de lados
        this.lados = lados; // asignación del número de lados
    } // fin constructor

    public int getLados() { // getter para número de lados
        return lados; // devuelve el número de lados
    } // fin getLados
} // fin Poligono

// Estrella con número de puntas
class Estrella extends Figura { // subclase Estrella
    private int puntas; // atributo cantidad de puntas

    public Estrella(int puntas) { // constructor que recibe número de puntas
        this.puntas = puntas; // asignación del número de puntas
    } // fin constructor

    public int getPuntas() { // getter para puntas
        return puntas; // devuelve la cantidad de puntas
    } // fin getPuntas
} // fin Estrella