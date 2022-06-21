
ALTER TABLE restaurante ADD aberto boolean;
UPDATE restaurante set aberto = false;  
ALTER TABLE restaurante ALTER COLUMN aberto SET not null;