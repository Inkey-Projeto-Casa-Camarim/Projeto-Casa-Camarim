-- Inserir serviços
INSERT INTO servicos (nome, preco, duracao_minutos) VALUES 
('Corte', 'R$50,00', '45 minutos'),
('Loiro', 'R$ 150,00', '120 minutos'),
('Morena iluminada', 'R$ 120,00', '90 minutos'),
('Maquiagem', 'R$ 80,00', '60 minutos'),
('Coloração', 'R$ 90,00', '90 minutos'),
('Pedicure', 'R$ 35,00', '45 minutos'),
('Manicure', 'R$ 25,00', '30 minutos'),
('Sobrancelha', 'R$ 20,00', '30 minutos'),
('Buço', 'R$ 15,00', '15 minutos'),
('Selagem', 'R$ 100,00', '90 minutos');

-- Inserir horários disponíveis para os próximos 30 dias
INSERT INTO horarios_disponiveis (data, horario, disponivel, servico_id) 
SELECT 
    CURDATE() + INTERVAL n DAY as data,
    TIME(CONCAT(h, ':00:00')) as horario,
    TRUE as disponivel,
    s.id as servico_id
FROM 
    (SELECT 0 as n UNION SELECT 1 UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 UNION SELECT 5 UNION SELECT 6 
     UNION SELECT 7 UNION SELECT 8 UNION SELECT 9 UNION SELECT 10 UNION SELECT 11 UNION SELECT 12 UNION SELECT 13 
     UNION SELECT 14 UNION SELECT 15 UNION SELECT 16 UNION SELECT 17 UNION SELECT 18 UNION SELECT 19 UNION SELECT 20
     UNION SELECT 21 UNION SELECT 22 UNION SELECT 23 UNION SELECT 24 UNION SELECT 25 UNION SELECT 26 UNION SELECT 27
     UNION SELECT 28 UNION SELECT 29) days,
    (SELECT 9 as h UNION SELECT 10 UNION SELECT 11 UNION SELECT 12 UNION SELECT 13 UNION SELECT 14 UNION SELECT 15 
     UNION SELECT 16 UNION SELECT 17) hours,
    servicos s
WHERE s.id IS NOT NULL;