CREATE TABLE IF NOT EXISTS people(
    id bigint primary key,
    name varchar,
    age varchar,
    passport varchar,
    car_id bigint references car (id)
);

CREATE TABLE IF NOT EXISTS car(
    id bigint primary key,
    marka varchar,
    model varchar,
    sale varchar
);