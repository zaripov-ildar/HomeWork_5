DROP TABLE IF EXISTS products;
CREATE TABLE products (id long auto_increment primary key, name varchar(250),price int);
INSERT INTO products(name, price) VALUES ( 'gibson', 906990 ), ('stratocaster', 42990),('fender', 17400),('ibanez', 43000);
select * from products;