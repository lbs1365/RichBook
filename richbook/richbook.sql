create table member (
	id varchar2(50) primary key,
	pw varchar2(50) not null,
	name varchar2(20),
	birth Date,
	job varchar2(20),
	gen varchar2(20)
);
select * from member;
drop table member;