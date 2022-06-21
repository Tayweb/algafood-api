
create table item_pedido (
id  bigserial not null,
observacao varchar(255), 
preco_total numeric(19, 2),
preco_unitario numeric(19, 2),
quantidade int4, 
pedido_id int8 not null,
produto_id int8 not null,
primary key (id)
);

create table pedido (
id  bigserial not null,
data_cancelamento timestamp, 
data_confirmacao timestamp, 
data_criacao timestamp, 
data_entrega timestamp, 
endereco_bairro varchar(30), 
endereco_cep varchar(9), 
endereco_complemento varchar(60), 
endereco_logradouro varchar(100), 
endereco_numero varchar(10), 
status varchar(10) not null, 
sub_total numeric(19, 2), 
taxa_frete numeric(19, 2),
valor_total numeric(19, 2), 
usuario_cliente_id int8 not null, 
endereco_cidade_id int8, 
forma_pagamento_id int8 not null, 
restaurante_id int8 not null,
primary key (id)
);

alter table item_pedido add constraint fk_item_pedido_pedido foreign key (pedido_id) references pedido;
alter table item_pedido add constraint fk_item_pedido_produto foreign key (produto_id) references produto;
alter table pedido add constraint fk_pedido_usuario foreign key (usuario_cliente_id) references usuario;
alter table pedido add constraint fk_pedido_cidade foreign key (endereco_cidade_id) references cidade;
alter table pedido add constraint fk_pedido_forma_pagamento foreign key (forma_pagamento_id) references forma_pagamento;
alter table pedido add constraint fk_pedido_restaurante foreign key (restaurante_id) references restaurante;

create table cidade (id  bigserial not null, nome varchar(255) not null, estado_id int8 not null, primary key (id));
create table cozinha (id  bigserial not null, nome varchar(255) not null, primary key (id));
create table estado (id  bigserial not null, nome varchar(255) not null, primary key (id));
create table forma_pagamento (id  bigserial not null, descricao varchar(255) not null, primary key (id));
create table grupo (id  bigserial not null, nome varchar(255), primary key (id));
create table grupo_permissao (grupo_id int8 not null, permissao_id int8 not null);
create table item_pedido (id  bigserial not null, observacao varchar(255), preco_total numeric(19, 2), preco_unitario numeric(19, 2), quantidade int4, pedido_id int8 not null, produto_id int8 not null, primary key (id));
create table pedido (id  bigserial not null, data_cancelamento timestamp, data_confirmacao timestamp, data_criacao timestamp, data_entrega timestamp, endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), status int4, sub_total numeric(19, 2), taxa_frete numeric(19, 2), valor_total numeric(19, 2), usuario_cliente_id int8 not null, endereco_cidade_id int8, forma_pagamento_id int8 not null, restaurante_id int8 not null, primary key (id));
create table permissao (id  bigserial not null, descricao varchar(255) not null, nome varchar(255) not null, primary key (id));
create table produto (id  bigserial not null, ativo boolean not null, descricao varchar(255) not null, nome varchar(255) not null, preco numeric(19, 2) not null, restaurante_id int8, primary key (id));
create table restaurante (id  bigserial not null, data_atualizacao timestamp(0), data_cadastro timestamp(0), endereco_bairro varchar(255), endereco_cep varchar(255), endereco_complemento varchar(255), endereco_logradouro varchar(255), endereco_numero varchar(255), nome_restaurante varchar(255) not null, taxa_frete numeric(19, 2) not null, cozinha_id int8 not null, endereco_cidade_id int8, primary key (id));
create table restaurante_forma_pagamento (restaurante_id int8 not null, forma_pagamento_id int8 not null);
create table usuario (id  bigserial not null, data_cadastro timestamp, email varchar(255), nome varchar(255), primary key (id));
create table usuario_grupo (usuario_id int8 not null, grupo_id int8 not null);
alter table cidade add constraint FKkworrwk40xj58kevvh3evi500 foreign key (estado_id) references estado;
alter table grupo_permissao add constraint FKh21kiw0y0hxg6birmdf2ef6vy foreign key (permissao_id) references permissao;
alter table grupo_permissao add constraint FKta4si8vh3f4jo3bsslvkscc2m foreign key (grupo_id) references grupo;
alter table item_pedido add constraint FK60ym08cfoysa17wrn1swyiuda foreign key (pedido_id) references pedido;
alter table item_pedido add constraint FKtk55mn6d6bvl5h0no5uagi3sf foreign key (produto_id) references produto;
alter table pedido add constraint FKcccmjvm9ytuxbe00h3wmtm77y foreign key (usuario_cliente_id) references usuario;
alter table pedido add constraint FKk987vfg9cpgx7qxj3166fdqig foreign key (endereco_cidade_id) references cidade;
alter table pedido add constraint FKqaa411xsl0xu4tkvt1wpccd3b foreign key (forma_pagamento_id) references forma_pagamento;
alter table pedido add constraint FK3eud5cqmgsnltyk704hu3qj71 foreign key (restaurante_id) references restaurante;
alter table produto add constraint FKb9jhjyghjcn25guim7q4pt8qx foreign key (restaurante_id) references restaurante;
alter table restaurante add constraint FK76grk4roudh659skcgbnanthi foreign key (cozinha_id) references cozinha;
alter table restaurante add constraint FKbc0tm7hnvc96d8e7e2ulb05yw foreign key (endereco_cidade_id) references cidade;
alter table restaurante_forma_pagamento add constraint FK7aln770m80358y4olr03hyhh2 foreign key (forma_pagamento_id) references forma_pagamento;
alter table restaurante_forma_pagamento add constraint FKa30vowfejemkw7whjvr8pryvj foreign key (restaurante_id) references restaurante;
alter table usuario_grupo add constraint FKk30suuy31cq5u36m9am4om9ju foreign key (grupo_id) references grupo;
alter table usuario_grupo add constraint FKdofo9es0esuiahyw2q467crxw foreign key (usuario_id) references usuario;
