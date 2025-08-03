/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
/**
 *
 * @author Milagros Pozzo
 */
package plataformaeducativapoo.modelo; 
// Indica en qué paquete se encuentra esta clase (estructura del proyecto).

import java.util.List; 
// Importamos List porque vamos a usar una lista (arreglo dinámico) para guardar las opciones de respuesta.

public class Pregunta { 
    // Declaramos una clase pública llamada Pregunta.

    // Atributos o variables que describen a la pregunta:
    private String enunciado; // Guarda el texto de la pregunta.
    private List<String> opciones; // Lista de posibles respuestas (opciones).
    private int indiceCorrecto; // Posición correcta dentro de la lista de opciones (por ejemplo, 0 para la primera opción).

    // Constructor: método especial que se ejecuta cuando se crea una nueva pregunta.
    public Pregunta(String enunciado, List<String> opciones, int indiceCorrecto) {
        // El constructor recibe el texto de la pregunta, la lista de opciones y cuál es la respuesta correcta.
        this.enunciado = enunciado; 
        this.opciones = opciones; 
        this.indiceCorrecto = indiceCorrecto;
    }

    // Método que verifica si la opción elegida por el usuario es la correcta
    public boolean esCorrecta(int respuestaUsuario) {
        // Compara la respuesta dada por el usuario con la opción correcta
        return respuestaUsuario == indiceCorrecto; 
        // Devuelve true si acertó, false si se equivocó
    }

    // Métodos para acceder a los valores privados (getters):
    
    public String getEnunciado() {
        return enunciado;
    }

    public List<String> getOpciones() {
        return opciones;
    }

    public int getIndiceCorrecto() {
        return indiceCorrecto;
    }

    // Métodos para modificar los valores (setters), si en algún momento se necesita cambiar los datos:
    
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public void setOpciones(List<String> opciones) {
        this.opciones = opciones;
    }

    public void setIndiceCorrecto(int indiceCorrecto) {
        this.indiceCorrecto = indiceCorrecto;
    }
}