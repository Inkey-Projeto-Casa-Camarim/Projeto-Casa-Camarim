-- Insere registros na tabela tipo_usuario, ignorando conflitos de chave primária ou únicos
insert ignore into tipo_usuario (id_tipo, nome_tipo, senha_tipo) 
values (1, 'CasaCamarim', '12345'); -- Insere o tipo de usuário "Admin" com CPF fictício

-- Insere um registro na tabela "tb_usuario" com os valores especificados.
-- "insert ignore" evita erro caso já exista um registro com o mesmo "id_usuario" (não insere duplicatas).
insert ignore into tb_usuario(id_usuario, nome, telefone)
values (1, 'Cliente 1', '15999999999'), -- Valores dos campos inseridos
values (2, 'Cliente 2', '15888888888');

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
(20, 'R$240,00','Selagem', 'Cabelo Longo', '90 a 120 min'),
(21, 'R$265,00','Selagem', 'Cabelo Extra Longo', '120 a 180 min'),
(22, 'R$240,00', 'Escova Temporária', 'Cabelo Curto', '20 a 30 min'),
(23, 'R$315,00', 'Escova Temporária', 'Cabelo Médio', '30 a 45 min'),
(24, 'R$350,00','Escova Temporária', 'Cabelo Longo', '45 a 60 min'),
(25, 'R$360,00','Escova Temporária', 'Cabelo Extra Longo','60 a 90 min'),
(26, 'R$105,00', 'Hidratações Truss/Wella', 'Cabelo Curto', '20 a 30 min'),
(27, 'R$135,00', 'Hidratações Truss/Wella', 'Cabelo Médio', '30 a 40 min'),
(28, 'R$165,00','Hidratações Truss/Wella', 'Cabelo Longo', '40 a 50 min'),
(29, 'R$178,00','Hidratações Truss/Wella', 'Cabelo Extra Longo', '50 a 70 min'),
(30, 'R$131,00', 'Reconstrução', 'Cabelo Curto', '25 a 35 min'),
(31, 'R$195,00', 'Reconstrução', 'Cabelo Médio', '35 a 45 min'),
(32, 'R$217,00','Reconstrução', 'Cabelo Longo', '45 a 60 min'),
(33, 'R$229,00','Reconstrução', 'Cabelo Extra Longo', '60 a 80 min'),
(34, 'R$92,00', 'Corte', 'Corte de cabelo de todos tamanhos', '55 min'),
(35, 'R$22,00', 'Shampoo', 'Lavagem de cabelos de variados tamanhos', ''),
(36, 'R$175,00', 'Maquiagem', 'Make-ups de alta qualidade para realçar sua beleza', '20 a 40 min'),
(37, 'R$108,00', 'Aplicação de coloração', 'Tingimento de Cabelos', '45 a 60 min'),
(38, 'R$150,00 á R$240,00', 'Penteado', 'Penteados para realçar sua beleza', '60 a 90 min'),
(39, 'R$25,00', 'Babyliss', 'Somente o Babyliss', '20 a 60 min'),
(40, 'R$128,00', 'Meia coloração', '½ coloração da cabeça', '30 a 45 min'),
(41, 'R$192,00', 'Coloração', 'Utilização de 1 frasco aplicador de tintura', '30 a 45 min'),
(42, 'R$217,00', 'Coloração', 'Utilização de 1 frasco e ½ de aplicador de tintura', '30 a 45 min'),
(43, 'R$254,00', 'Coloração', 'Utilização de 2 frascos aplicador de tintura', '30 a 45 min'),
(44, 'R$36,00', 'Pedicure', 'Saúde e beleza para os pés', '40 a 60 min'),
(45, 'R$36,00', 'Manicure', 'Saúde e beleza das mãos', '30 a 45 min'),
(46, 'R$44,00', 'Spa de pés', 'Tratamento que oferece hidratação e bem-estar ', '45 a 60 min'),
(47, 'R$40,00', 'Sobrancelha', 'Design e modelagem das sobrancelhas', '15 a 30 min'),
(48, 'R$14,00', 'Buço', 'Depilação do buço', '5 a 10 min'),
(49, 'R$100,00', 'Tiara Selagem', 'Nutri, Hidrata e Repara cabelos danificados', '60 a 90 min'),
(50, 'R$170,00', 'Combo Corte', 'Corte + Hidratação', '30 a 60 min'),
(51, 'R$270,00', 'Combo Coloração', 'Coloração + Hidratação', '90 a 150 min'),
(52, 'R$460,00', 'Pacote', '6 secagens + 2 tratamentos(qualquer tamanho de cabelo)', '120 a 180 min por sessão');

-- Tabela de serviço com os serviços oferecidos pela casa camarim
insert ignore into tb_agenda(id_agenda, data_agenda, hora)
values (1, '10/10', '13:00'),
(2, '11/10', '14:00'),
(3, '11/10', '15:00');