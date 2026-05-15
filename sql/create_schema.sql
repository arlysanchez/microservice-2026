-- Crear Esquemas
CREATE SCHEMA IF NOT EXISTS university_schema;
CREATE SCHEMA IF NOT EXISTS jobs_schema;

-- --- TABLAS PARA EL MÓDULO UNIVERSIDAD ---
create table if not exists university_schema.university(
    id serial primary key,
    "name" varchar(64) not null unique,
    country varchar(64),
    foundation_year int,
    logo varchar(255)
);

create table if not exists university_schema.career(
    id serial primary key,
    id_university bigint,
    "name" varchar(64) not null,
    area varchar(32) not null,
    description text,
    constraint fk_university foreign key(id_university) 
        references university_schema.university(id) on delete cascade
);

-- --- TABLAS PARA EL MÓDULO OFERTAS LABORALES (Nuevo Microservicio) ---
create table if not exists jobs_schema.job_offer(
    id serial primary key,
    id_university bigint, -- Se usará para Feign Client
    title varchar(128) not null,
    company_name varchar(128),
    salary decimal(10,2),
    publication_date date default current_date
);