-- ============================================================
--   BASE DE DATOS: RIPA (Registro Inteligente de Precios)
--   Script: 02_insercion_data.sql
--   Autor: Sara
--   Datos de ejemplo para pruebas
-- ============================================================

USE ripa;

-- ============================================================
--   INSERTAR USUARIOS
-- ============================================================
INSERT INTO usuario (nombre, email, contrasenya) VALUES
('Sara', 'sara@ejemplo.com', '123456'),
('Marc', 'marc@ejemplo.com', '123456'),
('Raquel', 'raquel@ejemplo.com', '123456');

-- ============================================================
--   INSERTAR PRODUCTOS
-- ============================================================
INSERT INTO producto (nombre, categoria, unidad_medida) VALUES
('Tomate', 'Verdura', 'kg'),
('Leche Entera', 'Lácteos', 'litro'),
('Manzana Golden', 'Fruta', 'kg'),
('Arroz Redondo', 'Cereales', 'kg'),
('Huevos L', 'Huevos', 'docena'),
('Aceite de Oliva', 'Aceites', 'litro');

-- ============================================================
--   INSERTAR SUPERMERCADOS
-- ============================================================
INSERT INTO supermercado (nombre) VALUES
('Mercadona'),
('Carrefour'),
('Lidl'),
('Bonpreu'),
('Aldi');

-- ============================================================
--   INSERTAR REGISTROS DE PRECIOS
-- ============================================================
INSERT INTO registro_precio (id_supermercado, id_producto, id_usuario, fecha, precio) VALUES
(1, 1, 1, '2024-01-10', 2.30),   -- Tomate en Mercadona
(2, 1, 2, '2024-01-11', 2.10),   -- Tomate en Carrefour
(3, 1, 1, '2024-01-12', 1.95),   -- Tomate en Lidl

(1, 2, 1, '2024-01-10', 0.95),   -- Leche en Mercadona
(4, 2, 3, '2024-01-11', 1.05),   -- Leche en Bonpreu

(2, 3, 2, '2024-01-09', 1.80),   -- Manzana en Carrefour
(3, 3, 1, '2024-01-10', 1.60),   -- Manzana en Lidl

(5, 4, 1, '2024-01-08', 1.20),   -- Arroz en Aldi
(1, 4, 2, '2024-01-09', 1.10),   -- Arroz en Mercadona

(4, 5, 3, '2024-01-07', 2.50),   -- Huevos en Bonpreu
(2, 5, 1, '2024-01-08', 2.30),   -- Huevos en Carrefour

(1, 6, 1, '2024-01-05', 5.20),   -- Aceite en Mercadona
(3, 6, 2, '2024-01-06', 4.95);   -- Aceite en Lidl
