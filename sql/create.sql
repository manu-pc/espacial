DROP TABLE IF EXISTS Colaboracion CASCADE;
DROP TABLE IF EXISTS Articulo CASCADE;
DROP TABLE IF EXISTS EntradaForo CASCADE;
DROP TABLE IF EXISTS Administrador CASCADE;
DROP TABLE IF EXISTS Estudiante CASCADE;
DROP TABLE IF EXISTS Aficionado CASCADE;
DROP TABLE IF EXISTS ParticiparMision CASCADE;
DROP TABLE IF EXISTS Mision CASCADE;
DROP TABLE IF EXISTS PertenecerAgencia CASCADE;
DROP TABLE IF EXISTS Agencia CASCADE;
DROP TABLE IF EXISTS Astronauta CASCADE;
DROP TABLE IF EXISTS Nave CASCADE;
DROP TABLE IF EXISTS CuerpoCeleste CASCADE;
DROP TABLE IF EXISTS Galaxia CASCADE;
DROP TABLE IF EXISTS Cientifico CASCADE;
DROP TABLE IF EXISTS Usuario CASCADE;

CREATE TABLE Galaxia(
    nombre VARCHAR(50) PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    ubicacion VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255) NOT NULL
);

CREATE TABLE CuerpoCeleste (
    nombre VARCHAR(50) PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    ubicacion VARCHAR(50) NOT NULL,
    habitabilidad BOOLEAN NOT NULL,
    masa float NOT NULL,
    --kg
    tamano float NOT NULL,
    --metros
    temperaturaSuperficie float NOT NULL,
    --grados Celsius
    descripcion VARCHAR(255) NOT NULL,
    --
    galaxia VARCHAR(50) NOT NULL,
    orbitaA VARCHAR(50),
    FOREIGN KEY (galaxia) REFERENCES Galaxia(nombre) ON DELETE NO ACTION ON UPDATE CASCADE,
    FOREIGN KEY (orbitaA) references CuerpoCeleste(nombre) ON DELETE SET NULL ON UPDATE CASCADE
   
);



CREATE TABLE Nave(
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    -- satélite, exploración, transporte
    tamano float NOT NULL,
    --metros
    masa float NOT NULL --kg
);
CREATE TABLE Astronauta(
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    nacionalidad VARCHAR(50) NOT NULL,
    fechaNacimiento DATE NOT NULL
);
CREATE TABLE Agencia(
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
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
    codigo INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
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
    clave VARCHAR(60) NOT NULL
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
CREATE TABLE Articulo(
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
    cientifico VARCHAR(50) NOT NULL,
    agencia INT NOT NULL,
    FOREIGN KEY (cientifico) REFERENCES Cientifico(id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (agencia) REFERENCES Agencia(id) ON DELETE NO ACTION ON UPDATE CASCADE,
    PRIMARY KEY (cientifico, agencia, fechaInicio)
);
