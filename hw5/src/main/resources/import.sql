DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products (id bigserial, price int, title VARCHAR(255), PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Milk', 10), ('Bread', 20), ('Orange', 30), ('Apples',40),('Chocolate',50);
