drop database if exists inter_caio_gabriel;
create database if not exists inter_caio_gabriel;
use inter_caio_gabriel;

create table if not exists Login(
	id_Login INT AUTO_INCREMENT primary key,
	cpf varchar(11) not null,
    senha varchar(100) not null,
    cargo varchar(30) not null
);

create table if not exists Endereco(
	id_Endereco INT AUTO_INCREMENT,
    rua varchar(100) not null,
    bairro varchar(100) not null,
    cidade varchar(100) not null,
    numero varchar(5) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    primary key(id_endereco)
);

create table if not exists Aluno(
	id_Aluno INT NOT NULL AUTO_INCREMENT,
    nome_Aluno varchar(100) NOT NULL ,
    idade_Aluno int NOT NULL ,
    endereco_Aluno INT ,
    contato_Aluno varchar(100),
    login INT,
    primary key(id_Aluno),
    foreign key(endereco_Aluno) references Endereco(id_Endereco),
    foreign key(login) references Login(id_Login)
);

create table if not exists Professor(
	id_Professor INT NOT NULL AUTO_INCREMENT,
    nome_Professor varchar(100) not null,
    idade_Professor int not null,
    descricao_Professor varchar(100) not null,
    preco_Aula varchar(100) not null,
    endereco_Professor int not null,
    contato_Professor varchar(100),
    login int not null,
    primary key(id_Professor),
    foreign key(endereco_Professor) references Endereco(id_endereco),
    foreign key(login) references Login(id_login)
);

create table if not exists Materia_Professor(
	id_Materia int auto_increment,
    Professor int not null,
    materia_Professor varchar(100) not null,
    primary key(id_Materia),
    foreign key(Professor) references Professor(id_professor)
);

create table if not exists Aula_Marcada(
	id_Aula_Marcada int auto_increment,
    id_Professor int not null,
    id_Aluno int not null,
    data_Marcada datetime not null,
    primary key(id_Aula_Marcada),
    foreign key(id_Professor) references Professor(id_Professor),
    foreign key(id_Aluno) references Aluno(id_Aluno)
);

/* INSERT */
INSERT INTO Login (cpf,senha,cargo) VAlUES ("47062955809","161000","Aluno");
INSERT INTO Login (cpf,senha,cargo) VAlUES ("17204486807","010896","Professor");

INSERT INTO Endereco (rua,bairro,cidade,numero,cep,complemento) VAlUES ("Sales de Oliveira","Vila Industrial","Campinas","2033","13021850","Casa");
INSERT INTO Endereco (rua,bairro,cidade,numero,cep,complemento) VAlUES ("Jose Serafim","Vila Castelo Branco","Campinas","177","13041960","Casa");

INSERT INTO Aluno (nome_Aluno,idade_Aluno,endereco_Aluno,contato_Aluno,login) VALUES ("Caio Mota", 19, 2,"19982323017",1);
INSERT INTO Professor (nome_Professor,idade_Professor,descricao_Professor,preco_Aula,endereco_Professor,contato_Professor,login) VALUES ("Alex Sandro", 45, "Professor formado em Matematica, Atento na minha casa,cobro a hora",50.00,1,"19997225798",2);

INSERT INTO Materia_Professor (Professor,materia_Professor) VALUES (1,"Matematica");

INSERT INTO Aula_Marcada (id_Professor,id_Aluno,data_Marcada) VALUES (1,1,"2020-05-20");
 
 
 /* VIEWS */
 
CREATE VIEW DadosAluno AS SELECT id_ALuno,nome_aluno AS "Nome Aluno", idade_Aluno AS "Idade", contato_Aluno AS "Contato Aluno", concat(concat(bairro,", ",rua),", ",numero) AS "Endereço Aluno",login FROM Aluno 
INNER JOIN Endereco ON endereco.id_endereco = Aluno.endereco_Aluno;

select * FROM DadosAluno WHERE login=1;

CREATE VIEW  DadosProfessor AS Select id_Professor, nome_Professor AS "Nome Professor", idade_Professor AS "Idade", descricao_Professor AS "Descrição", materia_Professor AS "Materia do Professor" ,preco_Aula AS "Preço da Aula", contato_Professor AS "Contato Professor" ,concat(concat(bairro,", ",rua),", ",numero) AS "Endereço Professor",login FROM Professor
INNER JOIN Endereco ON endereco.id_endereco = Professor.endereco_Professor
INNER JOIN Materia_Professor ON Materia_Professor.Professor = Professor.id_Professor;

select * FROM DadosProfessor WHERE login=2;