# INFORME TÉCNICO DE SISTEMAS INFORMÁTICOS  
**Proyecto Intermodular 1º DAM**

---

## 1. Tipo de sistema donde se ejecuta  

### **Sistema elegido: PC de usuario (Windows)**  
La aplicación **RIPA** es una aplicación Java con conexión JDBC a MySQL. Su uso está orientado a:

- Usuarios individuales que gestionan datos localmente  

Por tanto, **no requiere infraestructura de servidor**, ni virtualización, ni despliegue multiusuario.  
Un **PC de usuario** es suficiente porque:

- La aplicación se ejecuta localmente desde IntelliJ.  
- La base de datos MySQL se instala en local.  
- El consumo de recursos es bajo.  
- No hay concurrencia ni acceso remoto.  

**Justificación técnica:**  
RIPA es una aplicación de escritorio con persistencia local → PC de usuario es la opción más adecuada.

---

## 2. Requisitos de hardware  

### **Requisitos mínimos**
| Recurso | Especificación |
|--------|----------------|
| CPU | Intel i3 / AMD equivalente |
| RAM | 4 GB |
| Almacenamiento | 2 GB libres (Java + MySQL + proyecto) |
| Periféricos | Teclado y ratón |

### **Requisitos recomendados**
| Recurso | Especificación |
|--------|----------------|
| CPU | Intel i5 o superior |
| RAM | 8 GB |
| Almacenamiento | 10 GB libres |
| Periféricos | TAclado, ratón y Monitor 1080p para mejor visualización |

**Coherencia con la aplicación:**  
RIPA ejecuta Java, MySQL y un IDE (IntelliJ), por lo que los requisitos recomendados garantizan fluidez.

---

## 3. Sistema operativo recomendado

### **Sistema operativo recomendado: Windows 10/11 (64 bits)**

### **Justificación**
- IntelliJ funciona de forma nativa y estable en Windows.  
- Ofrece una integración estable y sencilla con entornos Apache/XAMPP, permitiendo ejecutar MySQL de forma nativa sin configuraciones adicionales.
- La mayoría de usuarios finales utilizan Windows.  
- Permite ejecutar Java, Maven y MySQL sin configuraciones adicionales.

---

## 4. Instalación del entorno (paso a paso)

---

### **4.1. Instalación de Java (JDK 17 o superior)**  
1. Descargar JDK desde Oracle o Adoptium.  
2. Instalar con opciones por defecto.  
3. Verificar instalación:  
   ```
   java -version
   ```

---

### **4.2. Instalación de IntelliJ IDEA Community**  
1. Descargar desde [https://www.jetbrains.com/idea](https://www.jetbrains.com/idea)  
2. Instalar con opciones por defecto.  
3. Activar plugins:  
   - Maven  
   - Java

---

### **4.3. Instalación de MySQL APACHE**  
1. Descargar XAMPP desde:
https://www.apachefriends.org/es/index.html

2. Instalar con opciones por defecto.

3. En el panel de control de XAMPP, activar:

  - Apache (si se necesita para phpMyAdmin)

  - MySQL

4. Acceder a phpMyAdmin desde:

   - http://localhost/phpmyadmin 


---

### **4.4. Configuración del proyecto RIPA en IntelliJ**  
1. Clonar el repositorio:  
   ```
   git clone https://github.com/s4r40l/dam-intermodular-ripa
   ```
2. Abrir el proyecto en IntelliJ.  
3. IntelliJ detectará automáticamente el proyecto Maven.  

---

### **4.5. Ejecución de la aplicación**  

Pasos:

1. Abrir `MainApp.java` con IntelliJ  
2. Pulsar **Run ▶️**  
3. IntelliJ compila y ejecuta JavaFX + JDBC  
4. La aplicación se inicia y se conecta a MySQL

---

## 5. Usuarios, permisos y estructura  

### **Usuarios del sistema**
| Usuario | Uso |
|--------|-----|
| Usuario Windows | Ejecuta IntelliJ y la aplicación |
| root (MySQL) | Administración de la base de datos |

### **Permisos**
- **Windows:** permisos estándar de usuario.  
- **MySQL:**  
  - `root`: solo para administración.

---

## 6. Mantenimiento básico  

### **Actualizaciones recomendadas**
| Elemento | Frecuencia |
|----------|------------|
| Java JDK | Cada 6 meses |
| IntelliJ | Mensual |
| MySQL | Cada 6–12 meses |
| Dependencias Maven | Según avisos del IDE |

### **Revisiones periódicas**
- Comprobar que MySQL arranca correctamente.  
- Verificar conexión JDBC.  
- Revisar logs de errores en IntelliJ.  
- Comprobar espacio en disco.

### **Qué hacer si falla**
| Problema | Solución |
|----------|----------|
| No conecta a MySQL | Revisar puerto 3306 y credenciales |
| Error JavaFX | Verificar dependencias en `pom.xml` |
| IntelliJ no ejecuta | Invalidar cachés y reiniciar |

---
