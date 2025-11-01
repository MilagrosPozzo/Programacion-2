/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Problema 540 -El código siguiente invierte los valores de nombre y edad, y usa el tipo primitivo incorrectamente.
class Estudiante {
int nombre;
String edad;
}

Estudiante estudiante = new Estudiante();
estudiante.nombre = 20;
estudiante.edad = «»Juan»»;

 Clase Estudiante con tipos invertidos
 * Se desea corregir la definición, asignar los campos correctamente y mostrar los datos.
 */

/**
 * Autor: Milagros Pozzo
 */

public class Problema_540 {

    // Definimos correctamente la clase Estudiante
    static class Estudiante {
        String nombre;  // Debe ser String para el nombre
        int edad;       // Debe ser int para la edad

        // Constructor opcional para inicializar nombre y edad
        Estudiante(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }
    }

    public static void main(String[] args) {
        // Creamos un estudiante e inicializamos con datos correctos
        Estudiante estudiante = new Estudiante("Juan", 20);

        // Mostramos los datos por consola
        System.out.println("Nombre: " + estudiante.nombre);
        System.out.println("Edad: " + estudiante.edad + " años");

        // Si se desea cambiar los datos posteriormente:
        // estudiante.nombre = "María";
        // estudiante.edad = 25;
    }
}