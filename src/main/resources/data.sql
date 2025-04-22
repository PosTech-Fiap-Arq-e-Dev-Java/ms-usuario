INSERT INTO tb_tipo_usuario (id, descricao) VALUES (1, 'Comum')
    ON DUPLICATE KEY UPDATE descricao = VALUES(descricao);

INSERT INTO tb_tipo_usuario (id, descricao) VALUES (2, 'Parceiro')
    ON DUPLICATE KEY UPDATE descricao = VALUES(descricao);
