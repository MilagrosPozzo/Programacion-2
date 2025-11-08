// Paquete correcto: debe coincidir con la carpeta donde está este archivo
package edu.cerp.checkin.ui;

import edu.cerp.checkin.logic.SesionService;
import edu.cerp.checkin.model.Inscripcion;

import javax.swing.*;   // Librería para ventanas, botones, etc.
import javax.swing.table.DefaultTableModel; // Para usar tablas en la GUI
import java.awt.*;      // Para layouts (cómo se acomodan los componentes)
import java.util.List;  // Para trabajar con listas de inscripciones

/**
 * Ventana de Check-in Aula (versión GUI con JTable + resumen por curso).
 */
public class CheckInGUI extends JFrame {
    private final SesionService service;          // Servicio central: lógica de inscripciones
    private final DefaultTableModel modeloTabla;  // Modelo que gestiona los datos de la JTable
    private final JTextArea txtResumen;           // Área de texto para mostrar resumen por curso

    // Campos de entrada de datos
    private JTextField txtNombre;
    private JTextField txtDocumento;
    private JComboBox<String> cbCurso;

    // Constructor: arma toda la ventana
    public CheckInGUI(SesionService service) {
        super("Check-in Aula (GUI)"); // Título de la ventana
        this.service = service;

        // ==== Crear componentes ====
        txtNombre = new JTextField(15);   // Campo para nombre
        txtDocumento = new JTextField(10); // Campo para documento
        cbCurso = new JComboBox<>(new String[]{"Prog 1", "Prog 2", "Base de Datos"}); // Combo de cursos
        JButton btnRegistrar = new JButton("Registrar ✔"); // Botón para registrar inscripción

        // Definición de columnas de la tabla
        String[] columnas = {"Nombre", "Documento", "Curso", "Hora"};
        modeloTabla = new DefaultTableModel(columnas, 0); // Modelo vacío
        JTable tabla = new JTable(modeloTabla);           // Tabla que usa el modelo
        JScrollPane scrollTabla = new JScrollPane(tabla); // Scroll para la tabla

        // Área de resumen debajo de la tabla
        txtResumen = new JTextArea(5, 30);
        txtResumen.setEditable(false);                    // Solo lectura
        JScrollPane scrollResumen = new JScrollPane(txtResumen);

        // ==== Panel del formulario (arriba) ====
        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5)); // 4 filas, 2 columnas
        form.add(new JLabel("Nombre:"));    form.add(txtNombre);
        form.add(new JLabel("Documento:")); form.add(txtDocumento);
        form.add(new JLabel("Curso:"));     form.add(cbCurso);
        form.add(new JLabel(""));           form.add(btnRegistrar);

        // ==== Layout principal de la ventana ====
        setLayout(new BorderLayout(10, 10));
        add(form, BorderLayout.NORTH);       // Formulario arriba
        add(scrollTabla, BorderLayout.CENTER); // Tabla en el centro
        add(scrollResumen, BorderLayout.SOUTH); // Resumen abajo

        // ==== Acción del botón Registrar ====
        btnRegistrar.addActionListener(e -> {
            String n = txtNombre.getText().trim();  // Obtener nombre
            String d = txtDocumento.getText().trim(); // Obtener documento
            String c = (String) cbCurso.getSelectedItem(); // Obtener curso

            // Validación simple: no aceptar nombre vacío
            if (n.isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.", 
                                              "Error de validación", JOptionPane.WARNING_MESSAGE);
                return; // No registrar si no hay nombre
            }

            // Registrar inscripción usando la lógica central (SesionService)
            service.registrar(n, d, c);

            // Refrescar tabla y resumen
            actualizarTabla();
            actualizarResumen();

            // Limpiar los campos de entrada
            txtNombre.setText("");
            txtDocumento.setText("");
        });

        // ==== Inicializar ventana con datos precargados ====
        actualizarTabla();
        actualizarResumen();

        // Configuración final de la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cerrar aplicación al salir
        setSize(600, 400);                              // Tamaño por defecto
        setLocationRelativeTo(null);                    // Centrar en pantalla
    }

    // Refrescar la tabla con todas las inscripciones actuales
   private void actualizarTabla() {
    modeloTabla.setRowCount(0); // Limpiar filas previas
    List<Inscripcion> inscripciones = service.listar(); // Obtener todas las inscripciones
    for (Inscripcion i : inscripciones) {
        modeloTabla.addRow(new Object[]{
                i.getNombre(),
                i.getDocumento(),
                i.getCurso(),
                i.getHora() 
        });
    }
}

    // Refrescar el área de resumen con el conteo por curso
    private void actualizarResumen() {
        txtResumen.setText(service.resumen()); // Llama al método resumen() de SesionService
    }

    // Método estático que usa App.java para abrir la GUI
    public static void show(SesionService service) {
        SwingUtilities.invokeLater(() -> new CheckInGUI(service).setVisible(true));
    }
}