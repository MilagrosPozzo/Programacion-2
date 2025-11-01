package hola_mundo;
// DECLARACIÓN DEL PAQUETE: Indica que esta clase pertenece al paquete "hola_mundo"
// Los paquetes organizan las clases y evitan conflictos de nombres

/**
 * COMENTARIO JAVADOC: Los comentarios que empiezan con /** son especiales
 * Se usan para generar documentación automática del código
 * @author Milagros Pozzo - Indica quién escribió el código
 */
public class Hola_Mundo {
    // DECLARACIÓN DE LA CLASE: 
    // - "public" = la clase puede ser accedida desde otros paquetes
    // - "class" = palabra clave que define una clase
    // - "Hola_Mundo" = nombre de la clase (debe coincidir con el nombre del archivo)
    // - { = abre el bloque de código de la clase
    
    /**
     * COMENTARIO JAVADOC DEL MÉTODO MAIN
     * @param args = documenta que este método recibe un parámetro llamado "args"
     * "args" son los argumentos de línea de comandos que se pasan al programa
     */
    public static void main(String[] args) {
        // MÉTODO MAIN - PUNTO DE ENTRADA DEL PROGRAMA:
        // - "public" = puede ser llamado desde fuera de la clase
        // - "static" = pertenece a la clase, no a una instancia específica
        // - "void" = no devuelve ningún valor
        // - "main" = nombre especial que reconoce la JVM como punto de inicio
        // - "String[] args" = parámetro que recibe argumentos de línea de comandos
        // - { = abre el bloque de código del método
        
        // TODO code application logic here
        // COMENTARIO TODO: Recordatorio generado por NetBeans para agregar lógica
        
        System.out.println("Hola Mundo Java");
        // INSTRUCCIÓN DE SALIDA:
        // - "System" = clase del sistema de Java
        // - "out" = objeto de salida estándar (consola)
        // - "println" = método que imprime texto y agrega una nueva línea
        // - "Hola Mundo Java" = el texto literal que se imprimirá
        // - ; = termina la instrucción (obligatorio en Java)
        
    } // Cierra el bloque del método main
} // Cierra el bloque de la clase Hola_Mundo