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

create table intable (
	inNo number primary key,
	imtNo number,
	inDate Date,
	inSum number,
	inCon varchar2(50),
	inEtc varchar2(50),
	memNo number
);

drop table intable;

insert into intable values ('1','1','2015.04.14','30000','회비','회식 회비','1');
update intable set inCon = '월급', inEtc = '좋아요';
select * from intable;

create table inmet (
	imtNo number primary key,
	imtName varchar2(50),
	memNo number
);

drop table inmet;

insert into inmet values ('1','현금','1');
insert into inmet values ('2','우리은행','1');
insert into inmet values ('3','하나은행','1');
insert into inmet values ('4','국민은행','1');

select * from inmet;