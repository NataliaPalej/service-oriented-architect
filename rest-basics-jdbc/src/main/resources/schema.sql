/* Script is executed when the server starts up*/
create table student(
	id bigint not null,
	name varchar(255) not null,
	birthdate varchar(255) not null,
	primary key (id)
);