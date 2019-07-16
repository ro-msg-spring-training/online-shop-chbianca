create table Product (
    Id integer not null AUTO_INCREMENT,
    Name varchar(100),
    Description varchar(100),
    Price decimal ,
    Weight double ,
    Category integer,
    Supplier integer,
    ImageUrl varchar(100),
    Primary key (Id),
    CONSTRAINT fk_Product_ProductCategory FOREIGN KEY (Category) REFERENCES ProductCategory(Id),
    CONSTRAINT fk_Product_Supplier FOREIGN KEY (Supplier) REFERENCES Supplier(Id)
);

