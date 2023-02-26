/*==============================================================*/
/* TABLE: TB_USER                                              */
/*==============================================================*/

ALTER TABLE TB_USER
    DROP COLUMN IF EXISTS ROLE_ID;

ALTER TABLE TB_USER
    ALTER COLUMN STATUS TYPE VARCHAR;

 ALTER TABLE TB_ROLE
     ADD COLUMN IF NOT EXISTS USER_ID BIGINT NULL;

 ALTER TABLE TB_ROLE
     ADD CONSTRAINT fk_user_role FOREIGN KEY (USER_ID) REFERENCES TB_USER(ID)