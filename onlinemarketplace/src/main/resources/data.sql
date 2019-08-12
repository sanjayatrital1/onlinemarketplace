
INSERT INTO `USER` (id, name, email,status,type) VALUES (1, 'First User', 'first.user@gmail.com',null,'SELLER');
INSERT INTO `USER` (id, name, email,status,type) VALUES (2, 'Second User', 'second.user@gmail.com',null,'SELLER');

INSERT INTO `ADDRESS` (id, city, state, status, street, zip_code,user_id) VALUES (1, 'Fairfield', 'IA', 'Shipping', '1000 North 4th', '52557',1);
INSERT INTO `ADDRESS` (id, city, state, status, street, zip_code,user_id) VALUES (2, 'Fairfield', 'IA', 'Shipping', '1000 North 4th', '52557',2);


INSERT INTO `PRODUCT` (id, name, description, price,  quantiy) VALUES (1, 'Product01', 'Product01 description', 10,  2);
INSERT INTO `PRODUCT` (id, name, description, price, quantiy) VALUES (2, 'Product02', 'Product02 description', 10,  3);
INSERT INTO `PRODUCT` (id, name, description, price, quantiy) VALUES (3, 'Product03', 'Product03 description', 10,  2);
INSERT INTO `PRODUCT` (id, name, description, price,  quantiy) VALUES (4, 'Product04', 'Product04 description', 10,  3);



INSERT INTO `CART` (id, total_price) VALUES (1, 30);
INSERT INTO `CART` (id, total_price) VALUES (2, 50);


INSERT INTO `USER_ORDER` (id, status, create_date) VALUES (1, 'waiting', '2019-08-10');