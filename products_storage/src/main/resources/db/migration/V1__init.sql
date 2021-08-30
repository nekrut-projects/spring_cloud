CREATE TABLE IF NOT EXISTS
products (
    id bigserial,
    title VARCHAR(255),
    price numeric(8, 2) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    PRIMARY KEY (id)
);

INSERT INTO products (title, price)
VALUES
('Product_1', 100),
('Product_2', 20),
('Product_3', 440),
('Product_4', 78),
('Product_5', 12),
('Product_6', 1500),
('Product_7', 205),
('Product_8', 40),
('Product_9', 8),
('Product_10', 712);
