create table estado (
id serial NOT NULL,
nome varchar(80) not null,
primary key (id)

);

INSERT INTO estado (nome) SELECT DISTINCT nome_estado FROM cidade;

ALTER TABLE cidade ADD COLUMN estado_id BIGINT;

ALTER TABLE cidade ALTER COLUMN estado_id SET NOT NULL;

UPDATE cidade SET estado_id = (SELECT estado.id FROM estado WHERE estado.nome = cidade.nome_estado);

ALTER TABLE cidade ADD CONSTRAINT fk_cidade_estado FOREIGN KEY (estado_id) REFERENCES estado (id);

ALTER TABLE cidade DROP COLUMN nome_estado;

ALTER TABLE cidade RENAME COLUMN nome_cidade TO nome;

ALTER TABLE cidade ALTER COLUMN nome TYPE VARCHAR(80);

ALTER TABLE cidade ALTER COLUMN nome SET NOT NULL;

ALTER TABLE cidade ALTER COLUMN nome TYPE VARCHAR(80);

ALTER TABLE cidade ALTER COLUMN nome SET NOT NULL;











