CREATE TABLE Galaxia(
    nombre VARCHAR(50) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    ubicacion VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255) NOT NULL
)

CREATE TABLE CuerpoCeleste (
    nombre VARCHAR(50) PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL, -- planeta, estrella, luna, asteroide
    ubicacion VARCHAR(50) NOT NULL,
    habitabilidad BOOLEAN NOT NULL,
    masa float NOT NULL, --kg
    tamano float NOT NULL, --metros
    temperaturaSuperficie float NOT NULL, --grados Celsius
    descripcion VARCHAR(255) NOT NULL, --
    galaxia VARCHAR(50) NOT NULL,
    FOREIGN KEY (galaxia) REFERENCES Galaxia(nombre)
    ON DELETE NO ACTION
    ON UPDATE CASCADE
)

CREATE TABLE OrbitaAlrededor(
    orbitador VARCHAR(50) NOT NULL,
    orbitaA VARCHAR(50) NOT NULL,
    diametro float NOT NULL, --km
    periodo float NOT NULL, --dias
    FOREIGN KEY (orbitador) REFERENCES CuerpoCeleste(nombre)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (orbitaA) REFERENCES CuerpoCeleste(nombre)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY (orbitador, orbitaA)

)

CREATE TABLE Nave(
    id INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    tipo VARCHAR(50) NOT NULL, -- satélite, exploración, transporte
    tamano float NOT NULL, --metros
    masa float NOT NULL, --kg
) 

CREATE TABLE Astronauta(
    id int PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    nacionalidad VARCHAR(50) NOT NULL,
    fechaNacimiento DATE NOT NULL,
)

CREATE TABLE Agencia(
    id INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    localizacion VARCHAR(50) NOT NULL,
    num_astronautas INT NOT NULL,
)

CREATE TABLE PertenecerAgencia(
    fechaInicio DATE NOT NULL,
    fechaFin DATE,
    astronauta_id INT NOT NULL,
    agencia_id INT NOT NULL,
    FOREIGN KEY (astronauta_id) REFERENCES Astronauta(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (agencia_id) REFERENCES Agencia(id)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    PRIMARY KEY (astronauta_id, agencia_id, fechaInicio)
)

CREATE TABLE Mision(
    codigo INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    fechaInicio DATE NOT NULL,
    fechaFin DATE,
    descripcion VARCHAR(255) NOT NULL,
    nave INT NOT NULL,
    objetivo VARCHAR(50) NOT NULL,
    FOREIGN KEY (nave) REFERENCES Nave(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    FOREIGN KEY (objetivo) REFERENCES CuerpoCeleste(nombre)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
)

CREATE TABLE ParticiparMision(
    mision INT NOT NULL,
    astronauta INT NOT NULL,
    FOREIGN KEY (mision) REFERENCES Mision(codigo)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (astronauta) REFERENCES Astronauta(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
)

CREATE TABLE Usuario(
    id INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    clave VARCHAR(50) NOT NULL,
)
CREATE TABLE Aficionado(
    id INT PRIMARY KEY,
    tier VARCHAR(10) NOT NULL, 
    FOREIGN KEY (id) REFERENCES Usuario(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
)

CREATE TABLE Estudiante(
    id INT PRIMARY KEY,
    centro VARCHAR(50) NOT NULL,
    num_est INT NOT NULL, -- qué coño é num_est?
    FOREIGN KEY (id) REFERENCES Usuario(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
)

CREATE TABLE Científico(
    id INT PRIMARY KEY,
    centro VARCHAR(50) NOT NULL,
    num_articulos INT NOT NULL,
    FOREIGN KEY (id) REFERENCES Usuario(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
)

CREATE TABLE Administrador(
    id INT PRIMARY KEY,
    rango VARCHAR(50) NOT NULL,
    FOREIGN KEY (id) REFERENCES Usuario(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
)

CREATE TABLE EntradaForo(
    numeroEntrada INT NOT NULL,
    autor INT NOT NULL,
    fecha DATE NOT NULL,
    titulo VARCHAR(50) NOT NULL,
    contenido VARCHAR(1024) NOT NULL,
    FOREIGN KEY (autor) REFERENCES Usuario(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    PRIMARY KEY (numeroEntrada, autor)
)

--comentario?

CREATE TABLE Artículo(
    -- entonces desto non se garda o contenido, solo unha descripcion e o num de paginas
    id INT PRIMARY KEY,
    fechaPublicacion DATE NOT NULL,
    autor INT NOT NULL,
    cuerpo VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    numPaginas INT NOT NULL,
    FOREIGN KEY (autor) REFERENCES Científico(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (cuerpo) REFERENCES CuerpoCeleste(nombre)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    
)

CREATE TABLE Colaboracion(
    fechaInicio DATE NOT NULL,
    fechaFin DATE,
    científico INT NOT NULL,
    agencia INT NOT NULL,
    FOREIGN KEY (científico) REFERENCES Científico(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    FOREIGN KEY (agencia) REFERENCES Agencia(id)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
    PRIMARY KEY (científico, agencia, fechaInicio)
)