/*==============================================================*/
/* TABLE: TB_ADDRESS                                            */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS TB_ADDRESS  (
     ID SERIAL NOT NULL,
     STREET VARCHAR(100) NOT NULL,
     NEIGHBORHOOD VARCHAR(100) NOT NULL,
     CITY VARCHAR(100) NOT NULL,
     COUNTRY VARCHAR(100) NOT NULL,
     COMPLEMENT VARCHAR(100) NOT NULL,
     CONSTRAINT PK_ADDRESS PRIMARY KEY(ID)
);

