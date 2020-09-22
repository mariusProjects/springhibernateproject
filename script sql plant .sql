drop schema plant;
create schema plant;
use plant;

CREATE TABLE employees (
id INT not null auto_increment,
`name` varchar (25) not null,
age int not null,
position varchar(25) not null,
primary key(id),
unique(id)
);

create table managers(
id INT not null auto_increment,
`name` varchar (25) not null,
age int not null,
'position' varchar(25) not null,
department_managed int not null,
primary key(id),
unique(id)
);

create table departments(
id int not null auto_increment,
`name` varchar(25) not null,
primary key(id),
unique(id)
);