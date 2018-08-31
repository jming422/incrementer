alter table counters add column user_id uuid references users;
insert into counters (val, user_id)
  select 0 as val, user_id from users;
