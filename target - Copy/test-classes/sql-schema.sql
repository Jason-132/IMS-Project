create database if not exists project;
create table if not exists project.customers(customer_id int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists project.item(item_id int primary key auto_increment, item_name varchar(60) not null, price decimal(6,2) not null);
create table if not exists project.orders(order_id int primary key auto_increment, customer_id int not null, foreign key (customer_id) references customers(customer_id));
create table if not exists project.orderline(orderline_id int primary key auto_increment, order_id int not null, item_id int not null, foreign key (item_id) references item(item_id), foreign key (order_id) references orders(order_id));
