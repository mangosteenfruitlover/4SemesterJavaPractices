-- drop table sem4.students;
-- drop table sem4.universities;
-- drop sequence sem4.students_sequence;
-- drop sequence sem4.universities_sequence;

create table sem4.students (
    id int,
    university_id int,
    first_name varchar(100),
    middle_name varchar(100),
    last_name varchar(100)
);


create table sem4.universities (
    id int,
    creation_date varchar(100),
    name1 varchar(100)
);

create sequence sem4.students_sequence start 1 increment 1;
create sequence sem4.universities_sequence start 1 increment 1;