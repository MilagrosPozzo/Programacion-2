// Paquete correcto: debe coincidir con la carpeta donde está este archivo
package edu.cerp.checkin.ui;

import edu.cerp.checkin.logic.SesionService;
import edu.cerp.checkin.model.Inscripcion;

import javax.swing.*;   // Librería para ventanas, botones, etc.
import javax.swing.table.DefaultTableModel;
import java.awt.*;      // Para layouts (cómo se acomodan los componentes)
import java.util.List;  // Para trabajar con listas de inscripciones

/**
 * Ventana mínima de Check-in Aula
 * Extiende de JFrame (una ventana básica de Swing).
 */
public class CheckInGUI extends JFrame {
    private final SesionService service;          // Usamos el mismo service que en consola
    private final DefaultTableModel modeloTabla;  // Modelo para JTable
    private final JTextArea txtResumen;           // Área para mostrar resumen por curso

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
        
        // Tabla con columnas
        String[] columnas = {"Nombre", "Documento", "Curso", "Hora"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tabla);
        
         // Resumen (abajo de la tabla)
        txtResumen = new JTextArea(5, 30);
        txtResumen.setEditable(false);
        JScrollPane scrollResumen = new JScrollPane(txtResumen);

        // Panel del formulario (arriba)
        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));
        form.add(new JLabel("Nombre:"));    form.add(txtNombre);
        form.add(new JLabel("Documento:")); form.add(txtDocumento);
        form.add(new JLabel("Curso:"));     form.add(cbCurso);
        form.add(new JLabel(""));           form.add(btnRegistrar);

        // Layout de la ventana
        setLayout(new BorderLayout(10, 10));
        add(form, BorderLayout.NORTH);
        add(scrollTabla, BorderLayout.CENTER); // usamos la tabla aquí
        add(scrollResumen, BorderLayout.SOUTH);

         // ==== Acción del botón Registrar ====
        btnRegistrar.addActionListener(e -> {
            String n = txtNombre.getText().trim();
            String d = txtDocumento.getText().trim();
            String c = (String) cbCurso.getSelectedItem();

            // Validación simple: no aceptar nombre vacío
            if (n.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.", 
                                              "Error de validación", JOptionPane.WARNING_MESSAGE);
                return;
            }

            service.registrar(n, d, c);   // Usar lógica central
            actualizarTabla();            // Refrescar la tabla
            actualizarResumen();          // Refrescar el resumen

            // Limpiar campos
            txtNombre.setText("");
            txtDocumento.setText("");
        });

        // ==== Inicializar ====
        actualizarTabla();
        actualizarResumen();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null); // Centrar
    }

    // Refrescar la tabla con todas las inscripciones
    private void actualizarTabla() {
        modeloTabla.setRowCount(0); // limpiar
        List<Inscripcion> inscripciones = service.listar();
        for (Inscripcion i : inscripciones) {
            modeloTabla.addRow(new Object[]{
                    i.getNombre(),
                    i.getDocumento(),
                    i.getCurso(),
                    i.getFechaHora().toLocalTime().withNano(0) // solo hora
            });
        }
    }

    // Refrescar resumen por curso
    private void actualizarResumen() {
        txtResumen.setText(service.resumen());
    }

    // Método estático para abrir la GUI
    public static void show(SesionService service) {
        SwingUtilities.invokeLater(() -> new CheckInGUI(service).setVisible(true));
    }
}