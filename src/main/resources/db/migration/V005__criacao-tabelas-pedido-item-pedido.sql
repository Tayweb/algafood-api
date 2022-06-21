
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

alter table item_pedido add constraint fk_item_pedido_pedido foreign key (pedido_id) references pedido;
alter table item_pedido add constraint fk_item_pedido_produto foreign key (produto_id) references produto;
alter table pedido add constraint fk_pedido_usuario foreign key (usuario_cliente_id) references usuario;
alter table pedido add constraint fk_pedido_cidade foreign key (endereco_cidade_id) references cidade;
alter table pedido add constraint fk_pedido_forma_pagamento foreign key (forma_pagamento_id) references forma_pagamento;
alter table pedido add constraint fk_pedido_restaurante foreign key (restaurante_id) references restaurante;

