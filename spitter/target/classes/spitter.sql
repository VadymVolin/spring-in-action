/*
create table `spitter` (
	`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
*/
-- test data 

/*
insert into spitter(id, username, password, fullname) values(1,"vadim1", "1", "Vadim Volin");
insert into spitter(username, password, fullname) values("vadim1", "1", "Vadim Volin");
insert into spitter(username, password, fullname) values("vadim2", "12", "Vadim Volin");
insert into spitter(username, password, fullname) values("vadim3", "123", "Vadim Volin");
insert into spitter(username, password, fullname) values("vadim4", "1234", "Vadim Volin");
insert into spitter(username, password, fullname) values("vadim5", "12345", "Vadim Volin");
insert into spitter(username, password, fullname) values("vadim6", "123456", "Vadim Volin");
insert into spitter(username, password, fullname) values("vadim7", "1234567", "Vadim Volin");
insert into spitter(username, password, fullname) values("vadim8", "12345678", "Vadim Volin");
insert into spitter(username, password, fullname) values("vadim9", "123456789", "Vadim Volin");
insert into spitter(username, password, fullname) values("vadim10", "12345678910", "Vadim Volin");
insert into spitter(username, password, fullname) values("vadim11", "10987654321", "Vadim Volin");
insert into spitter(username, password, fullname) values("vadim12", "1098765432", "Vadim Volin");
insert into spitter(username, password, fullname) values("vadim13", "109876543", "Vadim Volin");
insert into spitter(username, password, fullname) values("vadim14", "10987654", "Vadim Volin");
insert into spitter(username, password, fullname) values("vadim15", "1098765", "Vadim Volin");
*/
select * from spitter;
