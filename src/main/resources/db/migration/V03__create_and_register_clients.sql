CREATE TABLE client (
	code BIGINT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	phone VARCHAR(20) NOT NULL,
	active BOOLEAN NOT NULL,
	address VARCHAR(30),
	number INTEGER,
	complemento VARCHAR(30),
	district VARCHAR(30),
	zipcode VARCHAR(30),
	city VARCHAR(30),
	state VARCHAR(30)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO client (name, phone, active, address, number, complemento, district, zipcode, city, state) values ('João Silva', '(34) 99261-4270', true, 'Rua do Abacaxi', '10', null, 'Brasil', '38.400-122', 'Uberlândia', 'MG');
INSERT INTO client (name, phone, active, address, number, complemento, district, zipcode, city, state) values ('Maria Rita', '(34) 99261-4270', true, 'Rua do Sabiá', '110', 'Apto 101', 'Colina', '11.400-122', 'Ribeirão Preto', 'SP');
INSERT INTO client (name, phone, active, address, number, complemento, district, zipcode, city, state) values ('Pedro Santos', '(34) 99261-4270', true, 'Rua da Bateria', '23', null, 'Morumbi', '54.212-122', 'Goiânia', 'GO');
INSERT INTO client (name, phone, active, address, number, complemento, district, zipcode, city, state) values ('Ricardo Pereira', '(34) 99261-4270', true, 'Rua do Motorista', '123', 'Apto 302', 'Aparecida', '38.400-122', 'Salvador', 'BA');
INSERT INTO client (name, phone, active, address, number, complemento, district, zipcode, city, state) values ('Josué Mariano', '(34) 99261-4270', true, 'Av Rio Branco', '321', null, 'Jardins', '56.400-122', 'Natal', 'RN');
INSERT INTO client (name, phone, active, address, number, complemento, district, zipcode, city, state) values ('Pedro Barbosa', '(34) 99261-4270', true, 'Av Brasil', '100', null, 'Tubalina', '77.400-123', 'Porto Alegre', 'RS');
INSERT INTO client (name, phone, active, address, number, complemento, district, zipcode, city, state) values ('Henrique Medeiros', '(34) 99261-4270', true, 'Rua do Sapo', '1120', 'Apto 201', 'Centro', '12.400-124', 'Rio de Janeiro', 'RJ');
INSERT INTO client (name, phone, active, address, number, complemento, district, zipcode, city, state) values ('Carlos Santana', '(34) 99261-4270', true, 'Rua da Manga', '433', null, 'Centro', '31.400-124', 'Belo Horizonte', 'MG');
INSERT INTO client (name, phone, active, address, number, complemento, district, zipcode, city, state) values ('Leonardo Oliveira', '(34) 99261-4270', true, 'Rua do Músico', '566', null, 'Segismundo Pereira', '38.400-005', 'Uberlândia', 'MG');
INSERT INTO client (name, phone, active, address, number, complemento, district, zipcode, city, state) values ('Isabela Martins', '(34) 99261-4270', true, 'Rua da Terra', '1233', 'Apto 10', 'Vigilato', '99.400-125', 'Manaus', 'AM');