/*==============================================================*/
/* TABLE: TB_ROLE                                               */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS TB_ROLE(
     ID SERIAL NOT NULL,
     NAME VARCHAR(50) NOT NULL,
     DESCRIPTION VARCHAR(500) NOT NULL,
     CONSTRAINT PK_ROLE PRIMARY KEY(ID)
);


