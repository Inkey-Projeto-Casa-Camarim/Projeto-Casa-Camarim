-- Insere registros na tabela tipo_usuario, ignorando conflitos de chave primária ou únicos
insert ignore into tipo_usuario (id_tipo, nome_tipo, cpf) 
values (1, 'Cliente', '00000000000'), -- Insere o tipo de usuário "Cliente" com CPF fictício
(2, 'Admin',   '11111111111'); -- Insere o tipo de usuário "Admin" com CPF fictício

-- Insere um registro na tabela "tb_usuario" com os valores especificados.
-- "insert ignore" evita erro caso já exista um registro com o mesmo "id_usuario" (não insere duplicatas).
insert ignore into tb_usuario(id_usuario, nome, telefone)
values (1, 'Administrador', '15999999999'); -- Valores dos campos inseridos