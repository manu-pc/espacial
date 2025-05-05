DROP TABLE IF EXISTS Colaboracion;
DROP TABLE IF EXISTS Artículo;
DROP TABLE IF EXISTS EntradaForo;
DROP TABLE IF EXISTS Administrador;
DROP TABLE IF EXISTS Cientifico;
DROP TABLE IF EXISTS Estudiante;
DROP TABLE IF EXISTS Aficionado;
DROP TABLE IF EXISTS Usuario;
DROP TABLE IF EXISTS ParticiparMision;
DROP TABLE IF EXISTS Mision;
DROP TABLE IF EXISTS PertenecerAgencia;
DROP TABLE IF EXISTS Agencia;
DROP TABLE IF EXISTS Astronauta;
DROP TABLE IF EXISTS Nave;
DROP TABLE IF EXISTS OrbitaAlrededor;
DROP TABLE IF EXISTS CuerpoCeleste;
DROP TABLE IF EXISTS Galaxia;

CREATE TABLE Galaxia(
    nombre VARCHAR(50) PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    ubicacion VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255) NOT NULL
);

CREATE TABLE CuerpoCeleste (
    nombre VARCHAR(50) PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    -- planeta, estrella, luna, asteroide
    ubicacion VARCHAR(50) NOT NULL,
    habitabilidad BOOLEAN NOT NULL,
    -- boolean é raro pero lol
    masa float NOT NULL,
    --kg
    tamano float NOT NULL,
    --metros
    temperaturaSuperficie float NOT NULL,
    --grados Celsius
    descripcion VARCHAR(255) NOT NULL,
    --
    galaxia VARCHAR(50) NOT NULL,
    FOREIGN KEY (galaxia) REFERENCES Galaxia(nombre) ON DELETE NO ACTION ON UPDATE CASCADE
);

CREATE TABLE OrbitaAlrededor(
    orbitador VARCHAR(50) NOT NULL,
    orbitaA VARCHAR(50) NOT NULL,
    diametro float NOT NULL,
    --km
    periodo float NOT NULL,
    --dias
    FOREIGN KEY (orbitador) REFERENCES CuerpoCeleste(nombre) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (orbitaA) REFERENCES CuerpoCeleste(nombre) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (orbitador, orbitaA)
);
CREATE TABLE Nave(
    id INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    -- satélite, exploración, transporte
    tamano float NOT NULL,
    --metros
    masa float NOT NULL --kg
);
CREATE TABLE Astronauta(
    id int PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    nacionalidad VARCHAR(50) NOT NULL,
    fechaNacimiento DATE NOT NULL
);
CREATE TABLE Agencia(
    id INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    localizacion VARCHAR(50) NOT NULL -- para evitar trigger, num_astronautas irá nunha vista
);
CREATE TABLE PertenecerAgencia(
    fechaInicio DATE NOT NULL,
    fechaFin DATE,
    astronauta_id INT NOT NULL,
    agencia_id INT NOT NULL,
    FOREIGN KEY (astronauta_id) REFERENCES Astronauta(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (agencia_id) REFERENCES Agencia(id) ON DELETE NO ACTION ON UPDATE CASCADE,
    PRIMARY KEY (astronauta_id, agencia_id, fechaInicio)
);
CREATE TABLE Mision(
    codigo INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    fechaInicio DATE NOT NULL,
    fechaFin DATE,
    descripcion VARCHAR(255) NOT NULL,
    nave INT NOT NULL,
    objetivo VARCHAR(50) NOT NULL,
    FOREIGN KEY (nave) REFERENCES Nave(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (objetivo) REFERENCES CuerpoCeleste(nombre) ON DELETE NO ACTION ON UPDATE CASCADE
);
CREATE TABLE ParticiparMision(
    mision INT NOT NULL,
    astronauta INT NOT NULL,
    FOREIGN KEY (mision) REFERENCES Mision(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (astronauta) REFERENCES Astronauta(id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE Usuario(
    id VARCHAR(50) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    clave VARCHAR(50) NOT NULL
);
CREATE TABLE Aficionado(
    id VARCHAR(50) PRIMARY KEY,
    tier VARCHAR(20) NOT NULL,
    FOREIGN KEY (id) REFERENCES Usuario(id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE Estudiante(
     id VARCHAR(50) PRIMARY KEY,
    centro VARCHAR(50) NOT NULL,
    num_est INT NOT NULL,
    -- qué coño é num_est?
    FOREIGN KEY (id) REFERENCES Usuario(id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE Cientifico(
     id VARCHAR(50) PRIMARY KEY,
    centro VARCHAR(50) NOT NULL,
    -- para evitar trigger, num_articulos irá nunha vista
    FOREIGN KEY (id) REFERENCES Usuario(id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE Administrador(
    id VARCHAR(50) PRIMARY KEY,
    rango VARCHAR(50) NOT NULL,
    FOREIGN KEY (id) REFERENCES Usuario(id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE EntradaForo(
    numeroEntrada INT GENERATED ALWAYS AS IDENTITY,
    autor VARCHAR(50) NOT NULL,
    fecha DATE NOT NULL,
    titulo VARCHAR(50) NOT NULL,
    contenido VARCHAR(1024) NOT NULL,
    FOREIGN KEY (autor) REFERENCES Usuario(id) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (numeroEntrada, autor)
);
CREATE TABLE Artículo(
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    fechaPublicacion DATE NOT NULL,
    autor VARCHAR(50) NOT NULL,
    cuerpo VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    numPaginas INT NOT NULL,
    FOREIGN KEY (autor) REFERENCES Cientifico(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (cuerpo) REFERENCES CuerpoCeleste(nombre) ON DELETE NO ACTION ON UPDATE CASCADE
);
CREATE TABLE Colaboracion(
    fechaInicio DATE NOT NULL,
    fechaFin DATE,
    cientifico INT NOT NULL,
    agencia INT NOT NULL,
    FOREIGN KEY (cientifico) REFERENCES Cientifico(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (agencia) REFERENCES Agencia(id) ON DELETE NO ACTION ON UPDATE CASCADE,
    PRIMARY KEY (cientifico, agencia, fechaInicio)
);
