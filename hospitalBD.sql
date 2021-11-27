create database hospital;

use hospital;




insert into medicamento(nombre,categoria1,fecha,precio,stock)values('Codeina','Analgesicos','2020-10-01',32.54,400);
insert into medicamento(nombre,categoria1,fecha,precio,stock)values('Bicarbonato sodico','Antiácidos y antiulcerosos','2020-10-01',77.54,200);
insert into medicamento(nombre,categoria1,fecha,precio,stock)values('Desloratadina','Antialergicos','2020-10-01',88.24,100);
insert into medicamento(nombre,categoria1,fecha,precio,stock)values('Loperamida','Antidiarreicos','2020-10-01',55.84,400);
insert into medicamento(nombre,categoria1,fecha,precio,stock)values('Amoxicilina','Antiinfecciosos','2019-11-01',32.54,800);
insert into medicamento(nombre,categoria1,fecha,precio,stock)values('Naproxeno','Antiinflamatorios','2020-10-01',99.24,1200);
insert into medicamento(nombre,categoria1,fecha,precio,stock)values('Paracetamol','Antipireticos','2020-10-01',59.54,400);
insert into medicamento(nombre,categoria1,fecha,precio,stock)values('Difenhidramina','Antitusivos','2020-12-01',66.54,400);
insert into medicamento(nombre,categoria1,fecha,precio,stock)values
('Simvastatina','Anticolesterol','2020-12-01',62.54,100);
insert into medicamento(nombre,categoria1,fecha,precio,stock)values
('Aspirina','Salicilato','2020-11-27',55.54,200);
insert into medicamento(nombre,categoria1,fecha,precio,stock)values
('Omeprazol','Salicilato','2020-11-27',55.54,200);
insert into medicamento(nombre,categoria1,fecha,precio,stock)values
('Lexotiroxina','Salicilato','2020-11-27',55.54,200);



select * from medicamentos;



insert into medicos(nombre,apellidos,especialidad,fecha)values('Alberto','Sosa','Pediatria','2020-12-01');
insert into medicos(nombre,apellidos,especialidad,fecha)values('Roberto','Campo','Psicologia','2020-12-01');
insert into medicos(nombre,apellidos,especialidad,fecha)values('Elizabeth','Ramos','Infectologia','2020-12-01');
insert into medicos(nombre,apellidos,especialidad,fecha)values('Ramon','Santos','Dermatologia','2020-12-01');
insert into medicos(nombre,apellidos,especialidad,fecha)values('Mario','Moreno','Ginecologia ','2020-12-01');
insert into medicos(nombre,apellidos,especialidad,fecha)values('Roberto','Gomez','Oftalmologia','2020-12-01');
insert into medicos(nombre,apellidos,especialidad,fecha)values('Raul','Padilla','Otorrinolaringologia','2020-12-01');
insert into medicos(nombre,apellidos,especialidad,fecha)values('Ruben','Villa','Traumatologia','2020-12-01');
insert into medicos(nombre,apellidos,especialidad,fecha)values('Gustavo','Solis','Urologia','2020-12-01');
insert into medicos(nombre,apellidos,especialidad,fecha)values('Luciana','Flores','Cirugia plastica','2020-12-01');

select * from medicos;


insert into cita(fecha,medicos_id,paciente_id)values('2020-11-08',1,1);
insert into cita(fecha,medicos_id,paciente_id)values('2020-12-12',2,2);
insert into cita(fecha,medicos_id,paciente_id)values('2020-11-30',3,3);
insert into cita(fecha,medicos_id,paciente_id)values('2020-12-13',4,4);
insert into cita(fecha,medicos_id,paciente_id)values('2020-11-26',5,5);

insert into cita(fecha,medicos_id,paciente_id)values('2020-11-30',6,6);
insert into cita(fecha,medicos_id,paciente_id)values('2020-11-28',7,7);

insert into cita(fecha,medicos_id,paciente_id)values('2020-11-28',8,8);


select * from cita;


insert into usuarios(username,password,estado)values('admin','$2a$10$Nb7ggdIFlsZ0KSj4Q5lZg.J8Y44rSva2J7m1.68ZOoisNESGOCX4G',1);
insert into usuarios(username,password,estado)values('marco','$2a$10$qdfImAhK.DlnqqDEqrcuq.xQ4FR0brE/uj/uXa32DHJ5MeRlNM85G',1);

select * from usuarios;



insert into roles(usuarios_id,authority)values(1,'ROLE_ADMIN');
insert into roles(usuarios_id,authority)values(1,'ROLE_USER');
insert into roles(usuarios_id,authority)values(2,'ROLE_USER');

select * from roles;

select * from paciente;


INSERT INTO `paciente` VALUES (1,'Leontxo','García','Lima','Calle 13','2020-11-09','908264231'),
(2,'Alan','Guevara','Lima','Calle 14','2020-11-09','908264231'),
(3,'Fernanda','Guerrero','Flores','Av Angeles','2020-12-19','928264231'),
(4,'Horacio','Aguirre','Castro','Calle 20','2020-11-24','908264201'),
(5,'Maria','Villa','Rosas','Calle 30','2020-11-25','908260231'),
(6,'Luna','Barrientos','Villanueva','Calle 13','2020-11-26','908264291'),
(7,'Carlos','Martinez','Rojas','Av. Aguirre1','2020-11-23','908210231'),
(8,'Steve','Perry','Cane','Av. Fost Fight','2020-12-20','918210231');
