drop database if exists inter_caio_gabriel;
create database if not exists inter_caio_gabriel;
use inter_caio_gabriel;


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

CREATE TABLE IF NOT EXISTS Usuario(
	id_User INT AUTO_INCREMENT primary key,
    cpf VARCHAR(14) UNIQUE NOT NULL,
	senha VARCHAR(100) NOT NULL,
    cargo VARCHAR(30) NOT NULL,
	img VARCHAR(100)NOT NULL,
    nome VARCHAR(100) NOT NULL ,
    idade INT NOT NULL ,
    endereco INT ,
    contato VARCHAR(100),
    foreign key(endereco) references Endereco(id_Endereco)
);

create table if not exists Professor(
	id_Professor INT NOT NULL AUTO_INCREMENT,
    id_User INT NOT NULL,
    descricao_Professor VARCHAR(100) NOT NULL,
    preco_Aula VARCHAR(100) NOT NULL,
    materia_Professor VARCHAR(100) NOT NULL,
    primary key(id_Professor),
    foreign key(id_User) references Usuario(id_User)
);

create table if not exists Aula_Marcada(
	id_Aula_Marcada INT NOT NULL AUTO_INCREMENT,
    id_Professor INT NOT NULL ,
    id_Aluno INT NOT NULL,
    data_Marcada DATE NOT NULL,
    hora_Aula VARCHAR (10) NOT NULL,
    statusDaAula VARCHAR(20),
    primary key(id_Aula_Marcada),
    foreign key(id_Professor) references Professor(id_Professor),
    foreign key(id_Aluno) references Usuario(id_User)
);

/* INSERT */
INSERT INTO Endereco (rua,bairro,cidade,numero,cep,complemento) VAlUES ("Sales de Oliveira","Vila Industrial","Campinas","2033","13021850","Casa");
INSERT INTO Endereco (rua,bairro,cidade,numero,cep,complemento) VAlUES ("Jose Serafim","Vila Castelo Branco","Campinas","177","13041960","Casa");

INSERT INTO Usuario (cpf,senha,cargo,img, nome, idade, endereco,contato) VALUES ("1234","123","Aluno","/ImgsUsers/Aluno_Gabriel.jpg","Caio",20,1,"123456789");
INSERT INTO Usuario (cpf,senha,cargo,img, nome, idade, endereco,contato) VALUES ("7896","555","Professor","/ImgsUsers/Alex.jpg","Alex",37,2,"25632478");

INSERT INTO Professor (id_User,descricao_Professor,preco_Aula,materia_Professor) VALUES (2,"Professor de Matemtica, atendo em casa","40.00","Matematica");
 
INSERT INTO Aula_Marcada (id_Professor,id_Aluno,data_Marcada,hora_Aula,statusDaAula) VALUES (1,1,"2020-05-20","12:00","Confirmado");
 /* VIEWS */
 
CREATE VIEW DadosAluno AS SELECT cpf,img,nome AS "Nome Aluno",idade AS "Idade",concat(concat(bairro,", ",rua),", ",numero) AS "Endereço Aluno", contato AS "Contato Aluno" FROM Usuario
INNER JOIN Endereco ON Endereco.id_Endereco = Usuario.endereco;

select * FROM DadosAluno WHERE cpf="1234";

CREATE VIEW DadosProfessor AS SELECT id_Professor,img,nome,endereco, contato ,descricao_Professor,preco_Aula ,materia_Professor FROM Usuario
INNER JOIN Professor ON Professor.id_User = Usuario.id_User;

SELECT * FROM DadosProfessor WHERE id_Professor= 1;

CREATE VIEW AulasMarcadasAluno AS SELECT id_Aluno,nome AS "Nome Professor", materia_Professor AS "Materia Professor" , concat(concat(bairro,", ",rua),", ",numero) AS "Endereço Professor", contato AS "Contato Professor",
preco_Aula AS "Preço da Aula", data_Marcada AS "Data da Aula",statusDaAula FROM Aula_Marcada
INNER JOIN Professor ON Professor.id_Professor = Aula_Marcada.id_Professor
INNER JOIN Usuario ON Usuario.id_User = Professor.id_User 
INNER JOIN Endereco ON Endereco.id_Endereco = Usuario.endereco;

SELECT * FROM AulasMarcadasAluno WHERE id_Aluno = 1 AND statusDaAula = "Confirmado";

CREATE VIEW AulasMarcadasProfessor AS SELECT id_Professor,nome AS "Nome Aluno", concat(concat(bairro,", ",rua),", ",numero) AS "Endereço Aluno", contato AS "Contato Aluno",statusDaAula FROM Aula_Marcada
INNER JOIN Usuario ON Usuario.id_User = Aula_Marcada.id_Aluno
INNER JOIN Endereco ON Endereco.id_Endereco = Usuario.endereco;

SELECT * FROM AulasMarcadasProfessor WHERE id_Professor = 1 AND statusDaAula = "Confirmado";

CREATE VIEW ProcurarProfessor AS SELECT id_Professor,nome , materia_Professor, preco_Aula  FROM Usuario
INNER JOIN Professor ON Professor.id_User = Usuario.id_User;

SELECT * FROM ProcurarProfessor WHERE materia_Professor LIKE "%m%" ;
LIKE CONCAT('%',nomeAl,'%')
SELECT * FROM Usuario WHERE cpf ="4444" AND senha="458";


SELECT * FROM ProcurarProfessor;
SELECT * FROM endereco where id_Endereco = 1;
SELECT * FROM ProcuraProfessor;
SELECT * FROM Aula_Marcada;
SELECT * FROM Usuario;
SELECT * FROM endereco;
SELECT img FROM Usuario;
SELECT * FROM Usuario;
update Usuario set cpf = '123', nome = 'Gabriel' where id_User = 1;