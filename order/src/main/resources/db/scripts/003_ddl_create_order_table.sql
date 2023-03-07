CREATE TABLE if not exists my_order (
    id serial primary key not null,
    status_id int not null references status(id),
    created timestamp not null,
    sum int not null,
    product_id int not null references product(id)
);