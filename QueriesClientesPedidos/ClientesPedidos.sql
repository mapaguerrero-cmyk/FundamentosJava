USE clientes_pedidos;

-- Insertar clientes
INSERT INTO clientes (nombre, direccion, telefono) VALUES
('Ana González', 'Calle Duble 123, Santiago', '912345678'),
('Luis Pérez', 'Av. Siempre Viva 742, Valparaíso', '987654321'),
('María Rodríguez', 'Los Pinos 456, Concepción', '911223344'),
('Carlos López', 'Plaza Mayor 789, La Serena', '955667788'),
('Elena Martínez', 'Calle Luna 321, Antofagasta', '999887766');

SELECT * FROM clientes;

INSERT INTO pedidos (clientes_id_cliente, fecha, total) VALUES
(1, '2026-06-01', 15000.00),
(1, '2026-06-05', 25000.00),
(2, '2026-06-02', 8900.00),
(2, '2026-06-07', 12000.00),
(2, '2026-06-10', 3500.00),
(3, '2026-06-03', 45000.00),
(4, '2026-06-04', 6700.00),
(4, '2026-06-08', 8900.00),
(5, '2026-06-06', 23000.00),
(5, '2026-06-09', 12500.00);

-- Proyecta todos los clientes de la tabla «clientes» y sus respectivos pedidos.
SELECT c.id_cliente,c.nombre, c.direccion, p.id_pedido, p.fecha, p.total FROM clientes c LEFT JOIN pedidos p ON id_cliente = p.clientes_id_cliente;

-- Proyecta todos los pedidos realizados por un cliente específico, utilizando su ID.
SELECT * FROM pedidos WHERE clientes_id_cliente=2;

SELECT * FROM pedidos WHERE clientes_id_cliente=1;

SELECT * FROM pedidos WHERE clientes_id_cliente=3;

-- Calcula el total de todos los pedidos para cada cliente
SELECT c.id_cliente, c.nombre, SUM(p.total) AS total_Cliente 
FROM clientes c LEFT JOIN pedidos p ON c.id_cliente = p.clientes_id_cliente
GROUP BY c.id_cliente, c.nombre;

-- eliminar al cliente con id_cliente = 5 (Elena Martínez)
-- 1. Ver los pedidos de Elena (cliente id=5) antes de borrarlos
SELECT * FROM pedidos WHERE clientes_id_cliente = 5;
-- 2. Eliminar los pedidos de Elena
DELETE FROM pedidos WHERE clientes_id_cliente = 5;
-- 3. Eliminar de clientes a id_cliente = 5 (Elena Martínez)
SELECT * FROM clientes WHERE id_cliente= 5;-- Consulto antes de borrar
DELETE FROM clientes WHERE id_cliente= 5;

-- Proyecta los tres clientes que han realizado más pedidos, ordenados de forma descendente
SELECT 
    c.id_cliente, 
    c.nombre, 
    COUNT(p.id_pedido) AS cantidad_pedidos
FROM clientes c
LEFT JOIN pedidos p ON c.id_cliente = p.clientes_id_cliente
GROUP BY c.id_cliente, c.nombre
ORDER BY cantidad_pedidos DESC;








