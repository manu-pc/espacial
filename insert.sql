-- galaxias
INSERT INTO Galaxia (nombre, tipo, ubicacion, descripcion) VALUES
('Vía Láctea', 'Espiral', 'Grupo Local', 'Galaxia espiral barrada donde se encuentra el Sistema Solar. Su nombre, que significa camino de leche, proviene de la mitología griega.'),
('Andrómeda', 'Espiral', 'Grupo Local', 'Galaxia espiral que se encuentra a 2.537 millones de años luz de la Tierra. Junto con la Vía Láctea, es la más grande del Grupo Local.'),
('Messier 87', 'Elíptica', 'Cúmulo de Virgo', 'Galaxia elíptica que se encuentra a 53 millones de años luz de la Tierra. Contiene un agujero negro supermasivo en su centro');

-- estrellas
INSERT INTO CuerpoCeleste (nombre, tipo, ubicacion, habitabilidad, masa, tamano, temperaturaSuperficie, descripcion, galaxia) VALUES
('Sol', 'estrella', 'Sistema Solar', FALSE, 1.989e30, 1.3927e9, 5505, 'Estrella principal del Sistema Solar. Hace posible la vida en la Tierra.', 'Vía Láctea'),
('Proxima Centauri', 'estrella', 'Sistema de Alpha Centauri', FALSE, 2.446e29, 2.0e8, 3042, 'Estrella enana roja cercana al Sol. Es una estrella fulgurante, con aumentos aleatorios de luminosidad.', 'Vía Láctea');

-- planetas
INSERT INTO CuerpoCeleste (nombre, tipo, ubicacion, habitabilidad, masa, tamano, temperaturaSuperficie, descripcion, galaxia) VALUES
('Tierra', 'planeta', 'Sistema Solar', TRUE, 5.972e24, 1.2742e7, 15, 'Planeta habitable con vida conocida. Es el planeta rocoso más grande del sistema solar.', 'Vía Láctea'),
('Marte', 'planeta', 'Sistema Solar', FALSE, 6.417e23, 6.779e6, -63, 'Planeta rojo con posibilidades de colonización. Su periodo de rotación, tamaño y ciclos estacionales son próximos a la Tierra.', 'Vía Láctea'),
('Júpiter', 'planeta', 'Sistema Solar', FALSE, 1.898e27, 1.429e8, -108, 'Gigante gaseoso con muchas lunas. Su masa es mayor que la de todos los demás planetas del Sistema Solar combinados.', 'Vía Láctea');

-- lunas
INSERT INTO CuerpoCeleste (nombre, tipo, ubicacion, habitabilidad, masa, tamano, temperaturaSuperficie, descripcion, galaxia) VALUES
('Luna', 'luna', 'Sistema Solar', FALSE, 7.342e22, 3.474e6, -53, 'Único satélite natural de la Tierra.', 'Vía Láctea'),
('Europa', 'luna', 'Sistema Solar', FALSE, 4.799e22, 3.121e6, -160, 'Luna de Júpiter con océano subterráneo.', 'Vía Láctea');


-- orbitas luna-planeta
INSERT INTO OrbitaAlrededor (orbitador, orbitaA, diametro, periodo) VALUES
('Luna', 'Tierra', 384400, 27.3),
('Europa', 'Júpiter', 670900, 3.5);

-- orbitas planeta-estrella
INSERT INTO OrbitaAlrededor (orbitador, orbitaA, diametro, periodo) VALUES
('Tierra', 'Sol', 149600000, 365.25),
('Marte', 'Sol', 227900000, 687),
('Júpiter', 'Sol', 778500000, 4331);

-- naves
INSERT INTO Nave (id, nombre, tipo, tamano, masa) VALUES
(1, 'Apollo 11', 'exploración', 30.0, 28801),  
(2, 'Vostok 1', 'exploración', 4.4, 4725),
(3, 'ISS', 'exploración', 109.0, 420000),     
(4, 'Crew Dragon', 'transporte', 8.1, 12055),
(5, 'Sputnik 1', 'exploración', 0.58, 83.6);

-- astronautas
INSERT INTO Astronauta (id, nombre, nacionalidad, fechaNacimiento) VALUES
(1, 'Neil Armstrong', 'Estados Unidos', '1930-08-05'),
(2, 'Buzz Aldrin', 'Estados Unidos', '1930-01-20'),
(3, 'Yuri Gagarin', 'URSS', '1934-03-09'),
(4, 'Valentina Tereshkova', 'URSS', '1937-03-06'),
(5, 'Peggy Whitson', 'Estados Unidos', '1960-02-09');

-- agencias
INSERT INTO Agencia (id, nombre, localizacion) VALUES
(1, 'NASA', 'Estados Unidos'),
(2, 'Roscosmos', 'Rusia');

-- astronautas-agencias usa
INSERT INTO PertenecerAgencia (fechaInicio, fechaFin, astronauta_id, agencia_id) VALUES
('1962-01-01', '1971-08-01', 1, 1),
('1963-10-17', '1972-07-01', 2, 1),
('1996-01-01', NULL, 5, 1);
-- astronautas-agencias urss
INSERT INTO PertenecerAgencia (fechaInicio, fechaFin, astronauta_id, agencia_id) VALUES
('1960-01-01', '1968-03-27', 3, 2),
('1962-03-01', '1968-03-27', 4, 2);

-- misiones
INSERT INTO Mision (codigo, nombre, fechaInicio, fechaFin, descripcion, nave, objetivo) VALUES
(101, 'Apolo 11', '1969-07-16', '1969-07-24', 'Primera misión tripulada que aterrizó en la Luna', 1, 'Luna'),
(102, 'Vostok 1', '1961-04-12', '1961-04-12', 'Primer vuelo espacial tripulado con Yuri Gagarin', 2, 'Tierra');
-- por ahora non meto a misión da ISS porque cal seria o 'objetivo'?


-- apolo 11
INSERT INTO ParticiparMision (mision, astronauta) VALUES
(101, 1), 
(101, 2);

-- vostok 1 (gagarin)
INSERT INTO ParticiparMision (mision, astronauta) VALUES
(102, 3);


--- USUARIOS (un de cada tipo)

INSERT INTO Usuario (id, nombre, email, clave) VALUES
(1, 'Laura Pérez', 'laura@gmail.com', 'clave123'),
(2, 'Carlos Martínez', 'carlos@gmail.com', 'segura456'),
(3, 'Ana Torres', 'ana@gmail.org', 'astro789'),
(4, 'David Ruiz', 'david@gmail.net', 'sudo000');

INSERT INTO Aficionado (id, tier) VALUES
(1, 'Principiante');

INSERT INTO Estudiante (id, centro, num_est) VALUES
(2, 'Universidade de Santiago de Compostela', 12345678); -- no en serio qué coño é num_est?

INSERT INTO Científico (id, centro) VALUES
(3, 'Centro Astronómico de Trevinca');

INSERT INTO Colaboracion (fechaInicio, fechaFin, científico, agencia) VALUES
('2023-01-01', NULL, 3, 1);

INSERT INTO Administrador (id, rango) VALUES
(4, 'Moderador');

-- a pagina de wikipedia de jupiter en catalán
INSERT INTO EntradaForo (autor, fecha, titulo, contenido) VALUES
(1, '2025-04-19', 'Júpiter', 'Júpiter és el cinquè planeta del sistema solar atenent la seva proximitat al Sol i el més gros de tots. Es tracta dun gegant gasós amb una massa equivalent a una mil·lèsima part de la massa del Sol o dues vegades i mitja la massa de tots els altres planetes del sistema solar junts. Júpiter, el tercer objecte natural més lluminós del cel nocturn, després de la Lluna i Venus, és conegut des de la prehistòria. Fou anomenat en honor de Júpiter, el déu suprem de la mitologia romana.');
INSERT INTO Artículo (fechaPublicacion, autor, cuerpo, descripcion, numPaginas) VALUES
('2025-03-01', 3, 'Marte', 'Análisis geoquímico de la superficie marciana recolectada por rovers.', 12);

