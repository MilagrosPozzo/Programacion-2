package edu.cerp.checkin;

import edu.cerp.checkin.console.MainConsole;
import edu.cerp.checkin.logic.SesionService;
import edu.cerp.checkin.ui.CheckInGUI;

public class App {
    public static void main(String[] args) {
        boolean usarGui = false;  // Cambiar de true a false
        for (String a : args) if ("--gui".equalsIgnoreCase(a)) {
            usarGui = true;
        }
        
        SesionService service = new SesionService();
        service.cargarDatosDemo(); // Datos de prueba precargados

        if (usarGui) {
            CheckInGUI.show(service);   // Ejecuta la GUI
        } else {
            MainConsole.run(service);   // Ejecuta la consola
        }
    }
}