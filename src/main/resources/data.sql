-- Inserindo clientes
INSERT INTO tb_cliente (nome_cliente, telefone_cliente)
VALUES
('Ana Pereira', '11988887777'),
('Carlos Lima', '15999998888'),
('Denise Pinto', '10999996666');

-- Inserindo profissionais
INSERT INTO tb_profissional (cpf, telefone_profissional, senha, nome_profissional, tipo_acesso)
VALUES
('12345678902', '11999995558', 'CasaCamarim123', 'Ionara', 'Comum'),
('12345678901', '11999995555', 'CasaCamarim321', 'Micheli', 'Admin');

-- Inserindo serviços
INSERT INTO tb_servico (id_servico, preco_servico, nome_servico, descricao_servico, tempo_servico)
VALUES
('R$462,00', 'Cronograma Capilar Cabelo Médio', 'Pacote com 6 tratamentos', '2h a 3h por sessão'),
('R$535,00', 'Cronograma Capilar Cabelo Longo', 'Pacote com 4 tratamentos', '3h a 4h por sessão'),
('R$370,00', 'Pacote com 6 Escovas', 'Cabelo Médio', '45 min a 1 hora e 10 min por sessão'),
('R$408,00','Pacote com 6 Escovas', 'Cabelo Longo', '1h10 a 1h50 por sessão'),
('R$198,00','Pacote Nails', 'Pacote com 6 atendimentos de unha', '40 min por sessão'),
('R$64,00', 'Escova', 'Cabelo Curto', '30 a 50 min'),
('R$77,00', 'Escova', 'Cabelo Médio', '45 min a 1 hora e 10 min'),
('R$85,00','Escova', 'Cabelo Longo', '1h10 a 1h50'),
('R$90,00','Escova', 'Cabelo Extra Longo', '1h25 a 2h30'),
('R$54,00', 'Secagem', 'Cabelo Curto', '5 a 10 min'),
('R$57,00', 'Secagem', 'Cabelo Médio', '10 a 15 min'),
('R$68,00','Secagem', 'Cabelo Longo', '15 a 25 min'),
('R$70,00','Secagem', 'Cabelo Extra Longo', '25 a 35 min'),
('R$335,00 á R$480,00', 'Luzes', 'Cabelo Curto', '45 a 60 min'),
('R$550,00', 'Luzes', 'Cabelo Médio', '60 a 90 min'),
('R$630,00','Luzes', 'Cabelo Longo', '90 a 120 min'),
('R$725,00','Luzes', 'Cabelo Extra Longo', '120 a 180 min'),
('R$182,00', 'Selagem', 'Cabelo Curto', '40 a 60 min'),
('R$220,00', 'Selagem', 'Cabelo Médio', '60 a 90 min'),
('R$240,00','Selagem', 'Cabelo Longo', '90 a 120 min'),
('R$265,00','Selagem', 'Cabelo Extra Longo', '120 a 180 min'),
('R$240,00', 'Escova Temporária', 'Cabelo Curto', '20 a 30 min'),
('R$315,00', 'Escova Temporária', 'Cabelo Médio', '30 a 45 min'),
('R$350,00','Escova Temporária', 'Cabelo Longo', '45 a 60 min'),
('R$360,00','Escova Temporária', 'Cabelo Extra Longo','60 a 90 min'),
('R$105,00', 'Hidratações Truss/Wella', 'Cabelo Curto', '20 a 30 min'),
('R$135,00', 'Hidratações Truss/Wella', 'Cabelo Médio', '30 a 40 min'),
('R$165,00','Hidratações Truss/Wella', 'Cabelo Longo', '40 a 50 min'),
('R$178,00','Hidratações Truss/Wella', 'Cabelo Extra Longo', '50 a 70 min'),
('R$131,00', 'Reconstrução', 'Cabelo Curto', '25 a 35 min'),
('R$195,00', 'Reconstrução', 'Cabelo Médio', '35 a 45 min'),
('R$217,00','Reconstrução', 'Cabelo Longo', '45 a 60 min'),
('R$229,00','Reconstrução', 'Cabelo Extra Longo', '60 a 80 min'),
('R$92,00', 'Corte', 'Corte de cabelo de todos tamanhos', '55 min'),
('R$22,00', 'Shampoo', 'Lavagem de cabelos de variados tamanhos', ''),
('R$175,00', 'Maquiagem', 'Make-ups de alta qualidade para realçar sua beleza', '20 a 40 min'),
('R$108,00', 'Aplicação de coloração', 'Tingimento de Cabelos', '45 a 60 min'),
('R$150,00 á R$240,00', 'Penteado', 'Penteados para realçar sua beleza', '60 a 90 min'),
('R$25,00', 'Babyliss', 'Somente o Babyliss', '20 a 60 min'),
('R$128,00', 'Meia coloração', '½ coloração da cabeça', '30 a 45 min'),
('R$192,00', 'Coloração', 'Utilização de 1 frasco aplicador de tintura', '30 a 45 min'),
('R$217,00', 'Coloração', 'Utilização de 1 frasco e ½ de aplicador de tintura', '30 a 45 min'),
('R$254,00', 'Coloração', 'Utilização de 2 frascos aplicador de tintura', '30 a 45 min'),
('R$36,00', 'Pedicure', 'Saúde e beleza para os pés', '40 a 60 min'),
('R$36,00', 'Manicure', 'Saúde e beleza das mãos', '30 a 45 min'),
('R$44,00', 'Spa de pés', 'Tratamento que oferece hidratação e bem-estar ', '45 a 60 min'),
('R$40,00', 'Sobrancelha', 'Design e modelagem das sobrancelhas', '15 a 30 min'),
('R$14,00', 'Buço', 'Depilação do buço', '5 a 10 min'),
('R$100,00', 'Tiara Selagem', 'Nutri, Hidrata e Repara cabelos danificados', '60 a 90 min'),
('R$170,00', 'Combo Corte', 'Corte + Hidratação', '30 a 60 min'),
('R$270,00', 'Combo Coloração', 'Coloração + Hidratação', '90 a 150 min'),
('R$460,00', 'Pacote', '6 secagens + 2 tratamentos(qualquer tamanho de cabelo)', '120 a 180 min por sessão');

-- Inserindo agendamentos
INSERT INTO tb_agenda (data_agenda, hora_agenda)
VALUES
('2025-11-12', '09:00:00'),
('2025-11-12', '10:30:00');
