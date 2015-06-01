create database if not exists thesis;

use thesis;

create table t_user
(
   u_id char(8) primary key not null,
   u_name varchar(30) not null,
   sex char(2),
   password varchar (16),
   email varchar (25),
   phone varchar (13),
   teacher char (8),
   entrance_date char( 4),
   status int (1) default 0,
   pspb1 varchar (32),
   pspb2 varchar (32),
   pspb3 varchar (32),
   answer1 varchar (40),
   answer2 varchar (40),
   answer3 varchar (40)
);

create table t_class
(
   c_id varchar (20) primary key not null, c_name varchar (20), major varchar (30)
);

create table t_userclass
(
   u_id char(8),
   c_id varchar(20),
   primary key(c_id,u_id),
   FOREIGN KEY(u_id) REFERENCES t_user(u_id) ON
   DELETE CASCADE ON
   UPDATE CASCADE, FOREIGN KEY(c_id) REFERENCES t_class(c_id) ON
   DELETE CASCADE ON
   UPDATE CASCADE
);


create table t_thesis
(
   t_id char(12) primary key not null,
   t_name varchar(70),
   t_front varchar(200),
   document varchar(200),
   description varchar(300),
   isdelete int(1) default 0
);


create table t_userthesis
(
   t_id char(12),
   u_id char(8),
   verify_status int(1) default 0,
   verify_count int(3) default 0,
   trial_status int(1) default 0,
   reverify_status int(1) default 0,
   reverify_count int(3) default 0,
   primary key(t_id,u_id),
   FOREIGN KEY(u_id) REFERENCES t_user(u_id) ON
   DELETE CASCADE ON
   UPDATE CASCADE, FOREIGN KEY(t_id) REFERENCES t_thesis(t_id) ON
   DELETE CASCADE ON
   UPDATE CASCADE
);

create table t_article
(
   a_id int(7) primary key auto_increment,
   title varchar(40),
   subject varchar(70),
   content varchar(255),
   time date,
   image varchar(150),
   isleaf int(1),
   p_id int(7)
);

create table t_userarticle
(
   a_id int(7),
   u_id char(8),
   primary key(a_id,u_id),
   FOREIGN KEY(u_id) REFERENCES t_user(u_id) ON
   DELETE CASCADE ON
   UPDATE CASCADE, FOREIGN KEY(a_id) REFERENCES t_article(a_id) ON
   DELETE CASCADE ON
   UPDATE CASCADE
)
;