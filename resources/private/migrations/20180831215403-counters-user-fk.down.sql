delete from counters where user_id is not null;
alter table counters drop column user_id cascade;
