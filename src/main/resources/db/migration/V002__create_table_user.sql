/*==============================================================*/
/* TABLE: TB_USER                                               */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS TB_USER(
     ID SERIAL NOT NULL,
     EMAIL VARCHAR(200) NOT NULL,
     PASSWORD VARCHAR(200) NOT NULL,
     CREATE_AT TIMESTAMP NOT NULL,
     STATUS VARCHAR NOT NULL,
     CONSTRAINT PK_USER PRIMARY KEY(ID),
     CONSTRAINT EMAIL_UNIQUE UNIQUE(EMAIL)
);

