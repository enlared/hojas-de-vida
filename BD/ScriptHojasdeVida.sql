CREATE TABLE ejecutivo_cuenta(
   ID  SERIAL PRIMARY KEY,
   NOMBRE           TEXT      NOT NULL,
   CODIGO           TEXT      NOT NULL
);


CREATE TABLE EJECUTIVO_NEGOCIOS(
   ID  SERIAL PRIMARY KEY,
   NOMBRE           TEXT      NOT NULL,
   CODIGO           TEXT      NOT NULL
);

CREATE TABLE TIPO_CLIENTE(
   ID  SERIAL PRIMARY KEY,
   NOMBRE           TEXT      NOT NULL,
);


CREATE TABLE REGIONAL(
   ID  INTEGER PRIMARY KEY,
   NOMBRE           TEXT      NOT NULL
);

CREATE TABLE CLIENTE(
   ID  SERIAL PRIMARY KEY,
   ejecutivoNegocioID INTEGER REFERENCES EJECUTIVO_NEGOCIOS (ID) , 
   ejecutivoCuentaId INTEGER REFERENCES ejecutivo_cuenta (ID),
   idTipoCliente INTEGER REFERENCES TIPO_CLIENTE (ID),
   codigoSap TEXT,
   regionalId INTEGER REFERENCES REGIONAL (ID),
   razonSocial TEXT,
   direccion TEXT,
   nit TEXT,
   barrio TEXT,
   email TEXT,
   numberSedes INTEGER,
   telfonoFijo TEXT,
   numeroCelular TEXT,
   objetivoAnual INTEGER,
   objetivoMensual INTEGER,
   fechaInicio date,
   fechaFin date

);


CREATE TABLE TIPO_EMPLEADO(
   ID  INTEGER PRIMARY KEY,
   NOMBRE           TEXT      NOT NULL
);

CREATE TABLE SECTOR(
   ID  INTEGER PRIMARY KEY,
   NOMBRE           TEXT      NOT NULL
);



CREATE TABLE SEDE(
   ID  SERIAL PRIMARY KEY,
   clienteid INTEGER REFERENCES cliente (ID) , 
   tipoEmpleadoId INTEGER REFERENCES TIPO_EMPLEADO (ID),
   idTipoCliente INTEGER REFERENCES SECTOR (ID),
   numeroEmpleado TEXT  

);
