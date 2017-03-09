drop table if exists user;

create table user (id int primary key auto_increment, name varchar, state varchar, country varchar);

--insert into user (name, state, country) values ('Web', 'Delhi', 'India');