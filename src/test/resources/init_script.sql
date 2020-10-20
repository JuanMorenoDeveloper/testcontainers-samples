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
  "image": "http://dummyimage.com/155x246.png/ff4444/ffffff",
  "url": "http://walmart.com/aliquet/at/feugiat/non.aspx?nulla=morbi&dapibus=non&dolor=lectus&vel=aliquam&est=sit&donec=amet&odio=diam&justo=in&sollicitudin=magna&ut=bibendum&suscipit=imperdiet&a=nullam&feugiat=orci&et=pede&eros=venenatis&vestibulum=non&ac=sodales&est=sed&lacinia=tincidunt&nisi=eu&venenatis=felis&tristique=fusce&fusce=posuere&congue=felis&diam=sed&id=lacus&ornare=morbi&imperdiet=sem&sapien=mauris&urna=laoreet&pretium=ut&nisl=rhoncus&ut=aliquet&volutpat=pulvinar&sapien=sed&arcu=nisl&sed=nunc&augue=rhoncus&aliquam=dui&erat=vel&volutpat=sem&in=sed&congue=sagittis&etiam=nam&justo=congue&etiam=risus&pretium=semper&iaculis=porta&justo=volutpat&in=quam&hac=pede&habitasse=lobortis&platea=ligula&dictumst=sit&etiam=amet&faucibus=eleifend&cursus=pede&urna=libero&ut=quis&tellus=orci&nulla=nullam&ut=molestie&erat=nibh&id=in&mauris=lectus&vulputate=pellentesque&elementum=at&nullam=nulla&varius=suspendisse&nulla=potenti&facilisi=cras&cras=in&non=purus&velit=eu&nec=magna&nisi=vulputate&vulputate=luctus&nonummy=cum&maecenas=sociis&tincidunt=natoque&lacus=penatibus&at=et&velit=magnis&vivamus=dis&vel=parturient&nulla=montes&eget=nascetur&eros=ridiculus"
}');
insert into application (id, name, details) values (3, 'Zathin', '{
  "image": "http://dummyimage.com/196x242.jpg/ff4444/ffffff",
  "version": "5.06",
  "url": "http://goodreads.com/cras/pellentesque/volutpat/dui/maecenas/tristique.xml?pede=aliquam&venenatis=quis&non=turpis&sodales=eget&sed=elit&tincidunt=sodales&eu=scelerisque&felis=mauris&fusce=sit&posuere=amet&felis=eros&sed=suspendisse&lacus=accumsan&morbi=tortor&sem=quis&mauris=turpis&laoreet=sed&ut=ante&rhoncus=vivamus&aliquet=tortor&pulvinar=duis&sed=mattis&nisl=egestas&nunc=metus&rhoncus=aenean&dui=fermentum&vel=donec&sem=ut&sed=mauris&sagittis=eget&nam=massa&congue=tempor&risus=convallis&semper=nulla&porta=neque&volutpat=libero&quam=convallis&pede=eget&lobortis=eleifend&ligula=luctus&sit=ultricies&amet=eu&eleifend=nibh&pede=quisque&libero=id&quis=justo&orci=sit&nullam=amet&molestie=sapien&nibh=dignissim&in=vestibulum&lectus=vestibulum&pellentesque=ante&at=ipsum&nulla=primis&suspendisse=in&potenti=faucibus&cras=orci&in=luctus&purus=et&eu=ultrices&magna=posuere&vulputate=cubilia&luctus=curae&cum=nulla"
}');
insert into application (id, name, details) values (4, 'Flexidy', '{
  "version": "8.7.3",
  "url": "http://geocities.jp/dapibus/augue/vel/accumsan/tellus.html?ante=eget&vivamus=orci&tortor=vehicula&duis=condimentum&mattis=curabitur&egestas=in&metus=libero&aenean=ut&fermentum=massa&donec=volutpat&ut=convallis&mauris=morbi&eget=odio&massa=odio&tempor=elementum&convallis=eu&nulla=interdum&neque=eu&libero=tincidunt&convallis=in&eget=leo&eleifend=maecenas&luctus=pulvinar&ultricies=lobortis&eu=est&nibh=phasellus&quisque=sit&id=amet&justo=erat&sit=nulla&amet=tempus&sapien=vivamus&dignissim=in&vestibulum=felis&vestibulum=eu"
}');
insert into application (id, name, details) values (5, 'Bigtax', '{
  "image": "http://dummyimage.com/201x163.bmp/5fa2dd/ffffff",
  "version": "0.3.9",
  "url": "https://sohu.com/ultrices/enim/lorem/ipsum.jsp?ultrices=amet&posuere=diam&cubilia=in&curae=magna&mauris=bibendum&viverra=imperdiet&diam=nullam&vitae=orci&quam=pede&suspendisse=venenatis&potenti=non&nullam=sodales&porttitor=sed&lacus=tincidunt&at=eu&turpis=felis&donec=fusce&posuere=posuere&metus=felis&vitae=sed&ipsum=lacus&aliquam=morbi&non=sem&mauris=mauris&morbi=laoreet&non=ut&lectus=rhoncus&aliquam=aliquet&sit=pulvinar&amet=sed&diam=nisl&in=nunc&magna=rhoncus&bibendum=dui&imperdiet=vel&nullam=sem&orci=sed&pede=sagittis&venenatis=nam&non=congue&sodales=risus&sed=semper&tincidunt=porta&eu=volutpat&felis=quam&fusce=pede&posuere=lobortis&felis=ligula&sed=sit&lacus=amet&morbi=eleifend&sem=pede&mauris=libero&laoreet=quis&ut=orci&rhoncus=nullam&aliquet=molestie&pulvinar=nibh&sed=in&nisl=lectus&nunc=pellentesque&rhoncus=at&dui=nulla&vel=suspendisse&sem=potenti&sed=cras&sagittis=in&nam=purus&congue=eu&risus=magna&semper=vulputate&porta=luctus&volutpat=cum&quam=sociis&pede=natoque&lobortis=penatibus&ligula=et&sit=magnis&amet=dis&eleifend=parturient&pede=montes&libero=nascetur&quis=ridiculus&orci=mus&nullam=vivamus&molestie=vestibulum&nibh=sagittis&in=sapien&lectus=cum&pellentesque=sociis&at=natoque&nulla=penatibus&suspendisse=et&potenti=magnis&cras=dis&in=parturient&purus=montes&eu=nascetur"
}');