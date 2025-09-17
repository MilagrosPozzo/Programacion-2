/*
 Desafío 15 
 Simula una carrera de Vehiculo (subclases Auto y Moto) en la que cada vehículo
 avanza una distancia aleatoria en cada turno. Usamos un arreglo polimórfico
 para los competidores y determinamos el ganador al final de 5 rondas.

 Explicación y razonamiento desde la línea 1 (nivel inicial, lenguaje sencillo):
 - La idea es representar lo común a todos los vehículos (nombre y distancia recorrida)
   en una clase abstracta llamada Vehiculo. Esa clase tendrá un método abstracto
   avanzar() que cada tipo de vehículo implementará según su "estilo" de avance.
 - Usamos un arreglo de tipo Vehiculo[] para guardar los competidores: esto es
   polimorfismo porque el arreglo tiene el tipo de la clase base (Vehiculo) pero
   los objetos reales son Auto o Moto. Así podemos tratar a todos igual en el bucle.
 - En cada una de las 5 rondas, recorremos todos los competidores, llamamos a
   su método avanzar() y sumamos la distancia que avanzaron a su total.
 - Al final de las 5 rondas, comparamos las distancias totales para encontrar
   al ganador; si hay empate, mostramos todos los que quedaron igualados.
 - Para mantener el nivel inicial, las distancias aleatorias son sencillas y
   usamos Random para generarlas. Los mensajes impresos son claros para ver
   lo que sucede en cada ronda.
*/

import java.util.Random; // Importamos Random para generar números aleatorios

// Clase abstracta Vehiculo: contiene lo común (nombre y distancia acumulada)
// y obliga a las subclases a definir cómo avanzan (método abstracto avanzar()).
abstract class Vehiculo {
    protected String nombre;           // Nombre del vehículo (p. ej. "Auto Rojo")
    protected int distanciaRecorrida;  // Distancia total recorrida por el vehículo

    // Usamos un Random estático compartido para evitar crear muchos Randoms.
    // Esto es práctico y fácil de entender para nivel inicial.
    protected static Random random = new Random();

    // Constructor: inicializa el nombre y pone la distancia en 0 al crear el vehículo.
    public Vehiculo(String nombre) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0; // empezamos la carrera con 0 metros recorridos
    }

    // Método que las subclases deben implementar: hacer que el vehículo avance.
    // Debe devolver cuántos metros avanzó en ese turno (para mostrarlo).
    public abstract int avanzar();

    // Método para agregar la distancia al total (lo llamamos desde avanzar())
    protected void agregarDistancia(int metros) {
        this.distanciaRecorrida += metros;
    }

    // Getter para obtener la distancia total recorrida
    public int getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    // Getter para el nombre del vehículo
    public String getNombre() {
        return nombre;
    }

    // Método para mostrar el estado actual del vehículo (útil durante la simulación)
    public void mostrarEstado() {
        System.out.println(nombre + " -> distancia total: " + distanciaRecorrida + " m");
    }
}

// Clase Auto: define cómo avanza un auto en cada turno.
// Aquí decidimos que un Auto avanzará entre 5 y 15 metros por turno (rango simple).
class Auto extends Vehiculo {
    public Auto(String nombre) {
        super(nombre); // reutilizamos el constructor de la clase base para inicializar el nombre
    }

    @Override
    public int avanzar() {
        // Generamos una distancia aleatoria entre 5 y 15 (inclusive).
        // random.nextInt(11) devuelve 0..10, por eso sumamos 5 para obtener 5..15.
        int metros = 5 + random.nextInt(11);
        agregarDistancia(metros); // actualizamos la distancia total del vehículo
        return metros;            // devolvemos lo avanzado este turno para mostrarlo
    }
}

// Clase Moto: define cómo avanza una moto en cada turno.
// Decidimos que una Moto avanzará entre 3 y 12 metros por turno (rango simple).
class Moto extends Vehiculo {
    public Moto(String nombre) {
        super(nombre);
    }

    @Override
    public int avanzar() {
        // Generamos una distancia aleatoria entre 3 y 12 (inclusive).
        // random.nextInt(10) devuelve 0..9, sumamos 3 para obtener 3..12.
        int metros = 3 + random.nextInt(10);
        agregarDistancia(metros);
        return metros;
    }
}

// Clase principal con el método main: aquí se arma la carrera y se ejecutan las 5 rondas.
public class Desafío15 {
    public static void main(String[] args) {
        // Creamos un arreglo polimórfico de Vehiculo.
        // Aunque el arreglo es de tipo Vehiculo, los objetos reales pueden ser Auto o Moto.
        // Esto permite tratar a todos los competidores de forma uniforme.
        Vehiculo[] competidores = new Vehiculo[] {
            new Auto("Auto Rojo"),
            new Moto("Moto Azul"),
            new Auto("Auto Verde")
        };

        // Cantidad de rondas definida por el enunciado: 5 rondas
        final int RONDAS = 5;

        // Mostramos una cabecera simple para la simulación
        System.out.println("Inicio de la carrera - " + RONDAS + " rondas\n");

        // Bucle principal: recorremos las rondas
        for (int ronda = 1; ronda <= RONDAS; ronda++) {
            System.out.println("Ronda " + ronda + ":");
            // Para cada competidor, llamamos a su método avanzar() y mostramos lo que avanzó
            for (Vehiculo v : competidores) {
                int avanzados = v.avanzar(); // llamada polimórfica: a runtime se ejecuta Auto.avanzar o Moto.avanzar
                // Mostramos cuánto avanzó en esta ronda y su total acumulado
                System.out.println("  " + v.getNombre() + " avanzó " + avanzados + " m (total: " + v.getDistanciaRecorrida() + " m)");
            }
            System.out.println(); // línea en blanco para separar rondas y mejorar lectura
        }

        // Al terminar las rondas, determinamos qué vehículo recorrió más metros
        int maximaDistancia = -1;
        for (Vehiculo v : competidores) {
            if (v.getDistanciaRecorrida() > maximaDistancia) {
                maximaDistancia = v.getDistanciaRecorrida();
            }
        }

        // Recolectamos todos los vehículos que igualaron la máxima distancia (manejo de empates)
        StringBuilder ganadores = new StringBuilder();
        int contadorGanadores = 0;
        for (Vehiculo v : competidores) {
            if (v.getDistanciaRecorrida() == maximaDistancia) {
                if (contadorGanadores > 0) {
                    ganadores.append(", ");
                }
                ganadores.append(v.getNombre());
                contadorGanadores++;
            }
        }

        // Mostramos resultado final
        System.out.println("Resultado final:");
        for (Vehiculo v : competidores) {
            v.mostrarEstado(); // imprime nombre y distancia total
        }

        // Mensaje de ganador o empate
        if (contadorGanadores == 1) {
            System.out.println("\n¡El ganador es: " + ganadores.toString() + " con " + maximaDistancia + " m!");
        } else {
            System.out.println("\nEmpate entre: " + ganadores.toString() + " con " + maximaDistancia + " m cada uno.");
        }
    }
}