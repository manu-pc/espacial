CREATE OR REPLACE FUNCTION crear_usuario(
    p_id VARCHAR,
    p_nombre VARCHAR,
    p_email VARCHAR,
    p_clave VARCHAR
)
RETURNS VOID AS $$
BEGIN
    -- 1. Insertar en la tabla Usuario
    INSERT INTO Usuario(id, nombre, email, clave)
    VALUES (p_id, p_nombre, p_email, p_clave);

    -- 2. Crear el usuario real de PostgreSQL
    EXECUTE format('CREATE ROLE %I WITH LOGIN PASSWORD %L', p_id, p_clave);
EXCEPTION
    WHEN unique_violation THEN
        RAISE NOTICE 'El usuario ya existe en la tabla o como rol.';
    WHEN others THEN
        RAISE EXCEPTION 'Error: %', SQLERRM;
END;
$$ LANGUAGE plpgsql;
