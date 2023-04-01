/*==============================================================*/
/* TABLE: TB_USER                                               */
/*==============================================================*/

ALTER TABLE TB_USER ADD COLUMN IF NOT EXISTS PERSON_ID BIGINT;

ALTER TABLE TB_USER DROP CONSTRAINT IF EXISTS FK_USER_PERSON;

ALTER TABLE TB_USER ADD CONSTRAINT  FK_USER_PERSON FOREIGN KEY (PERSON_ID) REFERENCES TB_PERSON(ID)