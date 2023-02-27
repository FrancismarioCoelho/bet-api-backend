/*==============================================================*/
/* TABLE: TB_USER                                              */
/*==============================================================*/

ALTER TABLE TB_USER ADD COLUMN IF NOT EXISTS PERSON_ID INTEGER;

ALTER TABLE TB_USER DROP CONSTRAINT IF EXISTS fk_user_person;

ALTER TABLE TB_USER ADD CONSTRAINT  fk_user_person FOREIGN KEY (PERSON_ID) REFERENCES TB_PERSON(ID)