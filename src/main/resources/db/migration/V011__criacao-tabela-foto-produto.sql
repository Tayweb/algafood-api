
create table foto_produto (
content_type varchar(50), 
descricao varchar(100), 
nome_arquivo varchar(100), 
tamanho int8, 
produto_id int8 not null, 
primary key (produto_id)

);

alter table foto_produto add constraint foto_produto_produto foreign key (produto_id) references produto;
