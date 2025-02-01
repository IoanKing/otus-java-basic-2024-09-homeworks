create table users (
	id serial primary key,
	password varchar(255) not null,
	email varchar(255) not null unique,
	username varchar(255) not null unique
);

create table roles (
	id serial primary key,
	name varchar(255) not null unique
);

create table users_to_role (
	users_id int not null,
	roles_id int not null,
	primary key (users_id, roles_id),
	foreign key (users_id) references users(id) on delete cascade,
	foreign key (roles_id) references roles(id) on delete cascade
);