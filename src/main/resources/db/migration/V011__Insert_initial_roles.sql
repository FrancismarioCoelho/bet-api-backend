/*==============================================================*/
/* Flyway Migration: Inserção de Papéis na Tabela roles          */
/*==============================================================*/

-- Inserindo papéis na tabela roles
INSERT INTO TB_ROLE (name, description) VALUES ('Bettor', 'Usuário que realiza apostas');
INSERT INTO TB_ROLE (name, description) VALUES ('Admin', 'Administrador do sistema');
INSERT INTO TB_ROLE (name, description) VALUES ('Support', 'Operador de suporte');
INSERT INTO TB_ROLE (name, description) VALUES ('Manager', 'Gerente responsável');
