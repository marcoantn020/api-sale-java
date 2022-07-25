CREATE TABLE item_sale (
	code BIGINT PRIMARY KEY AUTO_INCREMENT,
	code_product BIGINT NOT NULL,
	code_sale BIGINT NOT NULL,
	quantity INTEGER NOT NULL,
	price_sold DECIMAL(10,2) NOT NULL,
	FOREIGN KEY (code_product) REFERENCES product(code),
	FOREIGN KEY (code_sale) REFERENCES sale(code)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO item_sale(code_product, code_sale, quantity, price_sold) VALUES (1, 1, 1, 870);
INSERT INTO item_sale(code_product, code_sale, quantity, price_sold) VALUES (15, 1, 1, 249);
INSERT INTO item_sale(code_product, code_sale, quantity, price_sold) VALUES (2, 2, 1, 1623.20);
INSERT INTO item_sale(code_product, code_sale, quantity, price_sold) VALUES (3, 3, 1, 1073.36);
INSERT INTO item_sale(code_product, code_sale, quantity, price_sold) VALUES (4, 4, 1, 1899);
INSERT INTO item_sale(code_product, code_sale, quantity, price_sold) VALUES (5, 5, 1, 3300);
INSERT INTO item_sale(code_product, code_sale, quantity, price_sold) VALUES (6, 6, 1, 700);
INSERT INTO item_sale(code_product, code_sale, quantity, price_sold) VALUES (7, 7, 1, 800);
INSERT INTO item_sale(code_product, code_sale, quantity, price_sold) VALUES (8, 8, 1, 900);
INSERT INTO item_sale(code_product, code_sale, quantity, price_sold) VALUES (9, 9, 3, 419.70);
INSERT INTO item_sale(code_product, code_sale, quantity, price_sold) VALUES (16, 9, 1, 160.50);
INSERT INTO item_sale(code_product, code_sale, quantity, price_sold) VALUES (10, 10, 1, 106.80);
INSERT INTO item_sale(code_product, code_sale, quantity, price_sold) VALUES (17, 10, 1, 299.90);
INSERT INTO item_sale(code_product, code_sale, quantity, price_sold) VALUES (11, 11, 1, 424.86);
INSERT INTO item_sale(code_product, code_sale, quantity, price_sold) VALUES (12, 12, 1, 1164.94);
INSERT INTO item_sale(code_product, code_sale, quantity, price_sold) VALUES (13, 13, 1, 415.90);
INSERT INTO item_sale(code_product, code_sale, quantity, price_sold) VALUES (14, 14, 1, 1370);