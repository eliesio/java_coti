create database bd_projetospringmvc01;

use bd_projetospringmvc01;

CREATE TABLE tarefa (
    idtarefa INTEGER AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL,
    data DATE NOT NULL,
    hora VARCHAR(5) NOT NULL,
    descricao VARCHAR(500) NOT NULL,
    prioridade VARCHAR(10) NOT NULL,
    PRIMARY KEY (idtarefa),
    CHECK (prioridade IN ('BAIXA' , 'MEDIA', 'ALTA'))
);
    