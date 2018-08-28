create table counters (
  counter_id bigserial primary key,
  val integer
);

insert into counters (val) values
  (0);
