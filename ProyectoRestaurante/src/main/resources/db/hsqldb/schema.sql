DROP TABLE persona IF EXISTS;

CREATE TABLE persona (
  id         INTEGER IDENTITY PRIMARY KEY,
  nombre VARCHAR(30),
  apellido  VARCHAR(30),
  email  VARCHAR(30),
  username  VARCHAR(30),
  password  VARCHAR(30),
  confirmapass  VARCHAR(30)
);
