insert into time_slots
values (0, 0600, 0900, 'Breakfast');

insert into items
values (0, 'Rice', 'y', 'Steamed Basmati Rice', 0, null, 1);

insert into specials
	values (0, 10);

insert into combos
	values (0,0);



insert into delivery_statuses
	values (0, 'pending');

insert into delivery_statuses
	values (1, 'on delivery');

insert into delivery_statuses
	values (2, 'delivered');

insert into delivery_statuses
	values (3, 'cancelled');

insert into delivery_methods
	values (0, 'pickup');

insert into delivery_methods
	values (1, 'delivery');

insert into delivery_methods
	values (2, 'dine-in');



insert into locations
	values (0,'100 example st', 'townville', 'WA', 'USA',5);



insert into user_statuses
	values (0, 'Unverified');

insert into user_statuses
	values (1, 'Verified');

insert into user_statuses
	values (2, 'BANNED');

insert into user_statuses
	values (3, 'Admin');

insert into user_statuses
	values (4, 'Employee');

insert into user_statuses
	values (5, 'Manager');



insert into users
	values (0,'Eric','Karnis','eric@karnis.com','hey',0,0);

insert into cards
	values (0,0,5,(TO_DATE('2003/05/03 21:02:44', 'yyyy/mm/dd hh24:mi:ss')) ,123);

insert into stores
	values (0,0,'Deer Valley',1,0,0800,2100);

insert into orders 
	values (0,0,0,0,0,'hey',0,0,0);

insert into order_items
	values (0,0);