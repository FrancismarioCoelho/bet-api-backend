/*==============================================================*/
/* TABLE: TB_ROLE_USER                                          */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS TB_ROLE_USER(
     ID SERIAL NOT NULL,
     USER_ID BIGINT NOT NULL,
     ROLE_ID BIGINT NOT NULL,
     CONSTRAINT PK_ROLE_USER PRIMARY KEY(ID),
     CONSTRAINT FK_USER_ROLE_1 FOREIGN KEY (ROLE_ID) REFERENCES TB_ROLE(ID),
     CONSTRAINT FK_USER_ROLE_2 FOREIGN KEY (USER_ID) REFERENCES TB_USER(ID)
);

