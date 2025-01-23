ALTER TABLE product
    ADD quantity INT NULL;

ALTER TABLE product
    MODIFY quantity INT NOT NULL;

DROP TABLE category_seq;

DROP TABLE product_seq;