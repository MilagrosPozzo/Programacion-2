/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Milagros Pozzo
 */
// EJERCICIO 11 - Identificador: Ej11
// PlataformaStreaming abstracta con Netflix y YouTube; reproducen 3 contenidos distintos.
public class Ejercicio11 { // clase pública Ejercicio11
    public static void main(String[] args) { // método main para ejecutar el ejemplo
        PlataformaStreaming[] plataformas = new PlataformaStreaming[] { // arreglo polimórfico
            new Netflix(), // Netflix
            new YouTube() // YouTube
        }; // fin arreglo

        // lista de contenidos de ejemplo (podemos adaptar por plataforma si queremos)
        String[] contenidosNetflix = {"Película A", "Serie B - Episodio 1", "Documental C"}; // 3 contenidos
        String[] contenidosYouTube = {"Vlog 1", "Tutorial Java", "Live Stream"}; // 3 contenidos

        // cada plataforma reproduce sus 3 contenidos
        for (PlataformaStreaming p : plataformas) { // por cada plataforma
            System.out.println("==> Plataforma: " + p.getClass().getSimpleName()); // mostramos nombre
            if (p instanceof Netflix) { // si es Netflix
                for (String c : contenidosNetflix) { // reproducimos contenidosNetflix
                    p.reproducirContenido(c); // llamada polimórfica
                } // fin for
            } else if (p instanceof YouTube) { // si es YouTube
                for (String c : contenidosYouTube) { // reproducimos contenidosYouTube
                    p.reproducirContenido(c); // llamada polimórfica
                } // fin for
            } // fin condicional
            System.out.println(); // línea en blanco para separar plataformas
        } // fin for plataforma
    } // fin main
} // fin clase Ejercicio11

abstract class PlataformaStreaming { // definición de la plataforma base
    public abstract void reproducirContenido(String contenido); // método abstracto
} // fin PlataformaStreaming

class Netflix extends PlataformaStreaming { // implementación de Netflix
    @Override
    public void reproducirContenido(String contenido) { // comportamiento de Netflix
        // simula reproducir sin anuncios y con "calidad HD"
        System.out.println("Netflix reproduce: \"" + contenido + "\" en HD, sin anuncios.");
    } // fin reproducirContenido
} // fin Netflix

class YouTube extends PlataformaStreaming { // implementación de YouTube
    @Override
    public void reproducirContenido(String contenido) { // comportamiento de YouTube
        // simula reproducción con posibilidad de anuncios y recomendación
        System.out.println("YouTube reproduce: \"" + contenido + "\" (puede incluir anuncios).");
    } // fin reproducirContenido
} // fin YouTube
