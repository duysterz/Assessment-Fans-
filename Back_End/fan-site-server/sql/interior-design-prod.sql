drop database if exists interior_design;
create database interior_design;
use interior_design;

create table room (
    room_id int primary key auto_increment,
    room_color varchar(25) not null,
    room_style varchar(50) not null,
    room_type varchar(50) not null,
    image_url varchar(250) not null
);