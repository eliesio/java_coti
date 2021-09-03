use bd_projetospringmvc01;

select
	*
from
	tarefa;

create table usuario(
	idusuario integer auto_increment,
	nome varchar(150) not null,
	email varchar(100) not null unique,
	senha varchar(50) not null,
	primary key(idusuario));

desc usuario;