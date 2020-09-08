drop database if exists inter_caio_gabriel;
create database if not exists inter_caio_gabriel;
use inter_caio_gabriel;

create table if not exists Login(
	id_login int auto_increment primary key,
	cpf int not null,
    senha varchar(100) not null,
    cargo varchar(30) not null
);

create table if not exists Endereco(
	id_endereco int auto_increment,
    rua varchar(100) not null,
    bairro varchar(100) not null,
    cidade varchar(100) not null,
    numero char(5) not null,
    complemento varchar(100),
    primary key(id_endereco)
);

create table if not exists Aluno(
	id_aluno int not null,
    nome_aluno varchar(100) not null,
    idade_aluno int not null,
    endereco_aluno int not null,
    contato_aluno varchar(100),
    login int not null,
    primary key(id_aluno),
    foreign key(endereco_aluno) references Endereco(id_endereco),
    foreign key(login) references Login(id_login)
);

create table if not exists Professor(
	id_professor int not null,
    nome_professor varchar(100) not null,
    idade_professor int not null,
    descricao_professor varchar(100) not null,
    preco_aula varchar(100) not null,
    endereco_professor int not null,
    contato_professor varchar(100),
    login int not null,
    primary key(id_professor),
    foreign key(endereco_professor) references Endereco(id_endereco),
    foreign key(login) references Login(id_login)
);

create table if not exists Materia_Professor(
	id_materia int auto_increment,
    id_professor int not null,
    materia_professor varchar(100) not null,
    primary key(id_materia),
    foreign key(id_professor) references Professor(id_professor)
);

create table if not exists Aula_Marcada(
	id_aula_marcada int auto_increment,
    id_professor int not null,
    id_aluno int not null,
    data_marcada datetime not null,
    primary key(id_aula_marcada),
    foreign key(id_professor) references Professor(id_professor),
    foreign key(id_aluno) references Aluno(id_aluno)
);