-- Insere registros na tabela tipo_usuario, ignorando conflitos de chave primária ou únicos
insert ignore into tipo_usuario (id_tipo, nome_tipo, senha_tipo) 
values (1, 'CasaCamarim', '12345'); -- Insere o tipo de usuário "Admin" com CPF fictício

-- Insere um registro na tabela "tb_usuario" com os valores especificados.
-- "insert ignore" evita erro caso já exista um registro com o mesmo "id_usuario" (não insere duplicatas).
insert ignore into tb_usuario(id_usuario, nome, telefone)
values (1, 'Cliente', '15999999999'); -- Valores dos campos inseridos

-- Tabela de serviço com os serviços oferecidos pela casa camarim
insert ignore into tb_servico(id_servico, preco, nome_servico, descricao_servico, tempo_servico)
values (1, 'R$462,00', 'Cronograma Capilar Cabelo Médio', 'Pacote com 6 tratamentos', '2h a 3h por sessão'),
(2, 'R$535,00', 'Cronograma Capilar Cabelo Longo', 'Pacote com 4 tratamentos', '3h a 4h por sessão'),
(3, 'R$370,00', 'Pacote com 6 Escovas', 'Cabelo Médio', '45 min a 1 hora e 10 min por sessão'),
(4, 'R$408,00','Pacote com 6 Escovas', 'Cabelo Longo', '1h10 a 1h50 por sessão'),
(5, 'R$198,00','Pacote Nails', 'Pacote com 6 atendimentos de unha', '40 min por sessão'),
(6, 'R$64,00', 'Escova', 'Cabelo Curto', '30 a 50 min'),
(7, 'R$77,00', 'Escova', 'Cabelo Médio', '45 min a 1 hora e 10 min'),
(8, 'R$85,00','Escova', 'Cabelo Longo', '1h10 a 1h50'),
(9, 'R$90,00','Escova', 'Cabelo Extra Longo', '1h25 a 2h30'),
(10, 'R$54,00', 'Secagem', 'Cabelo Curto', '5 a 10 min'),
(11, 'R$57,00', 'Secagem', 'Cabelo Médio', '10 a 15 min'),
(12, 'R$68,00','Secagem', 'Cabelo Longo', '15 a 25 min'),
(13, 'R$70,00','Secagem', 'Cabelo Extra Longo', '25 a 35 min'),
(14, 'R$335,00 á R$480,00', 'Luzes', 'Cabelo Curto', '45 a 60 min'),
(15, 'R$550,00', 'Luzes', 'Cabelo Médio', '60 a 90 min'),
(16, 'R$630,00','Luzes', 'Cabelo Longo', '90 a 120 min'),
(17, 'R$725,00','Luzes', 'Cabelo Extra Longo', '120 a 180 min'),
(18, 'R$182,00', 'Selagem', 'Cabelo Curto', '40 a 60 min'),
(19, 'R$220,00', 'Selagem', 'Cabelo Médio', '60 a 90 min'),
(20, 'R$240,00','Selagem', 'Cabelo Longo', '90 a 120 min');

-- Tabela de serviço com os serviços oferecidos pela casa camarim
insert ignore into tb_agenda(id_agenda, data_agenda, hora)
values (1, '10/10', '13:00'),
(2, '11/10', '14:00'),
(3, '11/10', '15:00');
