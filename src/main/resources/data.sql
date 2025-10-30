-- Inserindo serviços
INSERT INTO tb_servico (preco, nome_servico, descricao_servico, tempo_servico) VALUES
('50.00', 'Corte de Cabelo', 'Corte feminino ou masculino, com lavagem e finalização.', '40 minutos'),
('35.00', 'Manicure', 'Limpeza, corte e esmaltação completa das unhas.', '30 minutos'),
('40.00', 'Pedicure', 'Corte, lixa e esmaltação dos pés.', '30 minutos'),
('120.00', 'Maquiagem', 'Maquiagem completa para eventos e festas.', '60 minutos'),
('25.00', 'Sobrancelha', 'Design de sobrancelhas com pinça e finalização.', '20 minutos');

-- Inserindo agendamentos
INSERT INTO tb_agenda (nome_cliente, telefone, data_agendamento, hora_agendamento) VALUES
('Rafaela Souza', '(11) 99999-1234', '2025-11-01', '14:00:00'),
('Beatriz Lima', '(11) 98888-5678', '2025-11-02', '10:30:00'),
('Ana Costa', '(11) 97777-2468', '2025-11-03', '16:00:00'),
('Juliana Martins', '(11) 95555-8799', '2025-11-04', '09:00:00'),
('Camila Alves', '(11) 96666-1111', '2025-11-04', '15:00:00');

-- Relacionamento Agenda ↔ Serviço
-- Atenção: aqui você precisa usar os IDs que foram gerados automaticamente pelo Hibernate
-- Se quiser popular manualmente, use IDs conhecidos após a inserção
