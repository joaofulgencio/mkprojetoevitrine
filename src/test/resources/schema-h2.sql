CREATE TABLE product(id INT PRIMARY KEY AUTO_INCREMENT, seller_id INT, description VARCHAR(255), product_name VARCHAR(255), quantity INT)

CREATE TABLE product_database_domain_images(seller_id INT, product_id INT, images VARCHAR(255), FOREIGN KEY (product_id) REFERENCES product(id))
