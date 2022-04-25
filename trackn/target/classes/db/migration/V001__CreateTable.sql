CREATE TABLE funcionario(
    id integer primary key not null,
    nome varchar(155) not null,
    idade integer not null,
    cep varchar(10) not null,
    sexo char(1),
    endereco varchar(155),
    bairro varchar(150),
    cidade varchar(255),
    estado char(2)
);