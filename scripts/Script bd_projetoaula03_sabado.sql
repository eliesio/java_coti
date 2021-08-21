CREATE database bd_projetoaula03;

use bd_projetoaula03;

CREATE table empresa(
	idempresa 		integer 		auto_increment,
	nomefantasia 	varchar(100) 	not null,
	razaosocial 	varchar(100) 	not null unique,
	cnpj 			varchar(25) 	not null unique,
	primary key(idempresa));


create table funcionario(
	idfuncionario	integer			auto_increment,
    nome			varchar(150)	not null,
    cpf				varchar(15)		not null unique,
    matricula		varchar(15)		not null unique,
    dataadmissao	date			not null,
    idempresa		integer			not null,
    primary key(idfuncionario),
    foreign key(idempresa) references empresa(idempresa));
	