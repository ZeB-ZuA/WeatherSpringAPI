CREATE TABLE usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    nombre_usuario VARCHAR(255) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);
CREATE TABLE rol (
    id INT PRIMARY KEY AUTO_INCREMENT,
    rol_nombre VARCHAR(255) NOT NULL
);
CREATE TABLE usuario_roles (
    usuario_id INT,
    rol_id INT,
    PRIMARY KEY (usuario_id, rol_id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (rol_id) REFERENCES rol(id)
);
CREATE TABLE consulta (
    id_consulta INT PRIMARY KEY AUTO_INCREMENT,
    ciudad VARCHAR(255) NOT NULL,
    tipo_consulta VARCHAR(255) NOT NULL,
    fecha_hora DATETIME NOT NULL,
    respuesta TEXT NOT NULL,
    usuario_id INT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
insert into rol (rol_nombre) value ('CLIENT');
