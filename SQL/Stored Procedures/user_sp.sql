
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

create or replace procedure fetch_user_by_email(email varchar)
as 
begin
  select * from users
  where email = email;
  
end;

create or replace procedure sp_delete_user_by_id(user_num number)
as 
begin
  Delete from users where user_id = user_num;
end;

