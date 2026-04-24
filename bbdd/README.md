# Diseño de la Base de Datos — RIPA

Este documento recoge todo el trabajo correspondiente al módulo **Bases de Datos**.

---

# 1. Análisis de Datos

La aplicación RIPA gestiona información relacionada con precios de alimentos registrados por el usuario en distintos supermercados o mercados locales.  
A partir de los requisitos funcionales, se identifican las siguientes entidades, atributos y relaciones.

## Entidades y atributos

### **1. Producto**
Representa un alimento cuyo precio se quiere registrar.
- id_producto (PK)
- nombre
- categoria
- unidad_medida

### **2. Supermercado**
Lugar donde se registra el precio.
- id_supermercado (PK)
- nombre

### **3. RegistroPrecio**
Cada vez que el usuario introduce un precio.
- id_registro (PK)
- id_producto (FK)
- id_supermercado (FK)
- id_usuario (FK)
- fecha
- precio

### **4. Usuario**
- id_usuario (PK)
- nombre
- email
- contraseña

---

# 2. Relaciones y cardinalidades

- **Producto (1) — (N) RegistroPrecio**  
  Un producto puede tener muchos registros de precio.

- **Supermercado (1) — (N) RegistroPrecio**  
  Un supermercado puede tener muchos registros.

- **Usuario (1) — (N) RegistroPrecio**
  Un usuario puede registrar muchos precios.

---

  # 3. Diagrama Entidad–Relación (E/R)

El diagrama E/R se encuentra en la carpeta:

/docs/bbdd/MODELO ENTIDAD RELACIÓN RIPA.png

Incluye:
- Entidades  
- Atributos  
- Claves primarias  
- Claves foráneas  
- Relaciones  
- Cardinalidades  

---

# 4. Modelo Relacional

Transformación del E/R a tablas:

PRODUCTO (
id_producto PK,
nombre,
categoria,
unidad_medida
)

SUPERMERCADO (
id_supermercado PK,
nombre
)

REGISTRO_PRECIO (
id_registro PK,
id_producto FK,
id_supermercado FK,
id_usuario FK,
fecha,
precio
)

USUARIO (
id_usuario PK,
nombre,
email,
contraseña
)

---

# 5. Scripts SQL del proyecto

Los scripts SQL se encuentran en la carpeta:

```
/sql
```

y se ejecutan en el siguiente orden:

## **01_create_tables.sql**  
Crea toda la estructura de la base de datos

## **02_insert_data.sql**  
Inserta datos de ejemplo para pruebas

## **03_queries.sql**  
Incluye consultas útiles
