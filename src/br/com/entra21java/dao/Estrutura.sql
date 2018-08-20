DROP DATABASE IF EXISTS exemplo_web_01;
CREATE DATABASE exemplo_web_01;
USE exemplo_web_01;


CREATE TABLE categorias (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100)
);

CREATE TABLE produtos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  id_categoria INT NOT NULL,

  nome VARCHAR(100) NOT NULL,
  preco DOUBLE NOT NULL,

  FOREIGN KEY (id_categoria) REFERENCES categorias(id)
);


INSERT INTO categorias (nome) VALUES
('Video Game'),
('Eletrodomésticos');

INSERT INTO produtos (id_categoria, nome, preco) VALUES
(1, 'XBOX ONE X', 3000),
(1, 'PS4 PRO', 2500),
(2, 'Fogão à gás', 600.98),
(2, 'Geladeira Consul', 1699.00);