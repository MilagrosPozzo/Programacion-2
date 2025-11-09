# 🏫 Check-in Aula - CERP

Proyecto en **Java** para registrar inscripciones al inicio de clase.  
Funciona tanto por **consola** como mediante una **interfaz gráfica (GUI con Swing)**.  
No utiliza base de datos ni frameworks externos: todos los datos se manejan en **memoria y persistencia simple en archivo CSV**.

---

## 📋 Descripción

Aplicación educativa desarrollada en Java que permite gestionar las inscripciones al inicio de clase.  
El sistema permite registrar estudiantes, listarlos, realizar búsquedas por texto y mostrar un resumen general de inscriptos por curso.  

La aplicación puede ejecutarse:
- 🖥️ Por consola (modo texto).
- 🪟 Con interfaz gráfica (Swing).

---

## ⚙️ Funcionalidades principales

✅ Registrar inscripciones (Nombre, Documento, Curso, Hora automática).  
✅ Listar todas las inscripciones registradas.  
✅ Buscar por nombre o documento.  
✅ Mostrar un resumen básico por curso.  
✅ Cargar datos de prueba al iniciar.  
✅ Guardar y recuperar inscripciones automáticamente mediante persistencia en archivo CSV.  

---

## 🚀 Compilación

### Desde NetBeans:
1. Clic derecho en el proyecto → **Clean and Build**

### Desde terminal:
```bash
javac -d out src/edu/cerp/checkin/**/*.java
📌 Ejecución
🖥️ Modo consola
bash
Copiar código
java -cp out edu.cerp.checkin.App
🪟 Modo gráfico (GUI)
bash
Copiar código
java -cp out edu.cerp.checkin.App --gui
📂 Estructura mínima del proyecto
bash
Copiar código
src/
└─ edu/cerp/checkin/
   ├─ model/
   │  └─ Inscripcion.java
   ├─ logic/
   │  └─ SesionService.java
   ├─ persistencia/
   │  └─ ArchivoManager.java
   ├─ console/
   │  └─ MainConsole.java
   ├─ ui/
   │  └─ CheckInGUI.java
   └─ App.java
data/
└─ inscripciones.csv
💾 Persistencia implementada
Para esta versión, se incorporó un sistema de persistencia simple mediante archivos CSV.
Los datos se almacenan automáticamente cada vez que se registra una nueva inscripción y se cargan al iniciar la aplicación, tanto en modo consola como en modo GUI.

📁 Archivo utilizado:
bash
Copiar código
data/inscripciones.csv
Cada línea contiene:

Copiar código
nombre|documento|curso|fechaHora
Ejemplo:

less
Copiar código
Ana Pérez|51234567|Prog 2|2025-11-09T15:14:35
🧠 Reflexión pedagógica
Se eligió el formato CSV (Comma Separated Values) porque:

Es simple de implementar en proyectos educativos.

Permite visualizar y editar los datos fácilmente desde herramientas comunes como Excel o Google Sheets.

No requiere bibliotecas externas ni configuración adicional.

Favorece la comprensión de conceptos básicos de persistencia y manejo de archivos en Java, sin sobrecargar al estudiante con detalles de bases de datos.

Esta elección equilibra la simplicidad técnica con la claridad conceptual, ideal para cursos introductorios de programación y orientación educativa en lógica aplicada.

👩‍🏫 Autora
Milagros Pozzo Fasini – CERP SW
Proyecto académico: Programación 2 – Módulo “Manejo de Archivos en Java”

yaml
Copiar código

---

✅ **Con esto:**
- GitHub mostrará los bloques de código correctamente.
- Las secciones se verán bien separadas.
- No tendrás errores de cierre de bloque ni formato.

¿Querés que te agregue una línea final con una **imagen de la GUI funcionando con persistencia** (por ejemplo una captura)?  
Podría incluir algo como:  
```markdown
![Interfaz gráfica del proyecto](capturas/gui_checkin.png)
