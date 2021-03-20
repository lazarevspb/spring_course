create table hibernate.products
(
    id        bigserial    not null
        constraint products_pk
            primary key,
    name      varchar(128) not null,
    cost      integer,
    orders_id bigint
);

alter table hibernate.products
    owner to postgres;

create unique index products_id_uindex
    on hibernate.products (id);

create table hibernate.orders
(
    id          bigserial not null
        constraint orders_pk
            primary key,
    product_id  bigint
        constraint orders_products_id_fk
            references hibernate.products,
    customer_id bigint,
    cost        integer
);

alter table hibernate.orders
    owner to postgres;

alter table hibernate.products
    add constraint products_orders_id_fk
        foreign key (orders_id) references hibernate.orders;

create unique index orders_id_uindex
    on hibernate.orders (id);

create table hibernate.customers
(
    id        bigserial not null
        constraint customers_pk
            primary key,
    name      varchar(128),
    orders_id bigint
        constraint customers_orders_id_fk
            references hibernate.orders
);

alter table hibernate.customers
    owner to postgres;

alter table hibernate.orders
    add constraint orders_customers_id_fk
        foreign key (customer_id) references hibernate.customers;

create unique index customers_id_uindex
    on hibernate.customers (id);

