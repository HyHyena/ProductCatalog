CREATE TABLE IF NOT EXISTS products (
   id serial NOT NULL UNIQUE,
   name varchar(40) NOT NULL,
   description varchar(200),
   CONSTRAINT users_pk PRIMARY KEY (id)
);