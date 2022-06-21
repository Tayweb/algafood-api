ALTER TABLE restaurante ADD ativo boolean;
UPDATE restaurante set ativo = true;
ALTER TABLE restaurante ALTER COLUMN ativo SET not null;