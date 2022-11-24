-- borra la bd si existe
DROP DATABASE IF EXISTS BD_SistDoc;
-- creamos la bd
CREATE DATABASE BD_SistDoc;
-- activamos la bd
USE BD_SistDoc;



CREATE TABLE TB_EXPEDIENTE(
cod_exp  int  AUTO_INCREMENT,
fecha_registro_exp date not null,
fecha_emision_exp date not null,
nom_organismo varchar(25)not null,
apoderado_organismo varchar(25)not null,
contacto_tlf varchar (15) not null,
contacto_email varchar (25) not null,
descripcion_exp varchar(500),
situacion_exp varchar(15),
primary key (cod_exp)
)AUTO_INCREMENT = 700001;

insert into TB_EXPEDIENTE values 
(null,'2019-02-10','2018-12-31','AdopInt', 'Juan Gomez','94872135','adopperu@outlook.com','Falta documento de record de adopciones','Pendiente');

insert into TB_EXPEDIENTE values 
(null,'2019-02-02','2018-12-28','ONG French', 'Manuel Diaz','954878114','diaz_info@gmail.com','Expediente que cuenta con 8 folios','Pendiente');

select * from TB_EXPEDIENTE;


create table TB_OFICINA(
abrev_ofic char(4) NOT NULL,
nom_ofic varchar(55) not null,
primary key (abrev_ofic)
);
insert into TB_OFICINA values ('DGA','Direccion General de Adopciones');
insert into TB_OFICINA values ('DEIA','Direccion De Evaluacion Integral para la Adopción');

select * from TB_OFICINA;

CREATE TABLE tb_trabajador(
codigo  int AUTO_INCREMENT,
nombre varchar(15),
apellido varchar(25),
puesto  varchar(25),
usuario  char(4) NOT NULL,
clave    char(5),
facceso date  null,
abrev_ofic    char(4) ,
primary key (codigo),
foreign key (abrev_ofic ) references TB_OFICINA(abrev_ofic)
) AUTO_INCREMENT = 1000;

insert into tb_trabajador values (null,'Elias','Figueroa','Tecnico Administrativo', 'U001','tec01', curdate(),'DGA');
insert into tb_trabajador values (null,'Pedro','Ramirez','Secretario', 'U002','secr1', curdate(),'DGA');

select * from tb_trabajador;



create table TB_TRAMITE(
cod_exp int NOT NULL,
cod_tram char(5)NOT NULL,
fecha_registro_tram date not null,
abrev_ofic char(4) NOT NULL,
tipo_doc varchar (25) NOT NULL,
primary key (cod_tram), 
foreign key (cod_exp) references TB_EXPEDIENTE(cod_exp),
foreign key (abrev_ofic ) references TB_OFICINA(abrev_ofic)
);

insert into TB_TRAMITE values (700001,'22214',curdate(),'DGA','Oficio');
insert into TB_TRAMITE values (700002,'00004',curdate(),'DEIA','Carta');

select * from TB_TRAMITE;


-- Procedimientos almancenado para validar acceso
DELIMiTER $$
create procedure usp_validaAcceso (usr char(4), pas char(5))
begin
select * from tb_trabajador where usuario = usr and clave = pas;
end$$
DELIMiTER ;


CALL usp_validaAcceso ('U001','tec01');
CALL usp_validaAcceso ('U002','secr1');


-- procedimientos almancenados de consulta
DELIMiTER $$
CREATE PROCEDURE usp_calcular_fecha (desde varchar(15),hasta varchar(15))
BEGIN
SELECT * FROM TB_EXPEDIENTE 
WHERE fecha_registro_exp between desde and hasta;
END $$
DELIMITER ;
call usp_calcular_fecha ('2010-01-01','2019-02-02');


