# Check-in Aula - CERP

Proyecto en Java para registrar inscripciones al inicio de clase.  
Funciona tanto por consola como mediante una interfaz gráfica (GUI en Swing).  
No utiliza archivos JSON ni persistencia: todos los datos se manejan en memoria.

---

## 📋 Descripción

Aplicación Java para registrar inscripciones al inicio de clase.  
Permite trabajar tanto por consola como con interfaz gráfica (Swing).

**Funcionalidades:**
- Registrar inscripciones (Nombre, Documento, Curso, Hora automática).
- Listar todas las inscripciones registradas.
- Buscar por nombre o documento.
- Mostrar un resumen básico de inscriptos por curso.
- Cargar datos de prueba al iniciar.

---

## 🚀 Compilación

**Desde NetBeans:**
- Clic derecho en el proyecto → **Clean and Build**

**Desde terminal:**
```bash
javac -d out src/edu/cerp/checkin/**/*.java