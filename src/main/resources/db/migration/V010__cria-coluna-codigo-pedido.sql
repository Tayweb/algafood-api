ALTER TABLE pedido ADD codigo varchar(36);
UPDATE pedido SET codigo = uuid_generate_v1();
ALTER TABLE pedido ALTER COLUMN codigo SET not null;
ALTER TABLE pedido ADD CONSTRAINT uk_pedido_codigo UNIQUE (codigo);