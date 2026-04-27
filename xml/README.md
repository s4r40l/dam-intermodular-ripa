# Módulo de Lenguajes de Marcas  
Proyecto Intermodular · RIPA · 1º DAM

## 1. Descripción
Este módulo incluye la creación y validación de un archivo XML relacionado con el proyecto RIPA.  
El XML representa productos y sus registros de precio, siguiendo la estructura real del sistema y de la base de datos.

## 2. Archivos incluidos
- **datos.xml** — XML real del proyecto
- **datosIncorrectos.xml** — XML de prueva de error
- **esquema.xsd** — Esquema XSD que valida el XML
- **comandovalidacionXML** — Lo que sale al hacer Cntrl + Shift + p para poder ejecutar la validación
- **validacionCorrectaXML.png** — Evidencia de validación correcta  
- **validacionIncorrectaXML.png** — Ejemplo de validación incorrecta  
- **README.md** — Este documento

## 3. Contenido del XML
El archivo `datos.xml` contiene:
- Una lista de **productos**
- Cada producto incluye:
  - nombre  
  - categoría  
  - unidad de medida  
  - registros de precio
- Cada registro incluye:
  - fecha  
  - precio  
  - supermercado  

La estructura es coherente con la base de datos del proyecto.

## 4. Validación
El XML se valida mediante `esquema.xsd`, que define:
- Estructura y jerarquía  
- Tipos de datos (string, decimal, date…)  
- Restricciones (precio mínimo, formato de fecha…)  
- Cardinalidades  

La validación se ha realizado en **Visual Studio Code** usando la extensión **XML (Red Hat)**.

## 5. Evidencias

### ✔️ Validación correcta
![Validación correcta](validacionCorrectaXML.png)

### ❌ Validación incorrecta (opcional)
![Validación incorrecta](validacionIncorrectaXML.png)

## 6. Integración con el proyecto
Este XML actúa como **exportación estructurada de datos**, permitiendo representar productos y su histórico de precios para:
- Intercambio de datos  
- Documentación  
- Importación/exportación  
- Validación externa  
