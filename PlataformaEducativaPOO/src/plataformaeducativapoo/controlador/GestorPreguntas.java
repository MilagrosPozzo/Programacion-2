/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Milagros Pozzo
 */
package plataformaeducativapoo.controlador; 
// Línea 1: Indica el paquete donde se encuentra esta clase.

import plataformaeducativapoo.modelo.Pregunta; 
// Línea 3: Importamos la clase Pregunta que creamos antes.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// Líneas 5-7: Importamos clases necesarias para trabajar con listas y mezclar elementos.

public class GestorPreguntas {
    // Línea 9: Comienzo de la clase. Será el "gestor" del banco de preguntas.

    private List<Pregunta> banco; 
    // Línea 11: Creamos un ArrayList llamado banco donde se guardarán todas las preguntas disponibles.

    public GestorPreguntas() {
        // Constructor vacío: se ejecuta al crear un nuevo objeto de esta clase
        banco = new ArrayList<>();
    }

    // Método para agregar una pregunta al banco
    public void agregarPregunta(Pregunta p) {
        banco.add(p);
        // Línea 19: Añade la pregunta al final de la lista banco.
    }

    // Método para eliminar una pregunta por su posición en la lista
    public void eliminarPregunta(int index) {
        if (index >= 0 && index < banco.size()) {
            banco.remove(index);
            // Línea 25: Elimina la pregunta en la posición indicada si es válida.
        }
    }

    // Método para obtener una cantidad de preguntas aleatorias
    public List<Pregunta> obtenerAleatorias(int cantidad) {
        Collections.shuffle(banco);
        // Línea 31: Mezcla el orden de las preguntas de forma aleatoria.

        // Devuelve una sublista desde el comienzo hasta el valor menor entre cantidad y el tamaño de la lista
        return banco.subList(0, Math.min(cantidad, banco.size()));
    }

    // Método adicional para obtener todas las preguntas (opcional)
    public List<Pregunta> obtenerTodas() {
        return banco;
    }
}