-- drop table students;
-- drop table universities;
-- drop sequence students_sequence;
-- drop sequence universities_sequence;

create table students (
    id int,
    university_id int,
    first_name varchar(100),
    middle_name varchar(100),
    last_name varchar(100)
);


create table universities (
    id int,
    creation_date varchar(100),
    name1 varchar(100)
);

create sequence students_sequence start 1 increment 1;
create sequence universities_sequence start 1 increment 1;