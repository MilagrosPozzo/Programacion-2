
// Definimos el paquete donde se encuentra nuestra clase
// Esto ayuda a organizar el código y evitar conflictos de nombres
package ejercicio3;

// Importamos la clase Random del paquete java.util 
// Esta clase nos permite generar números pseudoaleatorios
import java.util.Random;

// Declaramos la clase pública que contiene nuestro programa
public class Ejercicio3 {
    
    // Método principal que será ejecutado cuando se lance el programa
    // Es el punto de entrada de cualquier aplicación Java
    public static void main(String[] args) {
        
        // Creamos una instancia de la clase Random para generar números aleatorios
        // Esta instancia nos dará acceso a métodos como nextInt()
        Random rand = new Random();
        
        // Inicializamos una variable acumuladora para sumar solo los números impares
        // Comenzamos en 0 porque aún no hemos encontrado ningún número impar
        int sumaImpares = 0;
        
        // Iniciamos un bucle while que continuará ejecutándose mientras la suma sea ≤ 25
        // Este tipo de bucle es ideal cuando no sabemos exactamente cuántas iteraciones necesitamos
        // La condición se evalúa ANTES de cada iteración
        while (sumaImpares <= 25) {
            
            // Generamos un número aleatorio entre 0 y 10 (ambos inclusive)
            // nextInt(11) devuelve valores de 0 a 10, por eso usamos 11 como parámetro
            int num = rand.nextInt(11);
            
            // Verificamos si el número generado es par usando el operador módulo (%)
            // Si num % 2 == 0, significa que al dividir num entre 2 el resto es 0 (es par)
            // Si num % 2 == 1, significa que al dividir num entre 2 el resto es 1 (es impar)
            if (num % 2 == 0) {
                
                // Si el número es par, solamente lo mostramos en pantalla
                // Los números pares NO se suman a nuestro acumulador
                System.out.println(num + " es par");
                
            } else {
                
                // Si el número es impar, hacemos dos acciones:
                // 1. Lo mostramos en pantalla para informar al usuario
                System.out.println(num + " es impar");
                
                // 2. Lo añadimos a nuestro acumulador de números impares
                // Esto hace que la suma vaya creciendo y eventualmente supere 25
                sumaImpares += num; // Equivalente a: sumaImpares = sumaImpares + num
            }
        }
        // El bucle while termina automáticamente cuando sumaImpares > 25
        
        // Una vez que salimos del bucle (porque sumaImpares ya superó 25),
        // mostramos la suma final de todos los números impares que se generaron
        System.out.println("Suma final de impares = " + sumaImpares);
    }
}