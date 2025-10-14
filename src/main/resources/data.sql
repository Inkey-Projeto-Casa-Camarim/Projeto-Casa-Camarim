-- Insere registros na tabela tipo_usuario, ignorando conflitos de chave primária ou únicos
insert ignore into tipo_usuario (id_tipo, nome_tipo, cpf) 
values (1, 'Cliente', '00000000000'), -- Insere o tipo de usuário "Cliente" com CPF fictício
(2, 'Admin',   '11111111111'); -- Insere o tipo de usuário "Admin" com CPF fictício

-- Insere um registro na tabela "tb_usuario" com os valores especificados.
-- "insert ignore" evita erro caso já exista um registro com o mesmo "id_usuario" (não insere duplicatas).
insert ignore into tb_usuario(id_usuario, nome, telefone)
values (1, 'Administrador', '15999999999'); -- Valores dos campos inseridos

-- Tabela de serviço com os serviços oferecidos pela casa camarim
insert ignore into tb_servico(id_servico, preco, nome_servico, descricao_servico)
values (1, 'R$462,00', 'Cronograma Capilar Cabelo Médio', 'Pacote com 6 tratamentos'),
(2, 'R$535,00', 'Cronograma Capilar Cabelo Longo', 'Pacote com 4 tratamentos'),
(3, 'R$370,00', 'Pacote com 6 Escovas', 'Cabelo Médio'),
(4, 'R$408,00','Pacote com 6 Escovas', 'Cabelo Longo'),
(5, 'R$198,00','Pacote Nails', 'Pacote com 6 atendimentos de unha'),
(6, 'R$64,00', 'Escova', 'Cabelo Curto'),
(7, 'R$77,00', 'Escova', 'Cabelo Médio'),
(8, 'R$85,00','Escova', 'Cabelo Longo'),
(9, 'R$90,00','Escova', 'Cabelo Extra Longo'),
(10, 'R$54,00', 'Secagem', 'Cabelo Curto'),
(11, 'R$57,00', 'Secagem', 'Cabelo Médio'),
(12, 'R$68,00','Secagem', 'Cabelo Longo'),
(13, 'R$70,00','Secagem', 'Cabelo Extra Longo'),
(14, 'R$335,00 á R$480,00', 'Luzes', 'Cabelo Curto'),
(15, 'R$550,00', 'Luzes', 'Cabelo Médio'),
(16, 'R$630,00','Luzes', 'Cabelo Longo'),
(17, 'R$725,00','Luzes', 'Cabelo Extra Longo'),
(18, 'R$182,00', 'Selagem', 'Cabelo Curto'),
(19, 'R$220,00', 'Selagem', 'Cabelo Médio'),
(20, 'R$240,00','Selagem', 'Cabelo Longo'),
(21, 'R$265,00','Selagem', 'Cabelo Extra Longo'),
(22, 'R$240,00', 'Escova Temporária', 'Cabelo Curto'),
(23, 'R$315,00', 'Escova Temporária', 'Cabelo Médio'),
(24, 'R$350,00','Escova Temporária', 'Cabelo Longo'),
(25, 'R$360,00','Escova Temporária', 'Cabelo Extra Longo'),
(26, 'R$105,00', 'Hidratações Truss/Wella', 'Cabelo Curto'),
(27, 'R$135,00', 'Hidratações Truss/Wella', 'Cabelo Médio'),
(28, 'R$165,00','Hidratações Truss/Wella', 'Cabelo Longo'),
(29, 'R$178,00','Hidratações Truss/Wella', 'Cabelo Extra Longo'),
(30, 'R$131,00', 'Reconstrução', 'Cabelo Curto'),
(31, 'R$195,00', 'Reconstrução', 'Cabelo Médio'),
(32, 'R$217,00','Reconstrução', 'Cabelo Longo'),
(33, 'R$229,00','Reconstrução', 'Cabelo Extra Longo'),
(34, 'R$92,00', 'Corte', 'Corte de cabelo de todos tamanhos'),
(35, 'R$22,00', 'Shampoo', 'Lavagem de cabelos de variados tamanhos'),
(36, 'R$175,00', 'Maquiagem', 'Make-ups de alta qualidade para realçar sua beleza'),
(37, 'R$108,00', 'Aplicação de coloração', 'Tingimento de Cabelos'),
(38, 'R$150,00 á R$240,00', 'Penteado', 'Penteados para realçar sua beleza'),
(39, 'R$25,00', 'Babyliss', 'Somente o Babyliss'),
(40, 'R$128,00', 'Meia coloração', '½ coloração da cabeça'),
(41, 'R$192,00', 'Coloração', 'Utilização de 1 frasco aplicador de tintura'),
(42, 'R$217,00', 'Coloração', 'Utilização de 1 frasco e ½ de aplicador de tintura'),
(43, 'R$254,00', 'Coloração', 'Utilização de 2 frascos aplicador de tintura'),
(44, 'R$36,00', 'Pedicure', 'Saúde e beleza para os pés'),
(45, 'R$36,00', 'Manicure', 'Saúde e beleza das mãos'),
(46, 'R$44,00', 'Spa de pés', 'Tratamento que oferece hidratação e bem-estar '),
(47, 'R$40,00', 'Sobrancelha', 'Design e modelagem das sobrancelhas'),
(48, 'R$14,00', 'Buço', 'Depilação do buço'),
(49, 'R$100,00', 'Tiara Selagem', 'Nutri, Hidrata e Repara cabelos danificados'),
(50, 'R$170,00', 'Combo Corte', 'Corte + Hidratação'),
(51, 'R$270,00', 'Combo Coloração', 'Coloração + Hidratação'),
(52, 'R$460,00', 'Pacote', '6 secagens + 2 tratamentos(qualquer tamanho de cabelo)');