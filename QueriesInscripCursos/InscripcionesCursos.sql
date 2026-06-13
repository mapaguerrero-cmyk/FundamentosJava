USE inscripcionescursos;
-- Insertar estudiantes
INSERT INTO estudiantes (nombre, edad) VALUES
('Ana González', 22),
('Luis Pérez', 25),
('María Rodríguez', 20),
('Carlos López', 24),
('Elena Martínez', 23),
('Loreto Vargas', 25),
('Carola Guerreo', 26);

-- Insertar cursos
INSERT INTO cursos (nombre, duracion) VALUES
('Java Básico', 40),
('Spring Framework', 60),
('MySQL Avanzado', 35),
('HTML y CSS', 25);

INSERT INTO cursos (nombre, duracion) VALUES
('Musica en piano', 200),
('Cocina tipica', 80);

-- Revisar lo insertado
SELECT * FROM estudiantes;
SELECT * FROM cursos;

INSERT INTO inscripciones (estudiantes_id_estudiante, cursos_id_curso, fecha) VALUES
-- Ana (1) → Java (1) y Spring (2)
(1, 1, '2026-06-10'),
(1, 2, '2026-06-10'),
-- Luis (2) → Java (1) y MySQL (3)
(2, 1, '2026-06-09'),
(2, 3, '2026-06-09'),
-- María (3) → Spring (2) y HTML (4)
(3, 2, '2026-06-08'),
(3, 4, '2026-06-08'),
-- Elena (5) → Spring (2) y HTML (4)
(5, 2, '2026-06-06'),
(5, 4, '2026-06-06'),
-- Loreto (6) → Música (5) y Cocina (6)
(6, 5, '2026-06-11'),
(6, 6, '2026-06-11'),
-- Carola (7) → Música (5) y Cocina (6)
(7, 5, '2026-06-11'),
(7, 6, '2026-06-11');

SELECT * FROM inscripciones;
-- Proyecta a todos los estudiantes y sus respectivos cursos.
SELECT 
    e.id_estudiante,
    e.nombre,
    e.edad,
    c.id_curso,
    c.nombre AS curso_nombre,
    c.duracion
FROM estudiantes e
LEFT JOIN inscripciones i ON e.id_estudiante = i.estudiantes_id_estudiante
LEFT JOIN cursos c ON i.cursos_id_curso = c.id_curso
ORDER BY e.id_estudiante;

-- Proyecta todos los estudiantes que están inscritos en un curso específico.
SELECT 
    e.id_estudiante,
    e.nombre,
    e.edad,
    c.nombre
FROM estudiantes e
INNER JOIN inscripciones i ON e.id_estudiante = i.estudiantes_id_estudiante
INNER JOIN cursos c ON i.cursos_id_curso = c.id_curso
WHERE c.nombre = 'Java Básico';

-- Proyecta todos los cursos en los que está inscrito un estudiante específico
SELECT 
    c.id_curso,
    c.nombre AS curso_nombre,
    c.duracion,
    i.fecha
FROM cursos c
INNER JOIN inscripciones i ON c.id_curso = i.cursos_id_curso
INNER JOIN estudiantes e ON i.estudiantes_id_estudiante = e.id_estudiante
WHERE e.nombre = 'Ana González';

-- Proyecta todos los estudiantes que están inscritos en una lista de cursos específicos.
SELECT 
    e.id_estudiante,
    e.nombre,
    e.edad,
    c.nombre
FROM estudiantes e
INNER JOIN inscripciones i ON e.id_estudiante = i.estudiantes_id_estudiante
INNER JOIN cursos c ON i.cursos_id_curso = c.id_curso
WHERE c.nombre in('Java Básico', 'Spring Framework');

-- Cuenta el número de estudiantes inscritos en cada curso y muestra el nombre del curso junto con el número de estudiantes inscritos.
SELECT 
    c.nombre AS curso,
    COUNT(DISTINCT i.estudiantes_id_estudiante) AS total_estudiantes
FROM cursos c
LEFT JOIN inscripciones i ON c.id_curso = i.cursos_id_curso
GROUP BY c.id_curso, c.nombre
ORDER BY total_estudiantes DESC;

-- Encuentra los estudiantes que no están inscritos en ningún curso.
SELECT 
    e.id_estudiante,
    e.nombre,
    e.edad
FROM estudiantes e
LEFT JOIN inscripciones i ON e.id_estudiante = i.estudiantes_id_estudiante
WHERE i.estudiantes_id_estudiante IS NULL;




