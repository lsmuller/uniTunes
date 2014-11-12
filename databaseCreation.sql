select * from category;
select * from academic;
select * from midia;
select * from purchase; 

drop table category;
drop table academic;
drop table midia;
drop table purchase;




CREATE TABLE IF NOT EXISTS category ( 
	id 		SERIAL primary key, 
	name 	varchar(30) not null
);

insert into category (name) values ('Music');
insert into category (name) values ('Book');
insert into category (name) values ('Video');
insert into category (name) values ('Podcast');




CREATE TABLE IF NOT EXISTS academic (
	id 			SERIAL primary key not null,
	firstname 	varchar(50) 	not null,
	lastname  	varchar(50) 	not null,
	email	  	varchar(50)   	not null unique,
	password  	varchar(50)   	not null,
	balance   	numeric(12,2)	not null,
	admin 		bool     		not null,
	excluded 	bool 			not null
);

insert into academic (firstname, lastname, email, password, balance, admin, excluded) 
	values ('Paulo', 'Grabin', 'plgrabin@gmail.com', 'teste', 0.00, true, false);

select * from academic;




CREATE TABLE IF NOT EXISTS midia (
	id           	SERIAL 			primary key not null,
	name        	varchar(50) 	not null,
	description  	varchar(200) 	not null,
	price        	numeric(12,2)	not null,
	author       	int 			references academic(id) not null,
	category     	int 			references category(id) not null,
	duration     	int 			not null,
	pages        	int 			not null,
	creation	 	timestamp 		not null,
	excluded 		bool 			not null
);

INSERT INTO midia (name, description, price, author, category, duration, pages, creation, excluded)
	values ('Batma: Feira da Fruta', 'Entrei na feira da fruta', 4.99, 1, 3, 30, 0, now(), false);

SELECT *
FROM midia m 
	 INNER JOIN category c
	 ON m.category = c.id;




CREATE TABLE IF NOT EXISTS purchase (
	id   	      SERIAL unique,
	academic 	  int references academic(id) not null,
	midia 		  int references midia(id) not null,
	datePurchase        timestamp not null,	
	primary key(academic, midia)
);

INSERT INTO purchase(academic, midia, datePurchase) values (1, 1, now());

select * from purchase;
