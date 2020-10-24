CREATE TABLE application (
  id serial NOT NULL PRIMARY KEY,
  name text NOT NULL,
  details json NOT NULL
);

insert into application (id, name, details) values (1, 'Transcof', '{
  "image": "http://dummyimage.com/213x213.jpg/ff4444/ffffff",
  "version": "0.54"
}');
insert into application (id, name, details) values (2, 'Stringtough', '{
  "image": "http://dummyimage.com/155x246.png/ff4444/ffffff"
}');
insert into application (id, name, details) values (3, 'Zathin', '{
  "image": "http://dummyimage.com/196x242.jpg/ff4444/ffffff",
  "version": "5.06"
}');
insert into application (id, name, details) values (4, 'Flexidy', '{
  "version": "8.7.3"
}');
insert into application (id, name, details) values (5, 'Bigtax', '{
  "image": "http://dummyimage.com/201x163.bmp/5fa2dd/ffffff",
  "version": "0.3.9"
}');