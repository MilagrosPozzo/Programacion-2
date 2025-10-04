// Paquete correcto: debe coincidir con la carpeta donde está este archivo
package edu.cerp.checkin.ui;

import edu.cerp.checkin.logic.SesionService;
import edu.cerp.checkin.model.Inscripcion;

import javax.swing.*;   // Librería para ventanas, botones, etc.
import java.awt.*;      // Para layouts (cómo se acomodan los componentes)
import java.util.List;  // Para trabajar con listas de inscripciones

/**
 * Ventana mínima de Check-in Aula
 * Extiende de JFrame (una ventana básica de Swing).
 */
public class CheckInGUI extends JFrame {
    private final SesionService service;          // Usamos el mismo service que en consola
    private final DefaultListModel<String> modeloLista; // Modelo para mostrar inscripciones en la GUI

    // Campos de entrada de datos
    private JTextField txtNombre;
    private JTextField txtDocumento;
    private JComboBox<String> cbCurso;

    // Constructor: arma la ventana
    public CheckInGUI(SesionService service) {
        super("Check-in Aula (GUI)"); // Título de la ventana
        this.service = service;

        // Crear componentes
        txtNombre = new JTextField(15);
        txtDocumento = new JTextField(10);
        cbCurso = new JComboBox<>(new String[]{"Prog 1", "Prog 2", "Base de Datos"});
        JButton btnRegistrar = new JButton("Registrar ✔");
        modeloLista = new DefaultListModel<>();
        JList<String> lista = new JList<>(modeloLista);

        // Panel del formulario (arriba)
        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));
        form.add(new JLabel("Nombre:"));    form.add(txtNombre);
        form.add(new JLabel("Documento:")); form.add(txtDocumento);
        form.add(new JLabel("Curso:"));     form.add(cbCurso);
        form.add(new JLabel(""));           form.add(btnRegistrar);

        // Layout de la ventana
        setLayout(new BorderLayout(10, 10));
        add(form, BorderLayout.NORTH);
        add(new JScrollPane(lista), BorderLayout.CENTER);

        // Acción del botón
        btnRegistrar.addActionListener(e -> {
            String n = txtNombre.getText();
            String d = txtDocumento.getText();
            String c = (String) cbCurso.getSelectedItem();
            service.registrar(n, d, c); // Reutilizamos SesionService
            actualizarLista();          // Refrescamos la lista
            txtNombre.setText("");
            txtDocumento.setText("");
        });

        // Llenamos lista inicial
        actualizarLista();

        // Configuración de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null); // Centrar
    }

    // Refrescar la lista con inscripciones actuales
private void actualizarLista() {
    modeloLista.clear();
    modeloLista.addElement("═══════════════════════════════════════");
    modeloLista.addElement("  INSCRIPCIONES REGISTRADAS");
    modeloLista.addElement("═══════════════════════════════════════");
    
    List<Inscripcion> inscripciones = service.listar();
    for (Inscripcion i : inscripciones) {
        // Formato limpio: solo HH:mm:ss (sin nanosegundos)
        String hora = String.format("%02d:%02d:%02d",
            i.getFechaHora().getHour(),
            i.getFechaHora().getMinute(),
            i.getFechaHora().getSecond()
        );
        
        modeloLista.addElement(String.format("%-20s | %s | %-15s | %s",
            i.getNombre(), 
            i.getDocumento(), 
            i.getCurso(),
            hora
        ));
    }
    
    modeloLista.addElement("───────────────────────────────────────");
    modeloLista.addElement("Total: " + inscripciones.size() + " estudiantes");
}

    // Método estático que usa App.java para abrir la GUI
    public static void show(SesionService service) {
        SwingUtilities.invokeLater(() -> new CheckInGUI(service).setVisible(true));
    }
}