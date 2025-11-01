/*
* Desafío 23 – Promedio con Iterator
* Usar un ArrayList<Double> con precios y recorrerlo con un Iterator para calcular el promedio.
*/
import java.util.ArrayList; // ArrayList: estructura de datos dinámica, implementa List interface
import java.util.Iterator;  // Iterator: interfaz para navegación secuencial en colecciones

public class Desafio23_Promedio_con_Iterator {
    public static void main(String[] args) {
        
        /* Paso 1: Inicialización del ArrayList
         * ArrayList<Double>: lista que almacena objetos Double (wrapper de primitive double)
         * Inicializada vacía, pero con capacidad inicial interna de 10 elementos */
        ArrayList<Double> precios = new ArrayList<>();
        
        /* Paso 2: Población de datos usando add()
         * add(): inserta elemento al final de la lista
         * Auto-boxing: primitive double se convierte automáticamente a Double object */
        precios.add(10.5); // Posición 0: [10.5]
        precios.add(20.0); // Posición 1: [10.5, 20.0]  
        precios.add(15.3); // Posición 2: [10.5, 20.0, 15.3]
        
        /* Paso 3: Obtención del Iterator
         * iterator(): método de Collection interface que retorna Iterator<Double>
         * Iterator inicialmente apunta "antes" del primer elemento
         * Estado interno del iterator: posición = -1, siguiente elemento = 10.5 */
        Iterator<Double> it = precios.iterator();
        
        /* Paso 4: Variables de acumulación
         * suma: acumula valores para el cálculo final
         * contador: cuenta elementos procesados (alternativa a precios.size()) */
        double suma = 0;    // primitive double para cálculos matemáticos
        int contador = 0;   // contador manual para demostrar control explícito
        
        /* Paso 5: Iteración usando patrón clásico hasNext() + next()
         * Este es el patrón estándar para recorrer cualquier Collection en Java */
        while (it.hasNext()) { // hasNext(): ¿existe un siguiente elemento?
            
            /* next(): hace DOS operaciones cruciales:
             * 1. Retorna el elemento actual (Double object)
             * 2. Avanza el iterator al siguiente elemento
             * Auto-unboxing: Double object → primitive double automáticamente */
            suma += it.next();
            contador++; // Incrementa contador de elementos procesados
        }
        // Después del bucle: suma = 45.8, contador = 3
        
        /* Paso 6: Cálculo final del promedio
         * División: suma total entre cantidad de elementos
         * Resultado: 45.8 / 3 = 15.266666... */
        double promedio = suma / contador;
        
        /* Paso 7: Salida del resultado
         * Concatenación simple: String + double (Java convierte double a String automáticamente)
         * No hay formato específico, muestra todos los decimales disponibles */
        System.out.println("Promedio: " + promedio);
        }
     }