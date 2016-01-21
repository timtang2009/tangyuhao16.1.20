
create table category (
	id int identity(1, 1) not null primary key,
	name varchar(30) not null,
	createdAt datetime not null default getdate()
);

create table users (
	id int identity(1, 1) not null primary key,
	name varchar(10) not null,
	password varchar(20) not null,
	email varchar(20) not null,
	status int default 0 not null,
	createdAt datetime not null default getdate()
);


create table article (
	id int identity(1, 1) not null primary key,
	categoryId int not null,
	userId int not null,
	title varchar(300) not null,
	content text not null,
	status int default 0 not null,
	createdAt   datetime not null default getdate(),
	updatedAt	datetime
)

create table comment (
	id int identity(1, 1) not null primary key,
	articleId int not null,
	userId int not null,
	content text not null,
	status int default 0 not null,
	createdAt   datetime not null default getdate(),
	updatedAt	datetime
)


insert into category(name) values ( 'test');

insert into category(name) values ( 'Programmer');

insert into category(name) values ( 'java');

insert into category(name) values ( 'ruby');
