DOCUMENTO DE ESPECIFICACIÓN DE REQUERIMIENTOS  
Versión: 1.0 - Modificada
Fecha: Abril 2025
Autor: Equipo de Actualización

---------------------------------------
Contexto
---------------------------------------
La librería de la Universidad El Pensador desea ofrecer una tienda virtual enfocada en la venta de libros.  
Los usuarios podrán visualizar el catálogo y adquirir libros vía internet.

---------------------------------------
Alcance
---------------------------------------
Este sistema se centrará exclusivamente en la venta de libros, incorporando además recomendaciones personalizadas, opiniones de usuarios, administración de stock en tiempo real, y recopilación de estadísticas de uso.

---------------------------------------
Glosario de Términos
---------------------------------------
Book: Libro en la tienda.  
Author: Autor de uno o muchos libros.  
Editorial: Empresa Editorial de los libros.  
--- NUEVO ---  
Opinión: Comentario y calificación que un usuario deja sobre un libro.  
Recomendación: Sugerencia de libro basada en compras anteriores del usuario.  
Dirección de Envío: Información de entrega proporcionada por el cliente.  
Estadística de Búsqueda: Datos de búsqueda de libros o agregados a carrito.

---------------------------------------
Requerimientos Funcionales
---------------------------------------
Actores:  
- Usuario Comprador  
- Administrador  

Casos de Uso:
- CU1: Consultar datos de un libro.  
- CU2: Crear un libro.  
- CU3: Ver el catálogo de libros.  

--- NUEVO ---  
- CU4: Dejar una opinión sobre un libro.  
- CU5: Ver recomendaciones basadas en el historial de compras.  
- CU6: Visualizar disponibilidad real del stock.  
- CU7: Guardar dirección de envío para próximas compras.  
- CU8: Registrar estadísticas de búsquedas y carritos.  
- CU9: Editar datos de libros existentes.  
- CU10: Registrar ventas y generar reportes administrativos.

---------------------------------------
Reglas de Negocio
---------------------------------------
- No existen dos libros con el mismo ISBN.  
- No se puede eliminar un autor si tiene libros registrados.  

--- NUEVO ---  
- El sistema debe mostrar la disponibilidad actualizada del stock.  
- Las opiniones deben ser moderadas antes de ser publicadas.  
- Cada venta debe quedar registrada en el sistema.

---------------------------------------
Requerimientos No Funcionales
---------------------------------------
- El software debe soportar múltiples usuarios simultáneamente.  
- La interfaz debe ser intuitiva y agradable para el usuario.  

--- NUEVO ---  
- El sistema de recomendaciones debe responder en menos de 2 segundos.  
- El sistema debe proteger la privacidad de las direcciones de envío.

---------------------------------------
Otras Restricciones
---------------------------------------
- El software debe funcionar en Glassfish 4.x y bases de datos MySQL.  
- La integración continua debe realizarse con Jenkins.  
- El control de versiones debe llevarse en Github.  

--- NUEVO ---  
- Los reportes de ventas deben ser exportables en formato PDF y Excel.

---------------------------------------
Fin del Documento
---------------------------------------