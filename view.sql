CREATE VIEW CientificoConArticulos AS
SELECT c.id,
    c.centro,
    COUNT(a.id) AS num_articulos
FROM Científico c
    LEFT JOIN Artículo a ON c.id = a.autor
GROUP BY c.id,
    c.centro;
SELECT *
FROM CientificoConArticulos;


CREATE VIEW AgenciaConAstronautas AS
SELECT a.id,
    a.nombre,
    a.localizacion,
    COUNT(DISTINCT pa.astronauta_id) AS num_astronautas
FROM Agencia a
    LEFT JOIN PertenecerAgencia pa ON a.id = pa.agencia_id
GROUP BY a.id,
    a.nombre,
    a.localizacion;
SELECT *
FROM AgenciaConAstronautas;