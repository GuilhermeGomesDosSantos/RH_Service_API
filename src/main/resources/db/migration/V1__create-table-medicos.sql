CREATE TABLE colaboradores(
    id bigint NOT NULL auto_increment,
    status tinyint(1) NOT NULL,
    nome_completo VARCHAR(100) NOT NULL,
    primeiro_nome VARCHAR(20) NOT NULL,
    ultimo_nome VARCHAR(20) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    rg VARCHAR(11) NOT NULL,
    email_pessoal VARCHAR(70) NOT NULL,
    email_organizacional VARCHAR(70) NOT NULL,
    telefone_celular VARCHAR(20) NOT NULL,
    matricula VARCHAR(20) NOT NULL,
    cargo VARCHAR(20) NOT NULL,
    departamento VARCHAR(20) NOT NULL,
    tipo_contratacao VARCHAR(10) NOT NULL,
    salario VARCHAR(30) NOT NULL,

    logradouro varchar(100) not null,
        bairro varchar(100) not null,
        cep varchar(9) not null,
        complemento varchar(100),
        numero varchar(20),
        uf char(2) not null,
        cidade varchar(20) not null,

        primary key(id)
)