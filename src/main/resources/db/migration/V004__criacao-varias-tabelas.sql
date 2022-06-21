
create table forma_pagamento (
id  bigserial not null, 
descricao varchar(255) not null,
primary key (id)
);

create table grupo (
id  bigserial not null, 
nome varchar(80), 
primary key (id)
);


create table grupo_permissao (
grupo_id int8 not null, 
permissao_id int8 not null
);

create table permissao (id  bigserial not null, 
nome varchar(80) not null,
descricao varchar(255) not null, 
primary key (id)
);

create table produto (
id  bigserial not null,
ativo boolean not null, 
descricao varchar(255) not null, 
nome varchar(255) not null, 
preco numeric(19, 2) not null,
restaurante_id int8, 
primary key (id)
);

create table restaurante (
id  bigserial not null, 
data_atualizacao timestamp(0),
data_cadastro timestamp(0),
endereco_bairro varchar(60), 
endereco_cep varchar(20),
endereco_complemento varchar(80), 
endereco_logradouro varchar(80),
endereco_numero varchar(20), 
nome_restaurante varchar(80) not null, 
taxa_frete numeric(19, 2) not null,
cozinha_id int8 not null, 
endereco_cidade_id int8,
primary key (id)
);

create table restaurante_forma_pagamento (
restaurante_id int8 not null, 
forma_pagamento_id int8 not null
);

create table usuario (
id  bigserial not null,
data_cadastro timestamp,
email varchar(100), 
nome varchar(80), 
primary key (id)
);


create table usuario_grupo (
usuario_id int8 not null, 
grupo_id int8 not null

);

alter table grupo_permissao add constraint fk_grupo_permissao_permissao foreign key (permissao_id) references permissao;
alter table grupo_permissao add constraint fk_grupo_permissao_grupo foreign key (grupo_id) references grupo;
alter table produto add constraint fk_produto_restaurante_  foreign key (restaurante_id) references restaurante;
alter table restaurante add constraint fk_restaurante_cozinha foreign key (cozinha_id) references cozinha;
alter table restaurante add constraint fk_restaurante_cidade foreign key (endereco_cidade_id) references cidade;
alter table restaurante_forma_pagamento add constraint fk_restaurante_forma_pagamento_forma_pagamento foreign key (forma_pagamento_id) references forma_pagamento;
alter table restaurante_forma_pagamento add constraint fk_restaurante_forma_pagamento_estaurante foreign key (restaurante_id) references restaurante;
alter table usuario_grupo add constraint fk_usuario_grupo_grupo foreign key (grupo_id) references grupo;
alter table usuario_grupo add constraint fk_usuario_grupo_usuario foreign key (usuario_id) references usuario;

