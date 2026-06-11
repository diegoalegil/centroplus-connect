PRAGMA foreign_keys = ON;

-- creación de las entidades para pruebas

INSERT INTO usuarios (id, nombre, dni, email, telefono, tipo_usuario)
VALUES
(1, 'Ana Pérez', '11111111A', 'ana@email.com', '600111111', 'ALUMNO'),
(2, 'Diego Gil', '43353363V', 'diegogildam@gmail.com', '666000666', 'SOCIO'),
(3, 'Darimar Marcano', '56676686H', 'darimardam@gmail.com', '666111666', 'AMBOS');

INSERT INTO actividades (id, nombre, tipo_actividad, duracion, precio, plazas_maximas, plazas_ocupadas)
VALUES
(1, 'Yoga', 'DEPORTIVA', 60, 25.50, 15, 8),
(2, 'Programación Java', 'ACADEMICA', 90, 40.00, 20, 12),
(3, 'Spinning', 'DEPORTIVA', 45, 18.00, 12, 12),
(4, 'Inglés técnico', 'ACADEMICA', 60, 30.00, 18, 6),
(5, 'Sistemas Linux', 'ACADEMICA', 120, 45.00, 16, 10);

INSERT INTO reservas (id, id_usuario, id_actividad, fecha, estado)
VALUES
(1, 1, 1, '2025-01-10', 'ACTIVA'),
(2, 2, 2, '2026-06-08', 'ACTIVA');

INSERT INTO incidencias (id, id_usuario, asunto, descripcion, fecha, estado)
VALUES
(1, 1, 'Problema con reserva', 'No puedo reservar una plaza', '2025-01-12', 'ABIERTA'),
(2, 2, 'Aire acondicionado del aula de programación', 'El aire del aula está demasiado frío y no deja cambiar la temperatura, o nos congelamos o nos morimos de calor', '2026-06-09', 'ABIERTA'),
(3, 3, 'Papel del baño de baja calidad', 'El papel del baño lastima a la hora de hacer necesidades o intentar secarse las manos', '2026-06-10', 'EN_PROCESO');
