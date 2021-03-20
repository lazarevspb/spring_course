INSERT INTO hibernate.products(name, cost) VALUES
('product_1', 10),
('product_2', 20),
('product_3', 30);

INSERT INTO hibernate.customers(name) VALUES
('customers_1'),
('customers_2'),
('customers_3');


INSERT INTO hibernate.orders(product_id, customer_id, cost) VALUES
(1, 1, 10),
(2, 2, 20),
(3, 3, 30);