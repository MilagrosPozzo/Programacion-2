/*
* Desafío 24 – Agenda telefónica
* Crear un HashMap<String,String> para representar una agenda donde la clave es el nombre y el valor el teléfono. 
* Mostrar todos los contactos.
*/
import java.util.HashMap;

public class Desafio24_Agenda_telefónica {
    public static void main(String[] args) {
        // Creamos la agenda
        HashMap<String, String> agenda = new HashMap<>();
        agenda.put("Ana", "091111111");
        agenda.put("Luis", "092222222");
        agenda.put("Pedro", "093333333");

        // Mostramos los contactos
        System.out.println("Agenda telefónica:");
        for (String nombre : agenda.keySet()) {
            System.out.println(nombre + " -> " + agenda.get(nombre));
        }
    }
}
