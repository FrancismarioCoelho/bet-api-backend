/*==============================================================*/
/* TABLE: TB_ROLE                                               */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS TB_ROLE(
     ID SERIAL NOT NULL,
     DESCRIPTION VARCHAR(100) NOT NULL,
     CONSTRAINT PK_ROLE PRIMARY KEY(ID)
);


