/*==============================================================*/
/* TABLE: TB_PAYMENT                                            */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS TB_PAYMENT(
     ID SERIAL  NOT NULL,
     VALUE  DECIMAL(10,2) NOT NULL,
     CREATE_AT  TIMESTAMP NOT NULL,
     TYPE       VARCHAR,
     STATUS     VARCHAR,
     CREDIT_ID  BIGINT NOT NULL,
     CONSTRAINT PK_PAYMENT PRIMARY KEY(ID),
     CONSTRAINT FK_PAYMENT_CREDIT FOREIGN KEY (CREDIT_ID) REFERENCES TB_CREDIT(ID)
);

