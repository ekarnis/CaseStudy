insert into time_slots values ('0', 0600, 0900, 'Breakfast');

insert into item_types
	values ('0', 'Drink');
insert into item_types
	values ('1', 'Side');
insert into item_types
	values ('2', 'Entree');
insert into item_types
	values ('3', 'Package');


insert into items values ('0', 'Rice', 'y', '0', 'Steamed Basmati Rice', '0', 'photo', 1);

insert into items values ('1', 'Drink', 'y', '0', 'A refreshing drink', '0', 'photo', 1.50);

insert into specials
	values ('0', 10);

insert into delivery_statuses
	values ('0', 'pending');
insert into delivery_statuses
	values ('1', 'on delivery');
insert into delivery_statuses
	values ('2', 'delivered');
insert into delivery_statuses
	values ('3', 'cancelled');


insert into delivery_methods
	values ('0', 'pickup');
insert into delivery_methods
	values ('1', 'delivery');
insert into delivery_methods
	values ('2', 'dine-in');


insert into user_statuses
	values ('0', 'Unverified');
insert into user_statuses
	values ('1', 'Verified');
insert into user_statuses
	values ('2', 'BANNED');
insert into user_statuses
	values ('3', 'Admin');
insert into user_statuses
	values ('4', 'Employee');
insert into user_statuses
	values ('5', 'Manager');


insert into users
	values ('0','Eric','Karnis','6035559577','eric@karnis.com','hey','0');


insert into locations
	values ('0','0',50.5,'100 example st', 'townville', 'WA', 'USA','01440');

insert into cards
	values ('0','0',5,(TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss')) ,123);

insert into stores
	values ('0','0','Deer Valley',1,0,0800,2100);

insert into orders 
	values ('0','0',2.50,15.50,0,0,'0','hey','0','0','0');

insert into order_items
	values ('0','0');
