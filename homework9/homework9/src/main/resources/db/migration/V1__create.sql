CREATE TABLE IF NOT EXISTS products (id bigserial, cost int, title VARCHAR(255), PRIMARY KEY (id));

INSERT INTO products (title, cost) VALUES ('Bread',10),('Apple',20),('Orange',30),('Milk',40),('Potato',50),('Tea',60),('Coffee',70),('Sugar',80),('Tomato',90),
('Banana',100),('Mandarin',110),('Grapes',120),('Kiwi',130),('Cherry',140),('Peach',150),('Ice-cream',160),('Pie',170),('Sweets',180),('Jam',190),('Fish',200);
