create database empresa;
use empresa;

-- tabla bebida(nombre(PK), tamaño, tipo de leche, tipo de azúcar, ingredientes, forma de preparación)
create table bebida(
claveB int8 primary key unique,
nombreB			varchar(30),
tamaño			varchar(20),
tipoDeLeche		varchar(30),
tipoDeAzucar	varchar(30),
ingredientes	varchar(80),
formPreparacion	varchar(80),
rfcCliente 		varchar(20),
curpEmp			varchar(20),
foreign key (rfcCliente) references cliente(RFC) on delete cascade on update cascade,
foreign key(curpEmp) references Empleado(CURPE) on delete cascade on update cascade
);
-- Llave cliente y empleado en la bebida
-- tabla cliente(RFC(PK), nombre, fechaDeCompra, numeroDeB, tipoDeB, totalPago)


create table cliente(
RFC			varchar(20) primary key unique,
primNombC		varchar(30),
seguNombC		varchar(30),
apPatC			varchar(30),
apMatC			varchar(30),
fechaDeCompra	datetime,
numeroDeB		int8,
tipoDeB			varchar(30),
totalPago		double
);

-- tabla proveedores(RFCP(PK), nombre, numProdProv, fehcaEnvio, cantFact), proveedor aprobado
create table proveedorAprobado(
RFCPA			varchar(30) primary key unique,
primNombPA		varchar(30),
seguNombPA		varchar(30),
apPatPA			varchar(30),
apMatPA			varchar(30)
);

create table proveedores(
RFCP			varchar(30) primary key unique,
primNombP		varchar(30),
seguNombP		varchar(30),
apPatP			varchar(30),
apMatP			varchar(30),
numProdProv		int8,
fechaEnvio		DATE,
cantFact		int8,
RFCPA			varchar(30),
foreign key (RFCPA) references proveedorAprobado (RFCPA) on delete cascade on update cascade
);

-- tabla empleado(CURPE(PK), nombre, celular, ocupación, hrsTrab)
create table empleado(
CURPE		varchar(20) primary key unique,
primNombE	varchar(30),
seguNombE	varchar(30),
apPatE		varchar(30),
apMatE		varchar(30),
celular		int8,
ocupacion	varchar(30),
hrsTrab		int8
);

-- tabla gerente(CURPG(PK), nombre, dirección, telCasa, celularG, sueldo)
create table gerente(
CURPG		varchar(20) primary key unique,
primNombG	varchar(30),
seguNombG	varchar(30),
apPatG		varchar(30),
apMatG		varchar(30),
calleG		varchar(30),
numG		varchar(30),
colG		varchar(30),
cpG			varchar(10),
cdG			varchar(30),
telCasa		int8, 
celular		int8,
sueldo		double
);

-- tabla franquicia(CURP(FK), RFCP(FK), CURPE(FK), RFCC(FK), nombreB(FK))
create table franquicia(
CURPG		varchar(20),
RFCP		varchar(20),
CURPE		varchar(20),
RFC			varchar(20),
claveB		int8,
foreign key (CURPG) references gerente(CURPG) on delete cascade on update cascade,
foreign key (RFCP) references proveedores(RFCP) on delete cascade on update cascade,
foreign key (CURPE) references empleado(CURPE) on delete cascade on update cascade,
foreign key (RFC) references cliente(RFC) on delete cascade on update cascade,
foreign key (claveB) references bebida(claveB) on delete cascade on update cascade
);
-- registros de comprobación
-- bebida
Select CURPG, primNombG, seguNombG, apPatG, apMatG,
calleG,  numG,  colG,  cpG,  cdG,
telCasa,  celular, sueldo from gerente;

insert into bebida values(12345,"capuccino", "chico", "entera", "morena", "leche, cafe, azúcar", "calentar agua, mezclar el agua, cafe y azúcar al gusto");
-- cliente
insert into cliente values("N/A", "", "", "", "", '0000-00-00', 0, "N/A", 0);
DELETE FROM cliente where RFC = 'N/A';
-- proveedorAprobado
insert into proveedorAprobado values("PACW3424", "Rodrigo", "", "Macías", "Ruiz");
-- proveedores
insert into proveedores values("PFWE25233", "José", "Emanuel", "Guerrero", "Segura", 300, '2022-11-01', 6000, "PACW3424");
-- empleado (hrsTrab es por semana)
insert into empleado values("N/A", "N/A", "N/A", "N/A", "N/A", 0, "N/A", 0);
-- gerente
insert into gerente values("GDT45663", "Juan", "Manuel", "Torres", "Ramírez", "Campo de magnolias", "855", "Campo nuevo", "27982", "Torreón", 2350252, 8715334570, 30000);
-- franquicias

insert into franquicia values("GDT45663", "PFWE25233", "EMP32425", "FIR230943", 12345);