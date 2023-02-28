CREATE TABLE if not exists dish (
    id serial primary key not null,
    name varchar(2000) unique not null,
    description varchar(2000) not null,
    calories integer not null,
    price integer not null
);