-- ===============================
-- = DATOS DE EJEMPLO
-- = Sistema de Lotería - Konex Innovation
-- ===============================

-- Insertar Sorteos de ejemplo
INSERT INTO sorteos (nombre, fecha, fecha_creacion) VALUES
('Lotería Nacional - Diciembre 2025', '2025-12-25', CURRENT_DATE),
('Baloto - Edición Especial Año Nuevo', '2025-12-31', CURRENT_DATE),
('Chance Millonario', '2025-12-15', CURRENT_DATE),
('Lotería de Bogotá', '2025-12-20', CURRENT_DATE);

-- Insertar Clientes de ejemplo
INSERT INTO clientes (nombre, email, fecha_registro) VALUES
('Juan Pérez García', 'juan.perez@example.com', CURRENT_DATE),
('María González López', 'maria.gonzalez@example.com', CURRENT_DATE),
('Carlos Rodríguez Méndez', 'carlos.rodriguez@example.com', CURRENT_DATE),
('Ana Martínez Silva', 'ana.martinez@example.com', CURRENT_DATE),
('Pedro Sánchez Torres', 'pedro.sanchez@example.com', CURRENT_DATE);

-- Insertar Billetes para Lotería Nacional (Sorteo ID: 1)
-- Billetes vendidos
INSERT INTO billetes (numero, precio, estado, sorteo_id, cliente_id, fecha_venta, fecha_creacion) VALUES
('0001', 10000.00, 'VENDIDO', 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('0002', 10000.00, 'VENDIDO', 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('0003', 10000.00, 'VENDIDO', 1, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('0004', 10000.00, 'VENDIDO', 1, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('0005', 10000.00, 'VENDIDO', 1, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Billetes disponibles
INSERT INTO billetes (numero, precio, estado, sorteo_id, cliente_id, fecha_venta, fecha_creacion) VALUES
('0006', 10000.00, 'DISPONIBLE', 1, NULL, NULL, CURRENT_TIMESTAMP),
('0007', 10000.00, 'DISPONIBLE', 1, NULL, NULL, CURRENT_TIMESTAMP),
('0008', 10000.00, 'DISPONIBLE', 1, NULL, NULL, CURRENT_TIMESTAMP),
('0009', 10000.00, 'DISPONIBLE', 1, NULL, NULL, CURRENT_TIMESTAMP),
('0010', 10000.00, 'DISPONIBLE', 1, NULL, NULL, CURRENT_TIMESTAMP),
('0011', 10000.00, 'DISPONIBLE', 1, NULL, NULL, CURRENT_TIMESTAMP),
('0012', 10000.00, 'DISPONIBLE', 1, NULL, NULL, CURRENT_TIMESTAMP);

-- Insertar Billetes para Baloto (Sorteo ID: 2)
INSERT INTO billetes (numero, precio, estado, sorteo_id, cliente_id, fecha_venta, fecha_creacion) VALUES
('B0001', 15000.00, 'VENDIDO', 2, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('B0002', 15000.00, 'VENDIDO', 2, 4, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('B0003', 15000.00, 'DISPONIBLE', 2, NULL, NULL, CURRENT_TIMESTAMP),
('B0004', 15000.00, 'DISPONIBLE', 2, NULL, NULL, CURRENT_TIMESTAMP),
('B0005', 15000.00, 'DISPONIBLE', 2, NULL, NULL, CURRENT_TIMESTAMP),
('B0006', 15000.00, 'DISPONIBLE', 2, NULL, NULL, CURRENT_TIMESTAMP);

-- Insertar Billetes para Chance Millonario (Sorteo ID: 3)
INSERT INTO billetes (numero, precio, estado, sorteo_id, cliente_id, fecha_venta, fecha_creacion) VALUES
('C0001', 5000.00, 'VENDIDO', 3, 5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('C0002', 5000.00, 'DISPONIBLE', 3, NULL, NULL, CURRENT_TIMESTAMP),
('C0003', 5000.00, 'DISPONIBLE', 3, NULL, NULL, CURRENT_TIMESTAMP),
('C0004', 5000.00, 'DISPONIBLE', 3, NULL, NULL, CURRENT_TIMESTAMP),
('C0005', 5000.00, 'DISPONIBLE', 3, NULL, NULL, CURRENT_TIMESTAMP),
('C0006', 5000.00, 'DISPONIBLE', 3, NULL, NULL, CURRENT_TIMESTAMP),
('C0007', 5000.00, 'DISPONIBLE', 3, NULL, NULL, CURRENT_TIMESTAMP),
('C0008', 5000.00, 'DISPONIBLE', 3, NULL, NULL, CURRENT_TIMESTAMP);

-- Insertar Billetes para Lotería de Bogotá (Sorteo ID: 4)
INSERT INTO billetes (numero, precio, estado, sorteo_id, cliente_id, fecha_venta, fecha_creacion) VALUES
('L0001', 12000.00, 'DISPONIBLE', 4, NULL, NULL, CURRENT_TIMESTAMP),
('L0002', 12000.00, 'DISPONIBLE', 4, NULL, NULL, CURRENT_TIMESTAMP),
('L0003', 12000.00, 'DISPONIBLE', 4, NULL, NULL, CURRENT_TIMESTAMP),
('L0004', 12000.00, 'DISPONIBLE', 4, NULL, NULL, CURRENT_TIMESTAMP),
('L0005', 12000.00, 'DISPONIBLE', 4, NULL, NULL, CURRENT_TIMESTAMP);

-- ===============================
-- = RESUMEN DE DATOS
-- ===============================
-- 4 Sorteos
-- 5 Clientes
-- 40 Billetes totales:
--   - 8 Billetes VENDIDOS
--   - 32 Billetes DISPONIBLES
-- ===============================