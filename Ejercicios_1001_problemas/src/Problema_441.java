public class Main {
    public static void main(String[] args) {
        // Creamos un arreglo de enteros con 5 elementos.
        int[] numeros = {1, 2, 3, 4, 5};

        // Usamos un ciclo for para recorrer el arreglo.
        // Usamos "numeros.length" para evitar acceder a índices inválidos.
        // Si usáramos "i < 10", se intentaría acceder a posiciones que no existen, causando un error.
        for (int i = 0; i < numeros.length; i++) {
            // Imprimimos cada elemento seguido de un espacio
            System.out.print(numeros[i] + " ");
        }
    }
}
