/*==============================================================*/
/* TABLE: TB_USER                                               */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS TB_USER(
     ID SERIAL NOT NULL,
     LOGIN VARCHAR(200) NOT NULL,
     PASSWORD VARCHAR(200) NOT NULL,
     CREATE_AT TIMESTAMP NOT NULL,
     STATUS VARCHAR NOT NULL,
     CONSTRAINT PK_USER PRIMARY KEY(ID),
     CONSTRAINT LOGIN_UNIQUE UNIQUE(LOGIN)
);

