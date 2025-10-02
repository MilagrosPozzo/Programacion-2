# Check-in Aula

Sistema simple de registro de asistencia para cursos del CERP.

## 📋 Descripción

Aplicación que permite registrar inscripciones de estudiantes con:
- Nombre
- Documento
- Curso (Prog 1, Prog 2, Base de Datos)
- Hora automática de registro

Funciona en dos modos:
- **Consola**: Menú interactivo por línea de comandos
- **GUI**: Interfaz gráfica con Swing

## 🚀 Compilación y Ejecución

### Desde NetBeans
1. Abrir proyecto en NetBeans
2. Click derecho en el proyecto → **Clean and Build**
3. Click derecho en `App.java` → **Run File**

### Modo Consola (línea de comandos)
```bash
# Compilar
javac -d build/classes src/edu/cerp/checkin/**/*.java

# Ejecutar consola
java -cp build/classes edu.cerp.checkin.App

# Ejecutar GUI
java -cp build/classes edu.cerp.checkin.App --gui
