create table inventory
(
    id       bigint(20) not null auto_increment,
    quantity integer,
    sku_code varchar(255),
    primary key (id)
)
