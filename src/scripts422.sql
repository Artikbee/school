CREATE TABLE people(
    id bigint primary key,
    name varchar,
    age varchar,
    passport varchar,
    car_id bigint references car (id)
);

CREATE TABLE car(
    id bigint primary key,
    marka varchar,
    model varchar,
    sale varchar
);