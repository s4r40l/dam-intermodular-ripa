# RIPA — Registro Inteligente de Precios de Alimentos  
Proyecto Intermodular · 1º DAM

## 1. Descripción general
RIPA es una aplicación destinada a registrar y consultar precios de alimentos frescos en distintos supermercados o mercados locales.  
Su objetivo principal es ofrecer al usuario un histórico personal de precios que le permita identificar si un precio es caro, barato o habitual, facilitando decisiones de compra más informadas.

## 2. Problema que resuelve

Los precios de los alimentos varían según el lugar, la temporada y la oferta disponible.
Los consumidores no disponen de una herramienta sencilla para comparar precios o consultar históricos personales.
RIPA ofrece una solución centralizada y organizada para almacenar estos datos y analizarlos fácilmente.

## 3. Tecnologías utilizadas
- **Java 17**
- **JDBC para la conexión con la base de datos**
- **MySQL / MariaDB (XAMPP)**
- **Git + GitHub para control de versiones**
- **XML + XSD para exportación/validación de datos**
- **Modelo MVC simplificado (controladores, DAOs, modelos)**

## 4. Instrucciones de instalación y ejecución
### Requisitos previos
- Java 17 o superior
- MySQL/MariaDB instalado
- Git (opcional, para clonar el repositorio)

### Instalación
- Clonar el repositorio:
    git clone https://github.com/tuusuario/ripa.git
- Importar el proyecto en tu IDE (IntelliJ, Eclipse, VS Code con extensiones Java).
- Crear la base de datos ejecutando el script en /sql/creacion_tablas.sql.
- Insertar datos iniciales con /sql/datos_iniciales.sql (opcional).

### Ejecución
1. Abrir IntelliJ.
2. Ejecutar la clase principal:
   MainApp.java

## 5. Datos gestionados por la aplicación
- Información básica de productos  
- Información de lugares
- Precios asociados a productos, lugares y fechas.

## 6. Entidades principales
Producto: alimento cuyo precio se registra.

Lugar (Supermercado): establecimiento donde se toma el precio.

Registro de precio: precio de un producto en un lugar y fecha concreta.

## 7. Alcance del proyecto
Este proyecto integra los módulos de:

- Bases de Datos  
- Programación  
- Entornos de Desarrollo  
- Sistemas Informáticos  
- Lenguajes de Marcas  
- MPO (Ampliación de Programación)

El desarrollo se realizará manteniendo coherencia entre todos los módulos y siguiendo las directrices del PDF oficial del Proyecto Intermodular.

## 8. Estado del proyecto
En desarrollo — versión funcional con conexión a base de datos y operaciones principales implementadas.

## 9. Licencia
Proyecto académico. Uso libre para fines educativos.
