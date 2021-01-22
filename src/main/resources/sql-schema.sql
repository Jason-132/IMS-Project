drop database if exist ims;
create database if not exists ims;
create table if not exists ims.customers(customer_id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists ims.item(item_id int primary key auto_increment, name varchar(60) not null, price decimal(6,2) not null);
create table if not exists ims.orders(order_id int primary key auto_increment, customer_id int not null, foreign key (customer_id) references customers(customer_id));
create table if not exists ims.orderline(orderline_id int primary key auto_increment, order_id int not null, item_id int not null, foreign key (item_id) references item(item_id), foreign key (order_id) references orders(order_id));
