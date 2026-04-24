# Scripts SQL — Proyecto RIPA

Esta carpeta contiene todos los scripts SQL necesarios para crear, rellenar y probar la base de datos del proyecto **RIPA (Registro Inteligente de Precios de Alimentos)**.  
Los scripts están diseñados para ejecutarse en **MySQL** mediante **phpMyAdmin** incluido en **XAMPP**.

---

# Contenido de la carpeta

### **1. `01_creacion_tablas.sql`**
Script que crea toda la estructura de la base de datos:
- Tabla `usuario`
- Tabla `producto`
- Tabla `supermercado`
- Tabla `registro_precio`
- Claves primarias
- Claves foráneas
- Restricciones (incluyendo CHECK de precio > 0)

Este archivo debe ejecutarse **primero**.

---

### **2. `02_insercion_data.sql`**
Script con datos de ejemplo para pruebas:
- Usuarios de prueba  
- Productos reales  
- Supermercados comunes  
- Registros de precios con fechas y valores coherentes  

Permite validar el modelo y realizar consultas de prueba.

---

### **3. `03_consultas.sql`**
Colección de consultas útiles para:
- Listados básicos  
- JOIN entre tablas  
- Filtros por producto, usuario o supermercado  
- Estadísticas (media, mínimo, máximo)  
- Comparaciones entre supermercados  
- Histórico de precios  

Estas consultas sirven para comprobar el correcto funcionamiento de la base de datos.

---

# Cómo ejecutar los scripts en XAMPP (phpMyAdmin)

1. Inicia **MySQL** desde el panel de XAMPP.  
2. Abre en el navegador "http://localhost/phpmyadmin"
4. Crea la base de datos llamada "ripa" mediante "CREATE DATABASE ripa;" o gráficamente
5. Selecciona la base de datos y ve a la pestaña **SQL**.  
6. Ejecuta los scripts en el orden especificado
