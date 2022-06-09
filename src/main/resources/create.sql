create table person
(
    id            bigint primary key auto_increment,
    username      varchar(100) not null,
    year_of_birth int          not null,
    password      varchar(500) not null
);

insert into person(username, year_of_birth, password)
values ('test_user1', 1990, 'pass1'),
       ('test_user2', 2000, 'pass2');

alter table person
    add column role varchar(30) not null;

update person
set role='ROLE_ADMIN'
where id = 2;