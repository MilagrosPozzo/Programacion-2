package ejercicio1a;
// Importamos la clase Random del paquete java.util para generar números aleatorios
import java.util.Random;

// Declaramos la clase principal del programa
public class Ejercicio1a {
    
    // Método principal donde inicia la ejecución del programa
    public static void main(String[] args) {
        
        // Creamos una instancia de Random para poder generar números enteros aleatorios
        // Esta clase nos proporciona métodos para generar diferentes tipos de números al azar
        Random rand = new Random();
        
        // Generamos el primer número aleatorio entre 0 y 99 (inclusive 0, exclusive 100)
        // nextInt(100) genera números desde 0 hasta 99
        int a = rand.nextInt(100);
        
        // Generamos el segundo número aleatorio también entre 0 y 99
        // Este será nuestro divisor, por lo que necesitaremos validar que no sea 0
        int b = rand.nextInt(100);
        
        // Mostramos en consola el valor del primer número generado
        System.out.println("a = " + a);
        
        // Mostramos en consola el valor del segundo número generado
        System.out.println("b = " + b);
        
        // Verificamos que el divisor (b) no sea 0 antes de realizar la división
        // Esta validación es crucial porque la división por cero genera una excepción
        if (b != 0) {
            
            // Realizamos la división entera entre a y b
            // El operador / en Java con enteros devuelve solo la parte entera del resultado
            int cociente = a / b;
            
            // Calculamos el resto de la división usando el operador módulo (%)
            // Este operador nos da lo que "sobra" después de la división entera
            int resto = a % b;
            
            // Mostramos el resultado de la división entera
            System.out.println("Cociente = " + cociente);
            
            // Mostramos el resto de la división
            System.out.println("Resto = " + resto);
            
        } else {
            // Si b es 0, mostramos un mensaje de error informativo
            // Evitamos que el programa se cierre abruptamente por una ArithmeticException
            System.out.println("Error: no se puede dividir entre cero ❗");
        }
    }
}