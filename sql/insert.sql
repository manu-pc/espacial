-- 1. GALAXIAS
INSERT INTO Galaxia (nombre, tipo, ubicacion, descripcion) VALUES
('Via Lactea', 'Espiral', 'Grupo Local', 'Galaxia espiral barrada donde se encuentra el Sistema Solar. Su nombre, que significa camino de leche, proviene de la mitología griega.'),
('Andromeda', 'Espiral', 'Grupo Local', 'Galaxia espiral que se encuentra a 2.537 millones de años luz de la Tierra. Junto con la Vía Láctea, es la más grande del Grupo Local.'),
('Messier 87', 'Eliptica', 'Cúmulo de Virgo', 'Galaxia elíptica que se encuentra a 53 millones de años luz de la Tierra. Contiene un agujero negro supermasivo en su centro');
-- 2. CUERPOS CELESTES
INSERT INTO CuerpoCeleste (
    nombre, tipo, ubicacion, habitabilidad, masa, tamano, temperaturaSuperficie, descripcion, galaxia, orbitaA
) VALUES (
    'Sol', 'Estrella', 'Centro del Sistema Solar', false, 1.989e30, 1391016, 5505,
    'Estrella principal del sistema solar', 'Via Lactea', NULL
),(
    'Júpiter', 'Planeta', 'Órbita del Sol', false, 1.898e27, 139820, -110,
    'Planeta más grande del sistema solar', 'Via Lactea', 'Sol'),
('Tierra', 'Planeta', 'Sistema Solar', true, 5.97e24, 12742, 15, 'Planeta habitable', 'Via Lactea', 'Sol'),
('Luna', 'Satelite', 'Órbita de la Tierra', false, 7.35e22, 3474, -20, 'Satélite natural de la Tierra', 'Via Lactea', 'Tierra');

-- 3. NAVES
INSERT INTO Nave (nombre, tipo, tamano, masa) VALUES
('Apollo 11', 'exploración', 30.0, 28801),  
('Vostok 1', 'exploración', 4.4, 4725),
('ISS', 'exploración', 109.0, 420000),     
('Crew Dragon', 'transporte', 8.1, 12055),
('Sputnik 1', 'exploración', 0.58, 83.6);

-- 4. ASTRONAUTAS
INSERT INTO Astronauta ( nombre, nacionalidad, fechaNacimiento) VALUES
('Neil Armstrong', 'Estados Unidos', '1930-08-05'),
('Buzz Aldrin', 'Estados Unidos', '1930-01-20'),
('Yuri Gagarin', 'URSS', '1934-03-09'),
('Valentina Tereshkova', 'URSS', '1937-03-06'),
('Peggy Whitson', 'Estados Unidos', '1960-02-09');

-- 5. AGENCIAS
INSERT INTO Agencia ( nombre, localizacion) VALUES
('NASA', 'Estados Unidos'),
('Roscosmos', 'Rusia');
INSERT INTO Agencia (nombre, localizacion) VALUES ('ESA', 'Europa');

-- 6. USUARIOS
INSERT INTO Usuario VALUES ('user1', 'Laura Gómez', 'laura@correo.com', '$2a$10$Qay2ERybK7w1exAmvqfeJeaS1y6N5Dtow4nkG7GZQNpD076pPpe/S');
INSERT INTO Usuario VALUES ('user2', 'Juan Pérez', 'juan@correo.com', '$2a$10$nJkq.Io9Wdvd0rKzG2uU1uIn1dMeeavZkRA4Iuu0junTBh0bMLqcK');
INSERT INTO Usuario VALUES ('user3', 'Elena Ruiz', 'elena@correo.com', '$2a$10$0r6Z6gCY.D/uC1Oo3NONK.ClAXhzuwkCDWocapLARXTCxWUgSIQ8K');
INSERT INTO Usuario VALUES ('admin1', 'Pepe Ramón', 'admin@admin.com', '$2a$10$pok2PY2NLcwb0w3nW/CMCO/oX2ktiACYMF2LFpUPH0KhKe2JF.ae2');

-- 7. ROLES DE USUARIO
INSERT INTO Aficionado VALUES ('user1', 'oro');
INSERT INTO Estudiante VALUES ('user2', 'IES Espacial', 12345);
INSERT INTO Cientifico VALUES ('user3', 'Centro Espacial Europeo');
INSERT INTO Administrador VALUES ('admin1', 'superusuario');

-- 8. PERTENENCIA A AGENCIA
INSERT INTO PertenecerAgencia VALUES ('1965-01-01', NULL, 1, 1); -- Neil en NASA
INSERT INTO PertenecerAgencia VALUES ('1965-01-01', NULL, 2, 1); -- Buzz en NASA

-- 9. MISIONES
INSERT INTO Mision ( nombre, fechaInicio, fechaFin, descripcion, nave, objetivo) VALUES
('Apolo 11', '1969-07-16', '1969-07-24', 'Primera misión tripulada que aterrizó en la Luna', 1, 'Luna'),
('Vostok 1', '1961-04-12', '1961-04-12', 'Primer vuelo espacial tripulado con Yuri Gagarin', 2, 'Tierra');

-- 10. PARTICIPACIÓN EN MISIONES
INSERT INTO ParticiparMision VALUES (1, 1);
INSERT INTO ParticiparMision VALUES (1, 2);

-- 11. ENTRADAS DE FORO
INSERT INTO EntradaForo (autor, fecha, titulo, contenido) VALUES 
('user1', '2024-01-01', '¿Vida en Marte?', '¿Creéis que hay vida en Marte?'),
('user2', '2024-02-15', 'Ayuda con telescopios', '¿Qué telescopio recomendáis para empezar?');

-- 12. ARTÍCULOS
INSERT INTO Articulo (fechaPublicacion, autor, cuerpo, descripcion, numPaginas) VALUES 
('2023-06-10', 'user3', 'Luna', 'Estudio geológico de la Luna', 12);

-- 13. COLABORACIONES
INSERT INTO Colaboracion VALUES ('2022-01-01', NULL, 'user3', 2); -- Científica colabora con ESA
