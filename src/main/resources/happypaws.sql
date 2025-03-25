DROP DATABASE IF EXISTS peluqueria;
CREATE DATABASE peluqueria;
USE peluqueria;

CREATE TABLE cliente(
	id_cliente INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefono CHAR(9) NOT NULL
);

CREATE TABLE peluquero(
	id_peluquero INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefono CHAR(9) NOT NULL
);

CREATE TABLE mascota (
    id_mascota INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    tamanio ENUM('Pequeño', 'Mediano', 'Grande') NOT NULL,
    id_cliente INT,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente) ON DELETE CASCADE
);

CREATE TABLE cita (
    id_cita INT PRIMARY KEY AUTO_INCREMENT,
    id_mascota INT,
    id_peluquero INT,
    fecha_hora DATETIME NOT NULL,
    estado ENUM('Pendiente', 'Completada', 'Cancelada') NOT NULL,
    observaciones TEXT,
    FOREIGN KEY (id_mascota) REFERENCES mascota(id_mascota) ON DELETE CASCADE,
    FOREIGN KEY (id_peluquero) REFERENCES peluquero(id_peluquero) ON DELETE CASCADE
);

CREATE TABLE servicios (
    id_servicio INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    descripcion TEXT
);

CREATE TABLE cita_servicio (
    id_cita INT,
    id_servicio INT,
    PRIMARY KEY (id_cita, id_servicio),
    FOREIGN KEY (id_cita) REFERENCES cita(id_cita) ON DELETE CASCADE,
    FOREIGN KEY (id_servicio) REFERENCES servicio(id_servicio) ON DELETE CASCADE
);