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
- unidad_medida *(kg, unidad, litro…)*

### **2. Supermercado**
Lugar donde se registra el precio.
- id_supermercado (PK)
- nombre

### **3. RegistroPrecio**
Cada vez que el usuario introduce un precio.
- id_registro (PK)
- id_producto (FK)
- id_supermercado (FK)
- fecha
- precio

### **4. Usuario**
- id_usuario (PK)
- nombre
- email

---

# 2. Relaciones y cardinalidades

- **Producto (1) — (N) RegistroPrecio**  
  Un producto puede tener muchos registros de precio.

- **Supermercado (1) — (N) RegistroPrecio**  
  Un supermercado puede tener muchos registros.

- **Usuario (1) — (N) RegistroPrecio** *(opcional)*  
  Un usuario puede registrar muchos precios.

---

