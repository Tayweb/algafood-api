SET session_replication_role = 'replica';

delete from cidade;
delete from cozinha;
delete from estado;
delete from forma_pagamento;
delete from grupo;
delete from grupo_permissao;
delete from permissao;
delete from produto;
delete from restaurante;
delete from restaurante_forma_pagamento;
delete from usuario;
delete from usuario_grupo;

SET session_replication_role = 'origin';

insert into cozinha (id, nome) values (1,'Tailandesa');
insert into cozinha (id, nome) values (2,'Indiana');
insert into cozinha (id, nome) values (3,'Brasileira');
insert into cozinha (id, nome) values (4, 'Argentina');

 insert into estado (id, nome) values (1, 'Minas Gerais');
    insert into estado (id, nome) values (2, 'São Paulo');
    insert into estado (id, nome) values (3, 'Ceará');

insert into cidade (id, nome, estado_id) values (1, 'Uberlândia', 1);
    insert into cidade (id, nome, estado_id) values (2, 'Belo Horizonte', 1);
    insert into cidade (id, nome, estado_id) values (3, 'São Paulo', 2);
    insert into cidade (id, nome, estado_id) values (4, 'Campinas', 2);
    insert into cidade (id, nome, estado_id) values (5, 'Fortaleza', 3);



insert into restaurante (id,nome_restaurante, taxa_frete, cozinha_id, ativo, aberto, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_bairro) values (1,'Thai Gourmet', 10, 1, true, true, 2, '38400-999', 'Rua João Pinheiro', '1000', 'Centro');
insert into restaurante (id,nome_restaurante, taxa_frete, cozinha_id, ativo, aberto) values (2,'Tuk tuk indiano', 29.90, 2, true,true);
insert into restaurante (id,nome_restaurante, taxa_frete, cozinha_id, ativo, aberto) values (3,'Comida Nordestina', 0, 3, true, true);
insert into restaurante (id,nome_restaurante, taxa_frete, cozinha_id, ativo, aberto) values (4,'Java Steakhouse', 12, 3, true,true );
insert into restaurante (id,nome_restaurante, taxa_frete, cozinha_id, ativo, aberto) values (5,'Lanchonete do Tio Sam', 11, 4, true,true );
insert into restaurante (id,nome_restaurante, taxa_frete, cozinha_id, ativo, aberto) values (6,'Bar da Maria', 6, 2, true,true);
 
    
    insert into forma_pagamento (id, descricao) values (1, 'Cartão de crédito');
    insert into forma_pagamento (id, descricao) values (2, 'Cartão de débito');
    insert into forma_pagamento (id, descricao) values (3, 'Dinheiro');
    
insert into restaurante_forma_pagamento (restaurante_id, forma_pagamento_id) values (1, 1), (2, 3), (3, 2), (3, 3), (4, 1), (4, 2), (5, 1), (5, 2), (6, 3);

    insert into permissao (id, nome, descricao) values (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
    insert into permissao (id, nome, descricao) values (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');
    
    
insert into produto (id,nome, descricao, preco, ativo, restaurante_id) values (1,'Porco com molho agridoce', 'Deliciosa carne suína ao molho especial', 78.90, true, 1);
insert into produto (id,nome, descricao, preco, ativo, restaurante_id) values (2,'Camarão tailandês', '16 camarões grandes ao molho picante', 110, true, 1);

insert into produto (id,nome, descricao, preco, ativo, restaurante_id) values (3,'Salada picante com carne grelhada', 'Salada de folhas com cortes finos de carne bovina grelhada e nosso molho especial de pimenta vermelha', 87.20, true, 2);

insert into produto (id,nome, descricao, preco, ativo, restaurante_id) values (4,'Garlic Naan', 'Pão tradicional indiano com cobertura de alho', 21, true, 3);
insert into produto (id,nome, descricao, preco, ativo, restaurante_id) values (5,'Murg Curry', 'Cubos de frango preparados com molho curry e especiarias', 43, true, 3);

insert into produto (id,nome, descricao, preco, ativo, restaurante_id) values (6,'Bife Ancho', 'Corte macio e suculento, com dois dedos de espessura, retirado da parte dianteira do contrafilé', 79, true, 4);
insert into produto (id,nome, descricao, preco, ativo, restaurante_id) values (7,'T-Bone', 'Corte muito saboroso, com um osso em formato de T, sendo de um lado o contrafilé e do outro o filé mignon', 89, true, 4);

insert into produto (id,nome, descricao, preco, ativo, restaurante_id) values (8,'Sanduíche X-Tudo', 'Sandubão com muito queijo, hamburger bovino, bacon, ovo, salada e maionese', 19, true, 5);

insert into produto (id,nome, descricao, preco, ativo, restaurante_id) values (9,'Espetinho de Cupim', 'Acompanha farinha, mandioca e vinagrete', 8, true, 6);

insert into grupo (id,nome) values (1,'Gerente'), (2,'Vendedor'), (3,'Secretária'), (4,'Cadastrador');

insert into grupo_permissao (grupo_id, permissao_id) values (1, 1), (1, 2), (2, 1), (2, 2), (3, 1); 

insert into usuario (id, nome, email, senha, data_cadastro) values
(1, 'João da Silva', 'joao.ger@algafood.com', '123', '14/06/2022'),
(2, 'Maria Joaquina', 'maria.vnd@algafood.com', '123', '14/06/2022'),
(3, 'José Souza', 'jose.aux@algafood.com', '123', '14/06/2022'),
(4, 'Sebastião Martins', 'sebastiao.cad@algafood.com', '123', '14/06/2022');   

insert into usuario_grupo (usuario_id, grupo_id) values (1, 1), (1, 2), (2, 2);

delete from restaurante_usuario_responsavel;

insert into restaurante_usuario_responsavel (restaurante_id, usuario_id) values (1, 4), (3, 4);

SET session_replication_role = 'replica';

delete from pedido;

delete from item_pedido;

SET session_replication_role = 'origin';

insert into pedido (id, codigo, restaurante_id, usuario_cliente_id, forma_pagamento_id, endereco_cidade_id, endereco_cep, 
    endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro,
    status,sub_total, taxa_frete, valor_total, data_criacao)
values (1, 'bf0a4efc-ed05-11ec-8ea0-0242ac120002', 1, 1, 1, 1, '38400-000', 'Rua Floriano Peixoto', '500', 'Apto 801', 'Brasil',
'CRIADO',298.90, 10, 308.90, '22/06/2022');

insert into item_pedido (id, pedido_id, produto_id, quantidade, preco_unitario, preco_total, observacao)
values (1, 1, 1, 1, 78.9, 78.9, null);

insert into item_pedido (id, pedido_id, produto_id, quantidade, preco_unitario, preco_total, observacao)
values (2, 1, 2, 2, 110, 220, 'Menos picante, por favor');


insert into pedido (id, codigo, restaurante_id, usuario_cliente_id, forma_pagamento_id, endereco_cidade_id, endereco_cep, 
        endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro,
        status,  sub_total, taxa_frete, valor_total, data_criacao)
values (2, '7f84cfdc-ed05-11ec-8ea0-0242ac120002',4, 1, 2, 1, '38400-111', 'Rua Acre', '300', 'Casa 2', 'Centro',
'CRIADO',  79, 0, 79, '22/06/2022');

insert into item_pedido (id, pedido_id, produto_id, quantidade, preco_unitario, preco_total, observacao)
values (3, 2, 6, 1, 79, 79, 'Ao ponto');







