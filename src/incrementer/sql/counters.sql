-- :name counter-by-id
-- :result :one
select * from counters
where counter_id = :id;

-- :name modify-counter
-- :command :execute
-- :result :affected
update counters
set val = :new-val
where counter_id = :id;
