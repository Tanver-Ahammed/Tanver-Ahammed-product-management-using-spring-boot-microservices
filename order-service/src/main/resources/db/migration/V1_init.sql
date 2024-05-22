create table orders
(
    id           bigint(20) not null auto_increment,
    order_number varchar(255),
    quantity     integer,
    sku_code     varchar(255),
    total_amount decimal(38, 2),
    primary key (id)
)