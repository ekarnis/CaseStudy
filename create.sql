create table time_slots(
	time_slot_id int primary key,
	slot_start int,
	slot_end int,
	slot_name varchar(4000)
);
create table items(
	item_id int primary key,
	name varchar(4000),
	vegetarian char(1),
	description varchar(4000),
	time_slot_id int references time_slots(time_slot_id),
	photo varchar(4000),
	price number(5,2),
	constraint check_vegetarian
	check(vegetarian in ('y', 'n'))
);
create table specials(
	item_id int references items(item_id),
	discount_percentage int
);
create table combos(
	combo_id int references items(item_id),
	item_id int references items(item_id)
);
create table delivery_statuses(
	delivery_status_id int primary key,
	delivery_status varchar(4000)
);
create table delivery_methods(
	delivery_method_id int primary key,
	delivery_method varchar(4000)
);
create table locations(
	location_id int primary key,
	street varchar(4000),
	city varchar(4000),
	state varchar(4000)
	country varchar(4000),
	zip varchar(4000),
);
create table user_statuses(
	user_status_id int primary key,
	user_status varchar(4000)
);
create table users(
	user_id int primary key,
	first varchar(4000),
	last varchar(4000),
	email varchar(4000),
	password varchar(4000),
	user_status_id int references user_statuses(user_status_id),
	location_id varchar(4000)
);
create table cards(
	card_id int primary key,
	user_id int references users(user_id),
	card_number int,
	expiry_date date,
	security_code int
);
create table stores(
	store_id int primary key,
	location_id int references locations(location_id),
	store varchar(4000),
	phone_number int,
	manager_id int references users(user_id),
	open_time timestamp,
	close_time timestamp
);
create table orders(
	order_id int primary key,
	user_id int references users(user_id),
	placed_timestamp int,
	delivery_timestamp int,
	card_id int references cards(card_id),
	instructions varchar(4000),
	delivery_method_id int references delivery_methods(delivery_method_id),
	store_id int references stores(store_id),
	delivery_status_id int references delivery_statuses(delivery_status_id)
);
create table order_items(
	order_id int references orders(order_id),
	item_id int references items(item_id) 
);