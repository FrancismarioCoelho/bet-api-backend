/*==============================================================*/
/* TABLE: TB_RECEIPT                                            */
/*==============================================================*/
CREATE TABLE IF NOT EXISTS TB_RECEIPT(
    ID SERIAL           NOT NULL,
    VALUE DECIMAL(10,2) NOT NULL,
    CREATED TIMESTAMP   NOT NULL,
    CREDIT_ID  BIGINT       NULL,
    CONSTRAINT PK_RECEIPT PRIMARY KEY(ID),
    CONSTRAINT FK_RECEIPT_CREDIT  FOREIGN KEY (CREDIT_ID) REFERENCES TB_CREDIT(ID)
);