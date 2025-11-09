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
```
📌 Ejecución
🖥️ Modo consola
```bash
java -cp out edu.cerp.checkin.App
```
🪟 Modo gráfico (GUI)
```bash
java -cp out edu.cerp.checkin.App --gui
```
## 📂 Estructura mínima del proyecto
```
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
```

### 💾 Persistencia implementada
Para esta versión, se incorporó un sistema de persistencia simple mediante archivos CSV.
Los datos se almacenan automáticamente cada vez que se registra una nueva inscripción y se cargan al iniciar la aplicación, tanto en modo consola como en modo GUI.

📁 Archivo utilizado:
```bash
data/inscripciones.csv
```
Cada línea contiene:

```
nombre|documento|curso|fechaHora
```
Ejemplo:

```less
Ana Pérez|51234567|Prog 2|2025-11-09T15:14:35
```
### 🧠 Reflexión sobre la persistencia elegida

Para este proyecto educativo se eligió implementar la persistencia utilizando un **archivo CSV (valores separados por comas o barras verticales)**.  
Este formato fue el más adecuado porque permite guardar los registros de manera **simple, legible y accesible** sin necesidad de bibliotecas externas ni bases de datos.  

Además, los archivos CSV pueden abrirse fácilmente en herramientas como **Excel o Google Sheets**, lo que facilita la comprensión del formato de almacenamiento para los estudiantes.  
De esta forma, se logra **introducir el concepto de persistencia de datos en Java** de una manera clara y didáctica, reforzando los fundamentos de entrada/salida de archivos antes de avanzar hacia soluciones más complejas como bases de datos o JSON.

## 👩‍🏫 Autora
Milagros Pozzo Fasini 

🗓️ Entrega: Noviembre 2025 – CERP SW

---
 
