create table if not exists university(
id serial primary key,
"name" varchar(64) not null unique,
country varchar(64),
foundation_year int,
logo varchar(255)
);

create index name_university on university("name");

create table if not exists career(
    id serial primary key,
    id_university bigint,
    "name" varchar(64) not null,
    area  varchar(32) not null,
    description text,
    constraint fk_university foreign key (id_university) references university(id)
    on delete cascade
    )


