CREATE TABLE IF NOT EXISTS client (
    id SERIAL PRIMARY KEY,
    niu VARCHAR(255) UNIQUE,
    fullname VARCHAR(255),
    address VARCHAR(255)
    );

CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,
    description VARCHAR(100) NOT NULL,
    brand VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    stock INT NOT NULL
    );

CREATE TABLE IF NOT EXISTS invoice (
    id SERIAL PRIMARY KEY,
    code VARCHAR(255) UNIQUE,
    create_at TIMESTAMP NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    client_id INT NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(id)
    );

CREATE TABLE IF NOT EXISTS detail (
    id SERIAL PRIMARY KEY,
    quantity INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    invoice_id INT NOT NULL,
    product_id INT NOT NULL,
    FOREIGN KEY (invoice_id) REFERENCES invoice(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
    );
