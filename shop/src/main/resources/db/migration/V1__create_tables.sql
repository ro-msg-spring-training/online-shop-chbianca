drop table customer if exists;

drop table location if exists;

drop table order_detail if exists;

drop table orderr if exists;

drop table product if exists;

drop table product_category if exists;

drop table revenue if exists;

drop table stock if exists;

drop table supplier if exists;

drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;

create table customer (
   id integer not null,
    first_name varchar(255),
    last_name varchar(255),
    username varchar(255),
    password varchar(255),
email_address varchar(255),
    primary key (id)
);


create table location (
   id integer not null,
name varchar(255),
country varchar(255),
    city varchar(255),
    county varchar(255),
    street_address varchar(255),
    primary key (id)
);


create table order_detail (
   orderr integer not null,
    product integer not null,
    quantity integer,
    primary key (orderr, product)
);


create table orderr (
   id integer not null,
shipped_from integer,
customer integer,
created_at timestamp,
    country varchar(255),
    city varchar(255),
    county varchar(255),
    street_address varchar(255),
    primary key (id)
);


create table product (
   id integer not null,

    name varchar(255),
    description varchar(255),

    price decimal(19,2),
    weight double,
    category_id integer,
    supplier_id integer,
image_url varchar(255),
    primary key (id)
);

create table product_category (
   id integer not null,

    name varchar(255),
description varchar(255),
    primary key (id)
);


create table revenue (
   id integer not null,
location integer,
    date date,
    sum decimal(19,2),

    primary key (id)
);


create table stock (
   location integer not null,
    product integer not null,
    quantity integer,
    primary key (location, product)
);


create table supplier (
   id integer not null,
    name varchar(255),
    primary key (id)
);


alter table order_detail
   add constraint FK_order_detail_orderr
   foreign key (orderr)
   references orderr;

alter table order_detail
   add constraint FK_order_detail_product
   foreign key (product)
   references product;

alter table orderr
   add constraint FK_orderr_customer
   foreign key (customer)
   references customer;

alter table orderr
   add constraint FK_orderr_location
   foreign key (shipped_from)
   references location;

alter table product
   add constraint product_product_category
   foreign key (category_id)
   references product_category;

alter table product
   add constraint FK_product_supplier
   foreign key (supplier_id)
   references supplier;

alter table revenue
   add constraint FK_revenue_location
   foreign key (location)
   references location;

alter table stock
   add constraint stock_location
   foreign key (location)
   references location;

alter table stock
   add constraint FK_stock_product
   foreign key (product)
   references product;





