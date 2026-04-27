# RIPA — Registro Inteligente de Precios de Alimentos  
Proyecto Intermodular · 1º DAM

## Descripción
RIPA es una aplicación multiplataforma diseñada para registrar, consultar y comparar precios de alimentos frescos en distintos supermercados o mercados locales.  
El objetivo es ofrecer al usuario un histórico personal de precios que le permita saber si un precio es caro, barato o habitual, y tomar decisiones informadas al comprar.

Este proyecto forma parte del **Proyecto Intermodular de 1º DAM**, integrando los módulos de:
- Bases de Datos  
- Programación  
- Entornos de Desarrollo  
- Sistemas Informáticos  
- Lenguajes de Marcas  
- MPO (Ampliación de Programación)

---

## Objetivo del proyecto
Crear una aplicación realista, útil y bien estructurada que permita:
- Registrar precios de productos en diferentes lugares.
- Consultar históricos completos.
- Calcular medias, mínimos y máximos.
- Comparar precios entre supermercados.
- Exportar datos a XML.
- Trabajar con una arquitectura orientada a objetos.

---

## Funcionalidades previstas
- CRUD completo de productos, lugares y registros de precios.
- Cálculo automático de estadísticas (media, mínimo, máximo).
- Filtros por fecha, producto o supermercado.
- Comparación de precios entre lugares.
- Conexión a base de datos mediante JDBC.
- Exportación de datos a XML + validación con XSD.
- Validación básica de datos (precio > 0, fechas válidas).
- Mejora estructural para MPO (capas, servicios, validaciones…).

---

## Estructura del repositorio
/docs
/bbdd
/sistemas
/xml
/src
/sql
/diagrams

---

## Tecnologías previstas
- Java
- JDBC
- MySQL / MariaDB
- XML + XSD
- Git y GitHub

---

## Estado del proyecto
Fase inicial — definición y diseño.

---

## Licencia
Proyecto académico. Uso libre para fines educativos.




000000000000000000000000000000000000000000000000000000000000000000000
# RIPA — Registro Inteligente de Precios de Alimentos  
Proyecto Intermodular · 1º DAM

## 1. Descripción general
RIPA es una aplicación destinada a registrar y consultar precios de alimentos frescos en distintos supermercados o mercados locales.  
Su objetivo principal es ofrecer al usuario un histórico personal de precios que le permita identificar si un precio es caro, barato o habitual, facilitando decisiones de compra más informadas.

## 2. Problema que resuelve
Los precios de los alimentos varían según el lugar, la temporada y la oferta disponible.  
Los consumidores no disponen de una herramienta sencilla para comparar precios o consultar históricos personales.  
RIPA proporciona un sistema organizado para almacenar estos datos y consultarlos posteriormente.

## 3. Usuarios del sistema
- **Usuario general**: persona que desea registrar precios y consultarlos más adelante.

## 4. Entidades principales
El proyecto se basa en tres entidades fundamentales:

- **Producto**: alimento cuyo precio se desea registrar.  
- **Lugar**: supermercado o mercado donde se toma el precio.  
- **Registro de precio**: precio de un producto en un lugar y fecha concreta.

## 5. Datos gestionados por la aplicación
- Información básica de productos  
- Información de lugares
- Precios asociados a productos, lugares y fechas.

## 6. Operaciones previstas
La aplicación permitirá realizar las siguientes operaciones básicas:

- Alta, baja, modificación y consulta de productos.  
- Alta, baja, modificación y consulta de lugares.  
- Registro y consulta de precios asociados.  
- Consulta de históricos por producto.  
- Comparación básica de precios entre lugares.

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
Fase inicial — definición y diseño.

## 9. Licencia
Proyecto académico. Uso libre para fines educativos.
