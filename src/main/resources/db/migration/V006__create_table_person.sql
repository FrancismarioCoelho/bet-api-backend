/*==============================================================*/
/* TABLE: TB_PERSON                                             */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS TB_PERSON(
     ID SERIAL NOT NULL,
     NAME VARCHAR(100) NOT NULL,
     NICK_NAME VARCHAR(50),
     TAX_ID VARCHAR(20) NOT NULL,
     GENDER VARCHAR  NOT NULL,
     BIRTH_DATE DATE NOT NULL,
     PHONE_ID INTEGER NOT NULL,
     CONSTRAINT PK_PERSON PRIMARY KEY(ID),
     CONSTRAINT FK_PERSON_PHONE FOREIGN KEY (PHONE_ID) REFERENCES TB_PHONE(ID)
);

