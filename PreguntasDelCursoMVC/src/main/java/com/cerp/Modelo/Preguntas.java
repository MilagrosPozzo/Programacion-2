package com.cerp.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Clase que maneja una lista de preguntas.
 * Implementa la interfaz List para proporcionar funcionalidades de lista.
 */
public class Preguntas implements Serializable, List<Pregunta> {
    private List<Pregunta> listaPreguntas;

    /**
     * Constructor que inicializa la lista de preguntas y agrega 5 preguntas por defecto.
     * Se modificó para que las preguntas sigan el formato correcto del constructor de Pregunta.
     */
    public Preguntas() {
        this.listaPreguntas = new ArrayList<>();

        // Agregar 5 preguntas con el formato correcto
        listaPreguntas.add(new Pregunta(1, "¿Qué es Java?", "Lenguaje de programación", new String[]{"Lenguaje de programación", "Sistema operativo", "Base de datos", "Compilador", "Framework"}));
        listaPreguntas.add(new Pregunta(2, "¿Qué es la Programación Orientada a Objetos?", "Un paradigma de programación", new String[]{"Un lenguaje de programación", "Un paradigma de programación", "Una base de datos", "Una metodología de diseño", "Un conjunto de reglas"}));
        listaPreguntas.add(new Pregunta(3, "¿Qué es una clase en Java?", "Es un modelo o plantilla para crear objetos", new String[]{"Es un objeto", "Es una variable", "Es un modelo o plantilla para crear objetos", "Un método especial", "Es un tipo de dato"}));
        listaPreguntas.add(new Pregunta(4, "¿Qué es un objeto en Java?", "Es una instancia de una clase", new String[]{"Es una función", "Es una instancia de una clase", "Es un tipo de variable", "Es un archivo", "Es un procedimiento"}));
        listaPreguntas.add(new Pregunta(5, "¿Qué es la herencia en Java?", "Un mecanismo para reutilizar código", new String[]{"Una forma de copiar código", "Un mecanismo para reutilizar código", "Una estructura de datos", "Un concepto de base de datos", "Un patrón de diseño"}));
    }

    // Métodos Getter y Setter
    public List<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }

    public void setListaPreguntas(List<Pregunta> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    // Métodos para manipular la lista de preguntas
    public void addPregunta(Pregunta pregunta) {
        listaPreguntas.add(pregunta);
    }

    public void removePregunta(int index) {
        listaPreguntas.remove(index);
    }

    public void removePregunta(Pregunta pregunta) {
        listaPreguntas.remove(pregunta);
    }

    public void updatePregunta(int index, Pregunta pregunta) {
        listaPreguntas.set(index, pregunta);
    }

    public Pregunta getPregunta(int index) {
        return listaPreguntas.get(index);
    }

    public int getCantPreguntas() {
        return listaPreguntas.size();
    }

    // Métodos de la interfaz List implementados correctamente
    @Override
    public int size() {
        return listaPreguntas.size();
    }

    @Override
    public boolean isEmpty() {
        return listaPreguntas.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return listaPreguntas.contains(o);
    }

    @Override
    public Iterator<Pregunta> iterator() {
        return listaPreguntas.iterator();
    }

    @Override
    public Object[] toArray() {
        return listaPreguntas.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return listaPreguntas.toArray(a);
    }

    @Override
    public boolean add(Pregunta e) {
        return listaPreguntas.add(e);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return listaPreguntas.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Pregunta> c) {
        return listaPreguntas.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends Pregunta> c) {
        return listaPreguntas.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return listaPreguntas.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return listaPreguntas.retainAll(c);
    }

    @Override
    public void clear() {
        listaPreguntas.clear();
    }

    @Override
    public Pregunta get(int index) {
        return listaPreguntas.get(index);
    }

    @Override
    public Pregunta set(int index, Pregunta element) {
        return listaPreguntas.set(index, element);
    }

    @Override
    public void add(int index, Pregunta element) {
        listaPreguntas.add(index, element);
    }

    @Override
    public Pregunta remove(int index) {
        return listaPreguntas.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return listaPreguntas.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return listaPreguntas.lastIndexOf(o);
    }

    @Override
    public ListIterator<Pregunta> listIterator() {
        return listaPreguntas.listIterator();
    }

    @Override
    public ListIterator<Pregunta> listIterator(int index) {
        return listaPreguntas.listIterator(index);
    }

    @Override
    public List<Pregunta> subList(int fromIndex, int toIndex) {
        return listaPreguntas.subList(fromIndex, toIndex);
    }

    @Override
    public boolean remove(Object o) {
        return listaPreguntas.remove(o);
    }
}
