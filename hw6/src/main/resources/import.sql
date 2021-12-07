BEGIN;
DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE IF NOT EXISTS customers (id bigserial, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO customers (name) VALUES ('Tony'), ('Max'), ('Mark');

DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE IF NOT EXISTS products (id bigserial, name VARCHAR(255), cost bigint,PRIMARY KEY (id));
INSERT INTO products (name,cost) VALUES ('Milk', 10),('Apples', 20),('Orange', 30);


DROP TABLE IF EXISTS customers_products CASCADE;
CREATE TABLE  IF NOT EXISTS customers_products (customer_id bigint, product_id bigint, FOREIGN KEY (customer_id) REFERENCES customers (id), FOREIGN KEY (product_id) REFERENCES products (id));
INSERT INTO customers_products (customer_id, product_id) VALUES(1, 1), (1, 2), (1, 3), (2, 1);
COMMIT;


