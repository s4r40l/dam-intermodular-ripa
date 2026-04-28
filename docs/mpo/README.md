# README.md — MÓDULO MPO  
### Ampliación de Programación*  
### Proyecto Intermodular — RIPA

---

## **1. Arquitectura del proyecto**

El proyecto RIPA sigue una arquitectura por capas para mantener el código organizado, escalable y fácil de mantener:

```
src/
 ├── model/          → Clases del dominio (Producto, Supermercado, RegistroPrecio)
 ├── DAO/            → Acceso a datos y consultas SQL
 ├── controller/     → Lógica de negocio y validaciones
 ├── database/       → Conexión JDBC
 ├── xml/            → Importación y exportación de datos en XML
 └── Main.java       → Menú principal y flujo de la aplicación
```

Esta estructura separa responsabilidades y permite que cada parte del sistema evolucione sin afectar al resto.

---

## **2. Diagrama simple de clases**

┌──────────────────────────────┐
│          Producto             │
├──────────────────────────────┤
│ - id                          │
│ - nombre                      │
│ - categoria                   │
│ - unidadMedida                │
├──────────────────────────────┤
│ + getId()                     │
│ + getNombre()                 │
│ + setNombre()                 │
│ + toString()                  │
└──────────────────────────────┘

┌──────────────────────────────┐
│        Supermercado           │
├──────────────────────────────┤
│ - id                          │
│ - nombre                      │
├──────────────────────────────┤
│ + getId()                     │
│ + getNombre()                 │
│ + setNombre()                 │
│ + toString()                  │
└──────────────────────────────┘

┌──────────────────────────────┐
│       RegistroPrecio          │
├──────────────────────────────┤
│ - id                          │
│ - fecha                       │
│ - precio                      │
│ - producto                    │
│ - supermercado                │
├──────────────────────────────┤
│ + getFecha()                  │
│ + getPrecio()                 │
│ + toString()                  │
└──────────────────────────────┘


┌──────────────────────────────┐
│         ProductoDAO           │
├──────────────────────────────┤
│ + create(Producto)            │
│ + findAll()                   │
│ + findById(int)               │
│ + findByName(String)          │
│ + delete(int)                 │
└──────────────────────────────┘

┌──────────────────────────────┐
│      SupermercadoDAO          │
├──────────────────────────────┤
│ + create(Supermercado)        │
│ + findAll()                   │
│ + findById(int)               │
│ + findByName(String)          │
│ + delete(int)                 │
└──────────────────────────────┘

┌──────────────────────────────┐
│     RegistroPrecioDAO         │
├──────────────────────────────┤
│ + create(RegistroPrecio)      │
│ + findAll()                   │
│ + findByProducto(int)         │
│ + delete(int)                 │
└──────────────────────────────┘


┌──────────────────────────────┐
│     ProductoController        │
├──────────────────────────────┤
│ + crearProductoConsola()      │
│ + listarProductosConsola()    │
│ + eliminarProductoConsola()   │
└──────────────────────────────┘

┌──────────────────────────────┐
│   SupermercadoController      │
├──────────────────────────────┤
│ + crearSupermercadoConsola()  │
│ + listarSupermercadosConsola()│
│ + eliminarSupermercadoConsola()│
└──────────────────────────────┘

┌──────────────────────────────┐
│   RegistroPrecioController    │
├──────────────────────────────┤
│ + crearRegistroConsola()      │
│ + listarRegistrosConsola()    │
│ + eliminarRegistroConsola()   │
└──────────────────────────────┘


┌──────────────────────────────┐
│         XMLExporter           │
├──────────────────────────────┤
│ + exportarXML(String ruta)    │
└──────────────────────────────┘

┌──────────────────────────────┐
│         XMLImporter           │
├──────────────────────────────┤
│ + importarXML(String ruta)    │
└──────────────────────────────┘


---

## **3. Aportación del módulo MPO**

La mejora implementada en MPO consiste en una **ampliación real de la arquitectura y funcionalidad del proyecto**, centrada en:

### **Separación clara en capas (modelo / DAO / controlador / XML / main)**  
Refactorización completa para lograr:

- Clases con responsabilidades claras  
- Encapsulación correcta  
- Código más legible y mantenible  
- Eliminación de duplicidades  
- Flujo de menús más limpio y modular  

### **Integración completa de importación y exportación XML**  

- `XMLExporter` → genera un XML real desde la base de datos  
- `XMLImporter` → reconstruye la BD a partir de un XML válido  
- Validación con XSD  
- Nuevos métodos en DAOs (`findByName`) para evitar duplicados  
- Integración en el menú principal  

Esta mejora aporta:

- Portabilidad de datos  
- Copias de seguridad  
- Intercambio estructurado de información  
- Profesionalización del proyecto  

### **Aplicación sólida de POO**  
- Uso correcto de objetos y relaciones  
- Cohesión y encapsulación  
- Sin herencia forzada  
- Métodos con una única responsabilidad  

---

## **4. Conclusión**

El módulo MPO ha permitido mejorar el proyecto RIPA tanto a nivel **estructural** como **funcional**, aplicando principios de POO, organizando el código en capas y añadiendo una mejora real y visible: la gestión completa de datos mediante XML.
