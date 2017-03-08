drop table based_on cascade;
drop table movies cascade;
drop table Readers cascade;
drop table Have cascade;
drop table Publishing_companies cascade;
drop table publish_Books cascade;
drop table Authors cascade;
drop table written_by cascade;
drop table Book_stores cascade;
drop table Book_Factories cascade;
drop table Libraries cascade;
drop table Books cascade;
drop table sold_in cascade;
drop table made_by cascade;
drop table share cascade;


create table Movies(
  mid integer primary key,
  name varchar(128),
  release_date varchar(128)

);

create table Books(
  bid bigint primary key,
  type varchar(128),
  name varchar(128) not null,
  published_date integer not null

);

create table based_on(
  bid bigint,
  mid integer,
  primary key(mid,bid),
  foreign key(bid) references Books(bid),
  foreign key(mid) references Movies(mid)

);

create table Readers(
  rid integer primary key,
  password varchar(128) not null,
  username varchar(128) not null

);

create table Have(
  rid integer,
  bid bigint,
  primary key(rid,bid),
  foreign key(rid) references Readers(rid),
  foreign key(bid) references Books(bid)

);

create table Publishing_Companies(
  pid integer primary key,
  location varchar(128),
  name varchar(128) unique not null
);

create table publish_Books(
  bid bigint primary key,
  bname varchar(128) not null,
  cname varchar(128) not null,
  type varchar(128),
  published_date varchar(128),
  foreign key (cname) references Publishing_Companies(name),
  /*foreign key (bname) references Books(name),*/
  foreign key (bid) references Books(bid)
);

create table Authors(
  name varchar(128) not null,
  DOB varchar(128) not null,
  primary key(name, DOB)
);

create table written_by(
  bid bigint not null,
  name varchar(128),
  DOB varchar(128),
  primary key(bid,name,DOB),
  foreign key(bid) references Books(bid)
);

create table Book_stores(
  sid integer primary key,
  name varchar(128) not null,
  location varchar(128)

);

create table Book_Factories(
  fid integer primary key,
  name varchar(128),
  location varchar(128) not null

);

create table Libraries(
  lid integer primary key,
  name varchar(128) not null,
  location varchar(128)
);

create table sold_in(
  bid bigint not null,
  sid integer not null,
  primary key(bid,sid),
  foreign key (sid) references Book_stores(sid),
  foreign key (bid) references Books(bid)
);

create table made_by(
  fid integer not null,
  bid bigint,
  primary key(bid,fid),
  foreign key(fid) references Book_Factories(fid),
  foreign key(bid) references Books(bid)
);

create table share(
  lid integer not null,
  bid bigint,
  primary key(bid,lid),
  foreign key(lid) references Libraries(lid),
  foreign key(bid) references Books(bid)
);

/*Randomly generated*/
insert into Readers(rid,password,username) values (984,'akjdg','aoeia');
insert into Readers(rid,password,username) values (985,'aktyg','adfgj');
insert into Readers(rid,password,username) values (3456,'iuyjh','wedfg');
insert into Readers(rid,password,username) values (457,'fhg','gyjhd');
insert into Readers(rid,password,username) values (0987,'fhgsfvb','gyoiod');
insert into Readers(rid,password,username) values (6789,'jgrr','445ygtr');
insert into Readers(rid,password,username) values (3469,'345r','ghi9');
insert into Readers(rid,password,username) values (34678,'345r','goimbu');
insert into Readers(rid,password,username) values (354674,'izdhnf8','cjjfdssf');

/*Most data generated from Philly public libraries*/
insert into Libraries (lid,name,location) values (92834,'Chestnut Hill Branch','Philadelphia, PA');
insert into Libraries (lid,name,location) values (92836,'Fishtown Community Branch','Philadelphia, PA');
insert into Libraries (lid,name,location) values (45667,'Haddington Branch','Philadelphia, PA');
insert into Libraries (lid,name,location) values (3049,'Joseph E. Coleman Northwest Regional Library','Philadelphia, PA');
insert into Libraries (lid,name,location) values (098534,'Parkway Central Library ','Philadelphia, PA');
insert into Libraries (lid,name,location) values (123489,'Albany Public Library - Pine Hills Branch','Albany,NY');
insert into Libraries (lid,name,location) values (189,'Albany Public Library - John A. Howe Branch','Albany,NY');
insert into Libraries (lid,name,location) values (65890,'Andorra Branch ','Philadelphia, PA');
insert into Libraries (lid,name,location) values (34522,'Aspen Hill','Maryland');

insert into Books(bid,type,name,published_date) values (25674,'novel','Charitable Getting',2010);
insert into Authors(name,DOB) values ('Sam Starbuck',7658);
insert into Publishing_Companies(pid,location,name) values(12345,null,'Candlemark & Gleam,Extribulum Press');
insert into Book_stores(sid,name,location) values (93057,'Candlemark & Gleam', 'Internet' );
insert into sold_in(bid,sid) values (25674,93057);
insert into written_by(bid,name,DOB) values (25674,'Sam Starbuck',7658);

insert into Have(rid,bid) values (984,25674);
insert into Have(rid,bid) values (985,25674);
insert into Have(rid,bid) values (3456,25674);


insert into Books(bid,type,name,published_date) values (9781476746586,'novel','All the light we cannot see',2014);
insert into Authors(name,DOB) values ('Anthony Doerr',1973);
insert into Publishing_Companies(pid,location,name) values(934857,'New York City, NY','Scribner');
insert into Book_stores(sid,name,location) values (20359,'AmazonBooks', 'Internet' );
insert into sold_in(bid,sid) values (9781476746586,20359);
/*insert into publish_Books(bid,name,type,published_date) values(9781476746586,'novel','All the light we cannot see',2014);*/
insert into written_by(bid,name,DOB) values (9781476746586,'Anthony Doerr',1973);

insert into share(lid,bid) values(92834,9781476746586);
insert into share(lid,bid) values(92836,9781476746586);
insert into share(lid,bid) values(45667,9781476746586);
insert into share(lid,bid) values(3049,9781476746586);

insert into Have(rid,bid) values (984,9781476746586);
insert into Have(rid,bid) values (985,9781476746586);
insert into Have(rid,bid) values (3456,9781476746586);
insert into Have(rid,bid) values (6789,9781476746586);
insert into Have(rid,bid) values (354674,9781476746586);


insert into Books(bid,type,name,published_date) values (9780312577223,'novel','The nightingale',2015);
insert into Authors(name,DOB) values ('Kristin Hannah',1960);
insert into Publishing_Companies(pid,location,name) values(098899,'New York','St. Martin`s Press');
insert into Book_stores(sid,name,location) values (3984,'Barnes and Noble', 'Internet' );
insert into Book_stores(sid,name,location) values (34657,'Barnes and Noble', 'Virginia' );
insert into Book_stores(sid,name,location) values (125673,'Barnes and Noble', 'Maryland' );
insert into sold_in(bid,sid) values (9781476746586,3984);
insert into sold_in(bid,sid) values (9781476746586,125673);
insert into sold_in(bid,sid) values (9781476746586,34657);
insert into written_by(bid,name,DOB) values (9780312577223,'Kristin Hannah',1960);
insert into share(lid,bid) values(65890,9780312577223);

insert into Have(rid,bid) values (6789,9780312577223);
insert into Have(rid,bid) values (354674,9780312577223);
insert into Have(rid,bid) values (3469,9780312577223);

insert into share(lid,bid) values(34522,9780312577223);



insert into Books(bid,type,name,published_date) values (9780071778459,'textbook','Basic math',2012);
insert into Authors(name,DOB) values ('Wheater, Carolyn C.',1951);
insert into Publishing_Companies(pid,location,name) values(48965,'New York','McGraw-Hill');
insert into sold_in(bid,sid) values (9780071778459,20359);
insert into written_by(bid,name,DOB) values (9780071778459,'Wheater, Carolyn C.',1951);

insert into Have(rid,bid) values (6789,9780071778459);

insert into Books(bid,type,name,published_date) values (9781476749198,'cookbook','The FastDiet cookbook',2013);
insert into Authors(name,DOB) values ('Mimi Spencer',1967);
insert into Authors(name,DOB) values ('Schenker, Sarah',1967);
insert into Publishing_Companies(pid,location,name) values(097287,'New York',' Atria Books');

insert into sold_in(bid,sid) values (9781476749198,20359);

insert into written_by(bid,name,DOB) values (9781476749198,'Mimi Spencer',1967);
insert into written_by(bid,name,DOB) values (9781476749198,'Schenker, Sarah',1967);

insert into share(lid,bid) values(92834,9781476749198);

insert into Have(rid,bid) values (984,9781476749198);

insert into Books(bid,type,name,published_date) values (9780810996168,'childrens book','The wimpy kid movie diary',2010);
insert into Authors(name,DOB) values ('Kinney, Jeff',1971);
insert into Publishing_Companies(pid,location,name) values(0925580,'New York','Amulet Books');

insert into sold_in(bid,sid) values (9780810996168,20359);

insert into written_by(bid,name,DOB) values (9780810996168,'Kinney, Jeff',1971);
insert into Movies(mid,name,release_date) values (1196141,'Diary of a Wimpy Kid',2010);
insert into based_on(bid,mid) values (9780810996168,1196141);

insert into Have(rid,bid) values (984,9780810996168);
insert into Have(rid,bid) values (985,9780810996168);
insert into Have(rid,bid) values (3456,9780810996168);
insert into Have(rid,bid) values (457,9780810996168);
insert into Have(rid,bid) values (0987,9780810996168);
insert into Have(rid,bid) values (6789,9780810996168);
insert into Have(rid,bid) values (3469,9780810996168);
insert into Have(rid,bid) values (34678,9780810996168);
insert into Have(rid,bid) values (354674,9780810996168);

insert into share(lid,bid) values(92834,9780810996168);

insert into Books(bid,type,name,published_date) values ( 9780786169894,'novel','Guardians of Ga`Hoole. Book one, The capture',2006);
insert into Authors(name,DOB) values ('Kathryn Lasky',1944);
insert into Authors(name,DOB) values ('Garelick, Pamela',1944);
insert into Publishing_Companies(pid,location,name) values(5009123,'Ashland, Or','Blackstone Audiobooks');
insert into sold_in(bid,sid) values (9780786169894,20359);

insert into written_by(bid,name,DOB) values (9780786169894,'Kathryn Lasky',1944);
insert into written_by(bid,name,DOB) values (9780786169894,'Garelick, Pamela',1944);
insert into Movies(mid,name,release_date) values (1219342,'Legend of the Guardians: The Owls of Ga`Hoole',2010);
insert into based_on(bid,mid) values (9780786169894,1219342);

insert into Have(rid,bid) values (457,9780786169894);
insert into Have(rid,bid) values (0987,9780786169894);
insert into Have(rid,bid) values (6789,9780786169894);
insert into Have(rid,bid) values (3469,9780786169894);
