create table OrderDetail (
    Orderr integer not null,
    Product integer not null,
    Quantity integer,
    Primary key (Orderr, Product),
    CONSTRAINT fk_OrderDetail_Orderr FOREIGN KEY (Orderr) REFERENCES Orderr(Id),
    CONSTRAINT fk_OrderDetail_Product FOREIGN KEY (Product) REFERENCES Product(Id)
);