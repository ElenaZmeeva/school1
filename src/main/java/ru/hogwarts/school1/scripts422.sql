CREATE TABLE car
(
    id INTEGER PRIMARY KEY,
    brand TEXT NOT NULL,
    model TEXT NOT NULL,
    price NUMERIC
);

CREATE TABLE person
(
    id      INTEGER,
    name    TEXT PRIMARY KEY,
    age     INTEGER CHECK ( age > 0),
    license BOOLEAN,
    car_id INTEGER REFERENCES car(id)
);

