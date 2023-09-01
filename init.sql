---- Create the wattwise database
--CREATE DATABASE wattwise;

-- Connect to the wattwise database
\c wattwise;

CREATE TABLE IF NOT EXISTS tb_person(
    id UUID primary key,
    name VARCHAR(255) not null,
    gender VARCHAR(255),
    birth_date date not null,
    email VARCHAR(255),
    phone VARCHAR(15),
    kinship VARCHAR(20)
    );

CREATE TABLE IF NOT EXISTS tb_address(
    id UUID primary key,
    street VARCHAR(255) not null,
    number numeric not null,
    complement VARCHAR(255),
    neighborhood VARCHAR(255),
    city VARCHAR(255) not null,
    state VARCHAR(255) not null,
    zip_code VARCHAR(15) not null
);

CREATE TABLE IF NOT EXISTS tb_electronic(
    id UUID primary key,
    name VARCHAR(255) not null,
    model VARCHAR(255) not null,
    power VARCHAR(255) not null,
    address_id UUID not null,
    energy_consumption numeric,
    foreign key(address_id) references tb_address(id) on delete cascade
);

CREATE TABLE IF NOT EXISTS tb_person_address(
    person_id UUID not null,
    address_id UUID not null,
    primary key(person_id, address_id),
    foreign key(person_id) references tb_person(id) on delete cascade,
    foreign key(address_id) references tb_address(id) on delete cascade
);

create table IF NOT EXISTS tb_person_electronic(
    person_id UUID not null,
    electronic_id UUID not null,
    primary key(person_id, electronic_id),
    foreign key(person_id) references tb_person(id) on delete cascade,
    foreign key(electronic_id) references tb_electronic(id) on delete cascade
);