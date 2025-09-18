// Desafío 3
// Implementa un programa en Java que genere una secuencia de enteros al azar entre 0 y 10.
// El programa debe mostrar cada entero en pantalla junto con un mensaje que diga si es par o no lo es.
// Además, el programa debe ir sumando todos los valores impares que se vayan generando.
// El procesamiento debe detenerse en el momento en que la suma supere el valor 25.
// Al finalizar, el programa debe mostrar en pantalla la suma calculada.

import java.util.concurrent.ThreadLocalRandom; // Importamos ThreadLocalRandom, generador de números aleatorios moderno en Java

public class Desafío3 { // Declaramos la clase principal
    public static void main(String[] args) { // Método main: punto de entrada de la aplicación
        final int MIN = 0;                  // Valor mínimo del rango de números aleatorios
        final int MAX = 10;                 // Valor máximo del rango de números aleatorios
        final int LIMITE = 25;              // Límite que, al ser superado por la suma de impares, detendrá el programa

        int sumaImpares = 0;                // Variable acumuladora para ir sumando los números impares generados

        // Usamos un bucle infinito, porque no sabemos cuántos números se generarán hasta superar 25
        while (true) {
            // Generamos un número aleatorio entre MIN y MAX (inclusive). Como nextInt usa [a, b), sumamos 1 a MAX
            int n = ThreadLocalRandom.current().nextInt(MIN, MAX + 1);

            // Verificamos si es par (resto de la división entre 2 igual a 0)
            boolean esPar = (n % 2 == 0);

            // Mostramos el número generado junto con el mensaje "par" o "impar"
            System.out.printf("Generado: %d -> %s%n", n, esPar ? "par" : "impar");

            // Si el número es impar, lo acumulamos
            if (!esPar) {
                sumaImpares += n; // Sumamos el impar

                // Luego verificamos si la suma superó el límite (25)
                if (sumaImpares > LIMITE) {
                    // Si ya lo superó, salimos del bucle inmediatamente
                    break;
                }
            }
        }

        // Al terminar el bucle, mostramos la suma final de los impares
        System.out.println("Suma de impares = " + sumaImpares);
    }
}