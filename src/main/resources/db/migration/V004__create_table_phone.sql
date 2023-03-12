/*==============================================================*/
/* TABLE: TB_PHONE                                              */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS TB_PHONE(
     ID SERIAL NOT NULL,
     DDI VARCHAR(5) NOT NULL,
     DDD VARCHAR(5) NOT NULL,
     NUMBER VARCHAR(10) NOT NULL,
     WHATS_APP BOOLEAN NOT NULL,
     CONSTRAINT PK_PHONE PRIMARY KEY(ID)
);

