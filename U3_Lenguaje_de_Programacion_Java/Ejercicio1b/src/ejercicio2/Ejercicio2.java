
// Definimos el paquete donde se encuentra nuestra clase
package ejercicio2;

// Importamos la clase Random del paquete java.util para generar números pseudoaleatorios
import java.util.Random;

// Declaramos la clase pública Ejercicio1b que contiene nuestro programa
public class Ejercicio2 {
    
    // Método principal que será el punto de entrada de nuestro programa
    // Es donde la JVM (Java Virtual Machine) comenzará a ejecutar nuestro código
    public static void main(String[] args) {
        
        // Creamos una instancia de la clase Random para poder generar números aleatorios
        // Esta clase implementa un generador de números pseudoaleatorios
        Random rand = new Random();
        
        // Generamos un número aleatorio entre 1 y 50 (ambos inclusive)
        // rand.nextInt(50) devuelve un valor entre 0 y 49, por eso sumamos +1
        // para obtener el rango deseado de 1 a 50
        int m = rand.nextInt(50) + 1;
        
        // Mostramos en consola el número que fue generado aleatoriamente
        // Esto nos permite verificar cuál será el límite superior de nuestra suma
        System.out.println("Número generado: " + m);
        
        // Inicializamos una variable acumuladora en 0
        // Esta variable almacenará la suma progresiva de todos los números
        int suma = 0;
        
        // Iniciamos un bucle for que iterará desde 1 hasta m (inclusive)
        // La estructura es: for(inicialización; condición; incremento)
        // - i = 1: comenzamos el contador en 1
        // - i <= m: continuamos mientras i sea menor o igual a m
        // - i++: incrementamos i en 1 en cada iteración
        for (int i = 1; i <= m; i++) {
            
            // En cada iteración, sumamos el valor actual de i a nuestra variable suma
            // suma += i es una forma abreviada de escribir: suma = suma + i
            // Ejemplo: si m=5, haremos suma = 0+1+2+3+4+5 = 15
            suma += i;
        }
        
        // Una vez terminado el bucle, mostramos el resultado final
        // Este será la suma de todos los números enteros desde 1 hasta m
        // Matemáticamente, esto equivale a la fórmula: m * (m + 1) / 2
        System.out.println("Suma de enteros entre 1 y " + m + " = " + suma);
    }
}
