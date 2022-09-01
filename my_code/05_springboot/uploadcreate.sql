create table upload(
	name varchar(30),
    description varchar(1000),
	file1 varchar(200),
    file2 varchar(200),
    uploadtime datetime
);

drop table upload;
alter table upload add uploadtime datetime;

select * from upload;
select*from upload where name='렉키';
