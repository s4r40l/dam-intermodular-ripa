# README.md — Módulo de Programación  
### Proyecto Intermodular — RIPA (Registro Inteligente de Precios de Alimentos)

---

## **1. ¿Qué aporta la aplicación dentro del Proyecto Intermodular?**

En el módulo de Programación se ha desarrollado la **aplicación funcional completa** del proyecto RIPA.  
Esta aplicación es el núcleo del sistema: gestiona datos reales, se conecta a la base de datos mediante JDBC y permite al usuario interactuar con el modelo de forma práctica y coherente.

---

## **2. Cómo cumple la aplicación los requisitos del módulo**

### **2.1. Uso correcto de fundamentos de programación**

La aplicación demuestra dominio de los contenidos de 1º mediante:

- **Variables y tipos de datos** en modelos y controladores.  
- **Condicionales y bucles** en los menús y validaciones.  
- **Métodos bien definidos** para cada acción (crear, listar, eliminar…).  
- **Clases y objetos** para representar Productos, Supermercados y Registros.  
- **Estructuras de datos** (listas) para manejar resultados de consultas.  
- **Manejo de errores** con try/catch en JDBC y validaciones de entrada.  
- **Modularización** mediante paquetes: `model`, `DAO`, `controller`, `xml`.  
- **Buenas prácticas**: nombres claros, responsabilidades separadas, código limpio.

---

### **2.2. Funcionalidad real implementada**

La aplicación no simula nada: **realiza acciones completas sobre datos reales**.

Incluye:

- Crear productos, supermercados y registros de precio.  
- Listar información de forma organizada.  
- Eliminar elementos.  
- Consultar registros existentes.  
- Validar entradas del usuario.  
- Mostrar listados completos desde la base de datos.  

Todo esto está integrado en un **menú por consola con submenús**, fácil de usar y bien estructurado.

---

### **2.3. Conexión real con la Base de Datos mediante JDBC**

La aplicación se conecta a MySQL/MariaDB usando JDBC a través de la clase `ConexionBD`.

Cumple todos los requisitos:

- Conexión establecida mediante `DriverManager`.  
- Operaciones CRUD reales en los DAOs.  
- Consultas SQL preparadas para evitar errores y duplicados.  
- Recuperación de resultados mediante `ResultSet`.  
- Inserción, lectura y eliminación de datos reales.  

No hay datos simulados: **todo proviene de la base de datos diseñada en BBDD**.

---

### **2.4. Interfaz básica y usable**

La aplicación ofrece una interfaz por consola:

- Menú principal claro.  
- Submenús para cada módulo funcional.  
- Navegación simple y coherente.  
- Mensajes informativos y validación de entradas.  

El usuario puede interactuar con el sistema sin dificultad.

---

### **2.5. Coherencia con el proyecto global**

La aplicación está totalmente alineada con:

- **El modelo de datos** del módulo de BBDD.  
- **El XML y XSD** del módulo de Lenguajes de Marca.  
- **La arquitectura POO** definida en MPO.  
- **La temática del proyecto** (gestión de precios de alimentos).  

Además, integra la funcionalidad extra de MPO:

- **Importación y exportación XML**  
- **Refactorización por capas**  
- **Validaciones y reglas de negocio claras**

Todo encaja dentro del ecosistema del proyecto intermodular.

---

## **3. Funcionalidades principales de la aplicación**

- Gestión de productos  
- Gestión de supermercados  
- Registro de precios  
- Listados completos  
- Validaciones básicas  
- Conexión JDBC  
- Importación y exportación XML  
- Arquitectura por capas

---

## **4. Cómo ejecutar la aplicación**

1. Configurar la base de datos usando el script SQL del módulo de BBDD.  
2. Ajustar las credenciales en `ConexionBD.java`.  
3. Ejecutar `Main.java` desde el IDE.  
4. Navegar por el menú para usar las funcionalidades.

---

## **5. Contenido de esta carpeta**

- Documentación del módulo de Programación  
- Explicación de la arquitectura  
- Capturas de funcionamiento  
- Este README  
- Código fuente en `/src/` (fuera de esta carpeta)
