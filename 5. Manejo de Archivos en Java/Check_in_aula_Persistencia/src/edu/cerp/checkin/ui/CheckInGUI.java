// Paquete correcto: debe coincidir con la carpeta donde está este archivo
package edu.cerp.checkin.ui;

import edu.cerp.checkin.logic.SesionService;
import edu.cerp.checkin.model.Inscripcion;

import javax.swing.*;          // Librerías Swing para GUI
import javax.swing.table.DefaultTableModel;
import java.awt.*;            // Para layouts y colores
import java.util.List;        // Para recorrer listas de inscripciones

/**
 * Ventana principal de Check-in Aula (GUI)
 * Permite registrar inscripciones y visualizar un resumen por curso.
 */
public class CheckInGUI extends JFrame {

    // === Atributos principales ===
    private final SesionService service;          // Reutiliza la lógica central
    private final DefaultTableModel modeloTabla;  // Modelo para la JTable
    private final JTextArea txtResumen;           // Muestra el resumen por curso

    // Campos del formulario
    private JTextField txtNombre;
    private JTextField txtDocumento;
    private JComboBox<String> cbCurso;

    // === Constructor ===
    public CheckInGUI(SesionService service) {
        super("Check-in Aula (GUI)");
        this.service = service;

        // === CONFIGURACIÓN BÁSICA DE LA VENTANA ===
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(245, 248, 250)); // fondo claro
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 450);
        setLocationRelativeTo(null); // Centrar ventana

        // === CAMPOS DE ENTRADA ===
        txtNombre = new JTextField(15);
        txtDocumento = new JTextField(10);
        cbCurso = new JComboBox<>(new String[]{"Prog 1", "Prog 2", "Base de Datos"});
        JButton btnRegistrar = new JButton("Registrar ✔");

        // === TABLA DE INSCRIPCIONES ===
        String[] columnas = {"Nombre", "Documento", "Curso", "Hora"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modeloTabla);
        tabla.setFillsViewportHeight(true);
        tabla.setRowHeight(22);
        tabla.setGridColor(Color.LIGHT_GRAY);
        JScrollPane scrollTabla = new JScrollPane(tabla);

        // === ÁREA DE RESUMEN ===
        txtResumen = new JTextArea(5, 30);
        txtResumen.setEditable(false);
        txtResumen.setFont(new Font("Consolas", Font.PLAIN, 12));
        txtResumen.setBackground(new Color(250, 250, 250));
        txtResumen.setBorder(BorderFactory.createTitledBorder("Resumen por curso"));
        JScrollPane scrollResumen = new JScrollPane(txtResumen);

        // === PANEL DEL FORMULARIO ===
        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));
        // BorderLayout permite organizar componentes en 5 zonas (North, Center, South, East, West)
        form.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        form.add(new JLabel("Nombre:"));    form.add(txtNombre);
        form.add(new JLabel("Documento:")); form.add(txtDocumento);
        form.add(new JLabel("Curso:"));     form.add(cbCurso);
        form.add(new JLabel(""));           form.add(btnRegistrar);

        // === ORGANIZAR COMPONENTES ===
        add(form, BorderLayout.NORTH);
        add(scrollTabla, BorderLayout.CENTER);
        add(scrollResumen, BorderLayout.SOUTH);

        // === ACCIÓN DEL BOTÓN REGISTRAR ===
        btnRegistrar.addActionListener(e -> {
            String n = txtNombre.getText().trim();
            String d = txtDocumento.getText().trim();
            String c = (String) cbCurso.getSelectedItem();

          // Validación simple: nombre no vacío
         // TODO: Agregar validación para documento (formato, no duplicados)
            if (n.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                        "El nombre no puede estar vacío.", 
                        "Error de validación", 
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Registrar nueva inscripción
            service.registrar(n, d, c);

            // Actualizar visualización
            actualizarTabla();
            actualizarResumen();

            // Limpiar campos
            txtNombre.setText("");
            txtDocumento.setText("");
        });

        // === CARGA INICIAL DE DATOS ===
        actualizarTabla();
        actualizarResumen();
    }

    // === MÉTODO PARA ACTUALIZAR TABLA ===
    private void actualizarTabla() {
        modeloTabla.setRowCount(0); // elimina todas las filas de la tabla
        List<Inscripcion> inscripciones = service.listar();
        for (Inscripcion i : inscripciones) {
            modeloTabla.addRow(new Object[]{
                    i.getNombre(),
                    i.getDocumento(),
                    i.getCurso(),
                    i.getFechaHora().toLocalDate() +" "+ i.getFechaHora().toLocalTime().withNano(0)
            });
        }
    }

    // === MÉTODO PARA ACTUALIZAR RESUMEN ===
    private void actualizarResumen() {
        txtResumen.setText(service.resumen());
    }

    // === MÉTODO ESTÁTICO PARA MOSTRAR LA GUI ===
    public static void show(SesionService service) {
   // invokeLater asegura que la GUI se cree en el hilo de eventos de Swing (thread-safe)
        SwingUtilities.invokeLater(() -> new CheckInGUI(service).setVisible(true));
    }
}
