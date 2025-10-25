/*
 * PROBLEMA 377 – Función con enum Colores
 *
 * Descripción:
 * Se pide crear una función que reciba un valor de un enum llamado "Colores"
 * y devuelva el nombre del color como texto.
 */

// Aquí empieza nuestra clase principal
public class Problema_377 {
    
    // Aquí definimos un enum, que es como una lista especial de opciones fijas
    // Un enum sirve para definir valores que no van a cambiar
    // En este caso, los colores disponibles son solo estos cuatro
    enum Colores {
        ROJO, VERDE, AZUL, AMARILLO
    }
    
    // Esta es una función que recibe un color del enum y devuelve texto
    // "public" significa que se puede usar desde cualquier parte
    // "static" significa que no necesitas crear un objeto para usarla
    // "String" es lo que devuelve (texto)
    // "obtenerNombreColor" es el nombre de la función
    // "(Colores color)" es lo que recibe como entrada
    public static String obtenerNombreColor(Colores color) {
        
        // switch es como una serie de preguntas: "¿es este color?"
        // Revisa el valor de "color" y ejecuta el código del caso que coincida
        switch (color) {
            
            // Si el color es ROJO
            case ROJO:
                // Devuelve el texto "Rojo" y termina la función
                return "Rojo";
            
            // Si el color es VERDE
            case VERDE:
                // Devuelve el texto "Verde" y termina la función
                return "Verde";
            
            // Si el color es AZUL
            case AZUL:
                // Devuelve el texto "Azul" y termina la función
                return "Azul";
            
            // Si el color es AMARILLO
            case AMARILLO:
                // Devuelve el texto "Amarillo" y termina la función
                return "Amarillo";
            
            // default es el caso por si acaso, si no coincide con ninguno anterior
            // En este caso nunca debería llegar aquí porque solo hay 4 colores posibles
            default:
                return "Color desconocido";
        }
    }
    
    // Método principal, aquí comienza a ejecutarse el programa
    public static void main(String[] args) {
        
        // Creamos una variable que guarda uno de los colores del enum
        // Usamos Colores.VERDE para elegir el color verde
        Colores miColor = Colores.VERDE;
        
        // Llamamos a la función obtenerNombreColor y le pasamos el color
        // La función nos devuelve un texto que guardamos en la variable "nombre"
        String nombre = obtenerNombreColor(miColor);
        
        // Mostramos el resultado en la consola
        System.out.println("El color seleccionado es: " + nombre);
    }
}