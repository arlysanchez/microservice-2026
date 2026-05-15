
-- Data para University Schema
insert into university_schema.university("name", country, foundation_year, logo) 
values('MIT', 'USA', 1861, 'mit.png');

insert into university_schema.career(id_university, "name", area) 
values(1, 'Computer Science', 'ENGINEERING');

-- Data para Jobs Schema
insert into jobs_schema.job_offer(id_university, title, company_name, salary) 
values(1, 'Senior Java Developer', 'Google', 5000.00);
Mostrando data_avjw1szria.txt