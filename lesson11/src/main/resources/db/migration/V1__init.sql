create table products
(
    id         bigserial primary key,
    title      varchar(128),
    price      int,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp


);
insert into products(title, price)
values ('Product_1', 10),
       ('Product_2', 20),
       ('Product_3', 30),
       ('Product_4', 40),
       ('Product_5', 50),
       ('Product_6', 60),
       ('Product_7', 70),
       ('Product_8', 80),
       ('Product_9', 90),
       ('Product_10', 100),
       ('Product_11', 110),
       ('Product_12', 120),
       ('Product_13', 130),
       ('Product_14', 140),
       ('Product_15', 150),
       ('Product_16', 160),
       ('Product_17', 170),
       ('Product_18', 180),
       ('Product_19', 190),
       ('Product_20', 200),
       ('Product_21', 210)
;

create table users_table
(
    id         bigserial primary key,
    name       varchar(128),
    surname    varchar(128),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp


);
insert into users_table(name, surname)
values ('UserName_1 ', 'UserSureName_1 '),
       ('UserName_2 ', 'UserSureName_2 '),
       ('UserName_3 ', 'UserSureName_3 '),
       ('UserName_4 ', 'UserSureName_4 '),
       ('UserName_5 ', 'UserSureName_5 '),
       ('UserName_6 ', 'UserSureName_6 '),
       ('UserName_7 ', 'UserSureName_7 '),
       ('UserName_8 ', 'UserSureName_8 '),
       ('UserName_9 ', 'UserSureName_9 '),
       ('UserName_10', 'UserSureName_10'),
       ('UserName_11', 'UserSureName_11'),
       ('UserName_12', 'UserSureName_12'),
       ('UserName_13', 'UserSureName_13'),
       ('UserName_14', 'UserSureName_14'),
       ('UserName_15', 'UserSureName_15'),
       ('UserName_16', 'UserSureName_16'),
       ('UserName_17', 'UserSureName_17'),
       ('UserName_18', 'UserSureName_18'),
       ('UserName_19', 'UserSureName_19'),
       ('UserName_20', 'UserSureName_20'),
       ('UserName_21', 'UserSureName_21')
;