create or replace procedure sp_insert_user_status(user_status_id number, user_status varchar)
as 
begin
  insert into user_statuses
  values(user_status_id, user_status);
  
end;

create or replace procedure sp_update_user_status(user_status_num number, user_status_name varchar)
as 
begin
  update user_statuses
  set user_status=user_status_name
  where user_status_id=user_status_num;
end;

create or replace procedure sp_update_user(user_num number, firstN varchar, lastN varchar, eml varchar, psswd varchar, u_s_id number, loc_id number)
as 
begin
  update users
  set first=firstN, last=lastN, email=eml,password=psswd, user_status_id=u_s_id,location_id=loc_id
  where user_id=user_num;
end;

create or replace procedure sp_insert_user(user_id number, first varchar, last varchar, email varchar, password varchar, user_status_id number, location_id number)
as 
begin
  insert into users
  values(user_id, first, last, email, password, user_status_id, location_id);
  
end;

create or replace procedure sp_delete_user_status_by_id(user_status_num number)
as 
begin
  Delete from user_statuses where user_status_id = user_status_num;
end;

create or replace procedure sp_delete_user_by_id(user_num number)
as 
begin
  Delete from users where user_id = user_num;
end;

show errors;
