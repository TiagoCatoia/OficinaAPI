create table conserto (
    id              bigint not null auto_increment,
    data_entrada    varchar(20) not null,
    data_saida      varchar(20) not null,
    nome_mecanico   varchar(100) not null,
    anos_experiencia_mecanico int,
    nome_veiculo    varchar(100) not null,
    modelo_veiculo  varchar(100),
    ano_veiculo     int,
    constraint conserto_id PRIMARY KEY (id)
);