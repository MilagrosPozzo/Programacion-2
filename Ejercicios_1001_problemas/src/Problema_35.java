/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
public class Problema_35 {
    
}
// Ejemplo concreto: si el pseudocódigo indica "sumar solo los números pares de un arreglo",
// el código en Java debería incluir una condición como:

for (int num : arreglo) {
    if (num % 2 == 0) {
        suma += num;
    }
}

// Si falta esa condición, o se usa incorrectamente, el algoritmo sumará también los impares,
// generando un error lógico.