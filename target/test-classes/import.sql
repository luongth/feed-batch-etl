insert into pt_feed_status (job_id, business_date, status, type, region, source_system) values ('pt-eu-arc-dsl-trade', DATE'2016-01-25', 'Finished', 'EOD_D', 'EU', 'ARC');
insert into pt_feed_status (job_id, business_date, status, type, region, source_system) values ('pt-us-arc-dsl-trade', DATE'2016-01-25', 'Finished', 'EOD_D', 'US', 'ARC');

insert into replay_definitions (id, description, replay_type_id) values (1, 'replay definition 1', '5');
insert into replay_criteria (id, criteria_type_id, value, replay_definition_id) values(1, 2, '2420', 1);