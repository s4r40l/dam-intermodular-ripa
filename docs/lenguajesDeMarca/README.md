# README — Lenguajes de Marca (XML)  
Proyecto Intermodular · 1º DAM

Este documento explica el trabajo realizado en el módulo **Lenguajes de Marca** dentro del proyecto RIPA. Incluye una descripción del XML generado, el proceso de validación mediante XSD y su integración dentro del proyecto global.

---

## 1. ¿Qué datos representa el XML?

El archivo **`datos.xml`** contiene una exportación estructurada de los datos principales del proyecto RIPA:

- **Productos** registrados  
- **Supermercados** disponibles  
- **Registros de precio**, que incluyen:
  - Producto asociado  
  - Supermercado asociado  
  - Fecha del registro  
  - Precio observado  

El XML refleja la misma estructura lógica que la base de datos y permite representar el histórico de precios de forma independiente al sistema.

---

## 2. ¿Cómo se valida el XML?

El XML se valida mediante el archivo **`esquema.xsd`**, que define:

- La estructura del documento  
- Los elementos permitidos  
- Los tipos de datos  
- Las relaciones entre elementos  
- Las restricciones necesarias (por ejemplo, precio > 0)

### Proceso de validación

La validación se ha realizado con:

- **Visual Studio Code**  
- Extensión **XML (Red Hat)**  
- Referencia al XSD incluida en la cabecera del XML:

```xml
<xsi:schemaLocation="esquema.xsd"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
```

Se han generado dos evidencias:

- **Validación correcta**  
- **Validación incorrecta** (modificando el XML para mostrar errores)

Ambas capturas están incluidas en `/docs/lenguajesDeMarca`.

---

## 3. ¿Cómo encaja dentro del proyecto?
El XML inicial que se creó y validó con el XSD sirvió como base de aprendizaje para asegurar que la estructura, los tipos de datos y las relaciones estaban correctamente definidas. Ese archivo permitió comprobar que el esquema funcionaba y que la aplicación sería capaz de generar e interpretar XML válidos.

Una vez validado el XML de ejemplo, se integró la funcionalidad real en la aplicación Java:

Exportación: la aplicación genera un XML real con los datos de la base de datos, siguiendo exactamente el mismo XSD.

Importación: la aplicación puede leer un XML válido y reconstruir productos, supermercados y registros en la base de datos.

---

## 4. Archivos incluidos

- `datos.xml` — Exportación de datos
- `datosIncorrectos.xml` — Ejemplo erróneo
- `esquema.xsd` — Esquema de validación  
- `validacionCorrectaXML.png` — Evidencia de validación exitosa  
- `validacionIncorrectaXMl.png` — Evidencia de validación fallida
- `comandovalidacionXML.png` — Evidencia comando para validar
- Este `README.md`
