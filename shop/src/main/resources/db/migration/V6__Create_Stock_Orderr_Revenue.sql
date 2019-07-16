create table Stock (
    Product integer not null,
    Location integer not null,
    Quantity integer,
    Primary key (Product, Location),
    CONSTRAINT fk_Stock_Product FOREIGN KEY (Product) REFERENCES Product(Id),
    CONSTRAINT fk_Stock_Location FOREIGN KEY (Location) REFERENCES Location(Id)
);

create table Orderr (
    Id integer not null AUTO_INCREMENT,
    ShippedFrom integer,
    Customer integer,
    CreatedAt TIMESTAMP ,
    AddressCountry varchar(100),
    AddressCity varchar(100),
    AddressCounty varchar(100),
    AddressStreetAddress varchar(100),
    Primary key (Id),
    CONSTRAINT fk_Orderr_Location FOREIGN KEY (ShippedFrom) REFERENCES Location(Id),
    CONSTRAINT fk_Orderr_Customer FOREIGN KEY (Customer) REFERENCES Customer(Id)
);

create table Revenue (
    Id int not null AUTO_INCREMENT,
    Location DATE,
    Sum DECIMAL
);
