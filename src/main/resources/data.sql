insert ignore into TipoUsuario(id_tipo, nome_tipo, cpf)
values (1, 'Cliente'), (2, 'Admin');

insert ignore into tb_usuario(id_usuario, nome, telefone, tipo_cliente_id)
values (1, 'admin@gmail.com', 'AdminQu8', 'admin32u', 2)