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


CREATE TABLE TIPO_VASO(
   ID  INTEGER PRIMARY KEY,
   NOMBRE           TEXT      NOT NULL
);



CREATE TABLE TIPO_MAQUINA(
   ID  INTEGER PRIMARY KEY,
   NOMBRE           TEXT      NOT NULL
);


CREATE TABLE ANCLAJE(
   ID  INTEGER PRIMARY KEY,
   NOMBRE           TEXT      NOT NULL
);


CREATE TABLE TIPO_NEGOCIACION(
   ID  INTEGER PRIMARY KEY,
   NOMBRE           TEXT      NOT NULL
);

CREATE TABLE LISTA_PRECIOS(
	ID  INTEGER PRIMARY KEY,
	CODIGO TEXT      NOT NULL,
	DESCRIPCION TEXT      NOT NULL
);


CREATE TABLE CATEGORIA(
   ID  INTEGER PRIMARY KEY,
   NOMBRE           TEXT      NOT NULL
);

CREATE TABLE NEGOCIO(
   ID  SERIAL PRIMARY KEY,
   clienteid INTEGER REFERENCES cliente (ID) , 
   numeroMaquina INTEGER,
   tipoVasoId INTEGER REFERENCES TIPO_VASO (ID),
   totalsale INTEGER,
   anchorageDataID INTEGER REFERENCES ANCLAJE (ID),
   typeNegociationDataId INTEGER REFERENCES TIPO_NEGOCIACION (ID),
   typeMachineDataId INTEGER REFERENCES TIPO_MAQUINA (ID),
   listPricesDataId INTEGER REFERENCES LISTA_PRECIOS (ID),
	categoryDataId INTEGER REFERENCES CATEGORIA (ID)
);
/******************************//

CREATE TABLE INFLUENCIA_COMPRA(
   ID  SERIAL PRIMARY KEY,
   NOMBRE TEXT 
);

CREATE TABLE GRADO_INFLUENCIA(
   ID  SERIAL PRIMARY KEY,
   NOMBRE TEXT 
);

CREATE TABLE MODO(
   ID  SERIAL PRIMARY KEY,
   NOMBRE TEXT 
);


CREATE TABLE CONTACTO(
   ID  SERIAL PRIMARY KEY,
   influenciacompraid INTEGER REFERENCES INFLUENCIA_COMPRA (ID) , 
   gradoinfluenciaid INTEGER REFERENCES GRADO_INFLUENCIA (ID),
   modoid INTEGER REFERENCES MODO (ID),
   clienteid INTEGER REFERENCES cliente (ID) , 
   nombre TEXT,
   Telefono TEXT,
   celular TEXT,
   fechaCumpleaños date,
   email TEXT,
    nombre_cartera TEXT,
   Telefono_cartera TEXT,
   celular_cartera TEXT,
   email_cartera TEXT
);

