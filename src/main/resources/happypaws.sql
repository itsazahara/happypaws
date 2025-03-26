-- Insertar datos en la tabla cliente
INSERT INTO cliente (id, nombre, email, telefono) VALUES
(1, 'Juan Pérez', 'juan.perez@email.com', '123456789'),
(2, 'Ana García', 'ana.garcia@email.com', '987654321'),
(3, 'Carlos López', 'carlos.lopez@email.com', '456123789'),
(4, 'María Rodríguez', 'maria.rodriguez@email.com', '789456123'),
(5, 'Pedro Sánchez', 'pedro.sanchez@email.com', '321654987'),
(6, 'Laura Fernández', 'laura.fernandez@email.com', '654987321'),
(7, 'David Martínez', 'david.martinez@email.com', '147258369'),
(8, 'Sofía Torres', 'sofia.torres@email.com', '369258147'),
(9, 'Javier Gómez', 'javier.gomez@email.com', '258147369'),
(10, 'Elena Ruiz', 'elena.ruiz@email.com', '159357486'),
(11, 'Miguel Castro', 'miguel.castro@email.com', '357159486'),
(12, 'Carmen Ortega', 'carmen.ortega@email.com', '951753468'),
(13, 'Raúl Herrera', 'raul.herrera@email.com', '753951468'),
(14, 'Patricia Díaz', 'patricia.diaz@email.com', '852963741'),
(15, 'Fernando Vega', 'fernando.vega@email.com', '963852741'),
(16, 'Lucía Jiménez', 'lucia.jimenez@email.com', '741852963'),
(17, 'Alberto Navarro', 'alberto.navarro@email.com', '852741963'),
(18, 'Marta Paredes', 'marta.paredes@email.com', '369741852'),
(19, 'Daniel Esteban', 'daniel.esteban@email.com', '147369852'),
(20, 'Verónica Montes', 'veronica.montes@email.com', '258369741');

-- Insertar datos en la tabla peluquero
INSERT INTO peluquero (id, nombre, email, telefono) VALUES
(1, 'Luis Moreno', 'luis.moreno@email.com', '654123987'),
(2, 'Clara Ríos', 'clara.rios@email.com', '321987654'),
(3, 'Pablo Navas', 'pablo.navas@email.com', '789654123'),
(4, 'Andrea Vargas', 'andrea.vargas@email.com', '987321654'),
(5, 'Roberto Suárez', 'roberto.suarez@email.com', '123987654'),
(6, 'Natalia León', 'natalia.leon@email.com', '741963852'),
(7, 'Esteban Fuentes', 'esteban.fuentes@email.com', '963741852'),
(8, 'Carolina Méndez', 'carolina.mendez@email.com', '852147963'),
(9, 'José Ramírez', 'jose.ramirez@email.com', '159486357'),
(10, 'Beatriz López', 'beatriz.lopez@email.com', '357486159'),
(11, 'Ángel Domínguez', 'angel.dominguez@email.com', '753468951'),
(12, 'Francisco Peña', 'francisco.pena@email.com', '468951753'),
(13, 'Sandra Castillo', 'sandra.castillo@email.com', '852741369'),
(14, 'Antonio Romero', 'antonio.romero@email.com', '741369852'),
(15, 'Raquel Alonso', 'raquel.alonso@email.com', '369852741'),
(16, 'Diego Espinoza', 'diego.espinoza@email.com', '147852963'),
(17, 'Silvia Cabrera', 'silvia.cabrera@email.com', '258963741'),
(18, 'Hugo Ortiz', 'hugo.ortiz@email.com', '369741258'),
(19, 'Paula Ramos', 'paula.ramos@email.com', '147258963'),
(20, 'Adrián Flores', 'adrian.flores@email.com', '258147369');

-- Insertar datos en la tabla mascota
INSERT INTO mascota (nombre, tamanio, id_cliente) VALUES
('Max', 'Mediano', 1), ('Bella', 'Pequeño', 2), ('Luna', 'Grande', 3),
('Rocky', 'Mediano', 4), ('Toby', 'Pequeño', 5), ('Milo', 'Grande', 6),
('Nala', 'Mediano', 7), ('Simba', 'Pequeño', 8), ('Coco', 'Grande', 9),
('Daisy', 'Mediano', 10), ('Bruno', 'Pequeño', 11), ('Sasha', 'Grande', 12),
('Chico', 'Mediano', 13), ('Maggie', 'Pequeño', 14), ('Duke', 'Grande', 15),
('Rex', 'Mediano', 16), ('Loki', 'Pequeño', 17), ('Oreo', 'Grande', 18),
('Zeus', 'Mediano', 19), ('Lulu', 'Pequeño', 20);

-- Insertar datos en la tabla cita
INSERT INTO cita (id_mascota, id_peluquero, id_cliente, fecha_hora, estado, observaciones) VALUES
(1, 2, 2, '2025-04-01 10:00:00', 'Pendiente', 'Corte de pelo básico'),
(2, 3, 3, '2025-04-02 11:00:00', 'Pendiente', 'Baño y peinado'),
(3, 4, 4, '2025-04-03 09:00:00', 'Pendiente', 'Limpieza de oídos y uñas'),
(4, 5, 5, '2025-04-04 15:00:00', 'Pendiente', 'Baño completo'),
(5, 6, 6, '2025-04-05 14:30:00', 'Pendiente', 'Desenredado de pelaje'),
(6, 7, 7, '2025-04-06 12:00:00', 'Pendiente', 'Corte especializado'),
(7, 8, 8, '2025-04-07 13:00:00', 'Pendiente', 'Tratamiento antipulgas'),
(8, 9, 9, '2025-04-08 16:00:00', 'Pendiente', 'Corte de uñas'),
(9, 10, 10, '2025-04-09 17:00:00', 'Pendiente', 'Cepillado especial'),
(10, 11, 11, '2025-04-10 10:00:00', 'Pendiente', 'Corte y baño'),
(11, 12, 12, '2025-04-11 11:00:00', 'Pendiente', 'Corte básico'),
(12, 13, 13, '2025-04-12 12:00:00', 'Pendiente', 'Baño y corte de uñas'),
(13, 14, 14, '2025-04-13 14:00:00', 'Pendiente', 'Baño medicinal'),
(14, 15, 15, '2025-04-14 15:00:00', 'Pendiente', 'Hidratación de piel'),
(15, 16, 16, '2025-04-15 16:00:00', 'Pendiente', 'Cepillado de dientes'),
(16, 17, 17, '2025-04-16 17:00:00', 'Pendiente', 'Corte y lavado especial'),
(17, 18, 18, '2025-04-17 10:30:00', 'Pendiente', 'Baño completo'),
(18, 19, 19, '2025-04-18 11:30:00', 'Pendiente', 'Peinado especial'),
(19, 20, 20, '2025-04-19 12:30:00', 'Pendiente', 'Baño relajante'),
(20, 1,  1, '2025-04-20 13:30:00', 'Pendiente', 'Corte de pelo general');

-- Insertar datos en la tabla servicio
INSERT INTO servicio (id, nombre, descripcion, precio) VALUES
(1, 'Corte de Pelo Básico', 'Corte de pelo estándar para perros de cualquier tamaño', 15.00),
(2, 'Baño y Peinado', 'Baño con shampoo especial y peinado para mascotas', 20.00),
(3, 'Limpieza de Oídos y Uñas', 'Limpieza profunda de oídos y corte de uñas', 12.00),
(4, 'Baño Completo', 'Baño con shampoo medicado y secado especial', 25.00),
(5, 'Desenredado de Pelaje', 'Cepillado y desenredado para razas con pelaje largo', 18.00),
(6, 'Corte Especializado', 'Corte de pelo según raza y preferencias del dueño', 30.00),
(7, 'Tratamiento Antipulgas', 'Aplicación de tratamiento antiparasitario', 22.00),
(8, 'Corte de Uñas', 'Corte seguro de uñas con limado incluido', 10.00),
(9, 'Cepillado Especial', 'Cepillado profundo para eliminar pelo muerto', 15.00),
(10, 'Baño Medicinal', 'Baño con productos específicos para piel sensible', 28.00),
(11, 'Hidratación de Piel', 'Tratamiento de hidratación para piel seca o irritada', 20.00),
(12, 'Cepillado de Dientes', 'Limpieza bucal con cepillo y pasta especial para mascotas', 12.00),
(13, 'Corte y Lavado Especial', 'Corte de pelo con lavado premium', 35.00),
(14, 'Peinado Especial', 'Peinado con accesorios y perfumes para mascotas', 18.00),
(15, 'Baño Relajante', 'Baño con aromaterapia y masaje relajante', 30.00),
(16, 'Corte de pelo básico para perros y gatos', 'Corte básico', 15.00),
(17, 'Baño con champú especial para mascotas', 'Baño', 20.00),
(18, 'Limpieza de oídos y corte de uñas', 'Higiene completa', 25.00),
(19, 'Tratamiento antipulgas y desparasitación', 'Antipulgas', 30.00),
(20, 'Cepillado y desenredado de pelaje', 'Cepillado especial', 18.00);

-- Insertar datos en la tabla cita_servicio
INSERT INTO cita_servicio (id_cita, id_servicio) VALUES
(1, 3),
(1, 5),
(2, 1),
(2, 6),
(3, 2),
(3, 4),
(4, 7),
(4, 10),
(5, 8),
(5, 12),
(6, 9),
(6, 15),
(7, 11),
(7, 13),
(8, 14),
(9, 2),
(10, 5),
(11, 7),
(12, 10),
(13, 12);