DROP TABLE contacto IF EXISTS;

CREATE TABLE contacto (
  codigo  INTEGER IDENTITY PRIMARY KEY,
  nombre  VARCHAR(30),
  correo  VARCHAR(30),
  queja  VARCHAR(120)
);

DROP TABLE persona IF EXISTS;

CREATE TABLE persona (
  id         INTEGER IDENTITY PRIMARY KEY,
  nombre VARCHAR(30),
  apellido  VARCHAR(30),
  correo  VARCHAR(30),
  password  VARCHAR(30)
);

DROP TABLE producto IF EXISTS;
CREATE TABLE producto (
  codigo  INTEGER IDENTITY PRIMARY KEY,
  nombre  VARCHAR(30),
  precio  DECIMAL(8,2),
  cantidad  INTEGER
);



