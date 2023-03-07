CREATE TABLE if not exists notification (
    id serial primary key not null,
    text varchar(2000) not null,
    created timestamp not null
);