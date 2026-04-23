-- ============================================================
--   BASE DE DATOS: RIPA (Registro Inteligente de Precios)
--   Script: 03_consultas.sql
--   Autor: Sara
--   Consultas útiles para pruebas y desarrollo
-- ============================================================

USE ripa;

-- ============================================================
-- 1. LISTAS BÁSICAS
-- ============================================================

-- Listar todos los productos
SELECT * FROM producto;

-- Listar todos los supermercados
SELECT * FROM supermercado;

-- Listar todos los usuarios
SELECT * FROM usuario;

-- Listar todos los registros de precios
SELECT * FROM registro_precio;


-- ============================================================
-- 2. CONSULTAS CON JOIN
-- ============================================================

-- Mostrar registros de precios con nombres de producto y supermercado
SELECT rp.id_registro, p.nombre AS producto, s.nombre AS supermercado,
       rp.fecha, rp.precio
FROM registro_precio rp
JOIN producto p ON rp.id_producto = p.id_producto
JOIN supermercado s ON rp.id_supermercado = s.id_supermercado
ORDER BY rp.fecha DESC;

-- Mostrar registros enseñando qué usuario los ha registrado
SELECT rp.id_registro, u.nombre AS usuario, p.nombre AS producto,
       s.nombre AS supermercado, rp.fecha, rp.precio
FROM registro_precio rp
JOIN usuario u ON rp.id_usuario = u.id_usuario
JOIN producto p ON rp.id_producto = p.id_producto
JOIN supermercado s ON rp.id_supermercado = s.id_supermercado
ORDER BY rp.fecha DESC;


-- ============================================================
-- 3. FILTROS ÚTILES
-- ============================================================

-- Precios de un producto en específico por identificador
SELECT * FROM registro_precio
WHERE id_producto = 1
ORDER BY fecha DESC;

-- Precios de un producto en específico por nombre
SELECT rp.*, p.nombre
FROM registro_precio rp
JOIN producto p ON rp.id_producto = p.id_producto
WHERE p.nombre = 'Tomate'
ORDER BY rp.fecha DESC;

-- Registros hechos por un usuario en específico
SELECT rp.*, u.nombre
FROM registro_precio rp
JOIN usuario u ON rp.id_usuario = u.id_usuario
WHERE u.nombre = 'Sara';


-- ============================================================
-- 4. ESTADÍSTICAS (media, mínimo, máximo)
-- ============================================================

-- Media de precio de un producto
SELECT p.nombre, AVG(rp.precio) AS precio_medio
FROM registro_precio rp
JOIN producto p ON rp.id_producto = p.id_producto
WHERE p.nombre = 'Tomate';

-- Precio mínimo y máximo de un producto
SELECT p.nombre,
       MIN(rp.precio) AS precio_minimo,
       MAX(rp.precio) AS precio_maximo
FROM registro_precio rp
JOIN producto p ON rp.id_producto = p.id_producto
WHERE p.nombre = 'Tomate';

-- Estadísticas por supermercado
SELECT s.nombre AS supermercado,
       AVG(rp.precio) AS media,
       MIN(rp.precio) AS minimo,
       MAX(rp.precio) AS maximo
FROM registro_precio rp
JOIN supermercado s ON rp.id_supermercado = s.id_supermercado
GROUP BY s.id_supermercado;


-- ============================================================
-- 5. COMPARACIONES ENTRE SUPERMERCADOS
-- ============================================================

-- Comparar el precio de un producto entre supermercados
SELECT p.nombre AS producto, s.nombre AS supermercado,
       rp.precio, rp.fecha
FROM registro_precio rp
JOIN producto p ON rp.id_producto = p.id_producto
JOIN supermercado s ON rp.id_supermercado = s.id_supermercado
WHERE p.nombre = 'Tomate'
ORDER BY rp.precio ASC;

-- Ver cuál supermercado tiene el precio más barato de cierto producto
SELECT s.nombre AS supermercado, rp.precio
FROM registro_precio rp
JOIN supermercado s ON rp.id_supermercado = s.id_supermercado
JOIN producto p ON rp.id_producto = p.id_producto
WHERE p.nombre = 'Tomate'
ORDER BY rp.precio ASC
LIMIT 1;


-- ============================================================
-- 6. HISTÓRICO COMPLETO DE UN PRODUCTO ESPECÍFICO
-- ============================================================

SELECT p.nombre AS producto, rp.fecha, rp.precio, s.nombre AS supermercado
FROM registro_precio rp
JOIN producto p ON rp.id_producto = p.id_producto
JOIN supermercado s ON rp.id_supermercado = s.id_supermercado
WHERE p.nombre = 'Aceite de Oliva'
ORDER BY rp.fecha;
