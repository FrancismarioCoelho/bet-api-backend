/*==============================================================*/
/* TABLE: TB_PERSON                                             */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS TB_PERSON(
     ID SERIAL NOT NULL,
     NAME VARCHAR(100) NOT NULL,
     EMAIL VARCHAR(200) NOT NULL,
     NICK_NAME VARCHAR(50),
     TAX_ID VARCHAR(20) NOT NULL,
     GENDER VARCHAR  NOT NULL,
     BIRTH_DATE DATE NOT NULL,
     CREDIT_ID BIGINT NULL,
     CONSTRAINT PK_PERSON PRIMARY KEY(ID),
     CONSTRAINT EMAIL_UNIQUE UNIQUE(EMAIL),
     CONSTRAINT FK_PERSON_CREDIT FOREIGN KEY (CREDIT_ID) REFERENCES TB_CREDIT(ID)
);

