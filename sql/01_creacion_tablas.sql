-- ============================================================
--   BASE DE DATOS: RIPA (Registro Inteligente de Precios)
--   Script: 01_creacion_tablas.sql
--   Autor: Sara
--   Proyecto Intermodular 1º DAM
-- ============================================================

-- Crear tabla
CREATE DATABASE ripa;

-- Seleccionar la base de datos
USE ripa;

-- ============================================================
--   TABLA: USUARIO
-- ============================================================
CREATE TABLE usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    contrasenya CHAR(60) NOT NULL
);

-- ============================================================
--   TABLA: PRODUCTO
-- ============================================================
CREATE TABLE producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    unidad_medida VARCHAR(50) NOT NULL
);

-- ============================================================
--   TABLA: SUPERMERCADO
-- ============================================================
CREATE TABLE supermercado (
    id_supermercado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

-- ============================================================
--   TABLA: REGISTRO_PRECIO
-- ============================================================
CREATE TABLE registro_precio (
    id_registro INT AUTO_INCREMENT PRIMARY KEY,
    id_supermercado INT NOT NULL,
    id_producto INT NOT NULL,
    id_usuario INT NOT NULL,
    fecha DATE NOT NULL,
    precio DOUBLE NOT NULL CHECK (precio > 0),

    -- Claves foráneas
    CONSTRAINT fk_registro_supermercado
        FOREIGN KEY (id_supermercado)
        REFERENCES supermercado(id_supermercado)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT fk_registro_producto
        FOREIGN KEY (id_producto)
        REFERENCES producto(id_producto)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT fk_registro_usuario
        FOREIGN KEY (id_usuario)
        REFERENCES usuario(id_usuario)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);
