-- Inserindo os dados de usuário das mães 
INSERT INTO usuario (nome, genero, etnia, data_nascimento, deficiencia, telefone, alfabetizado, rg, data_emissao_rg, cpf, bairro, endereco, renda_familiar_mensal, recebe_bolsa_familia, nis, direito_imagem)
VALUES
('Maria Silva', 'Feminino', 'Branca', '1985-04-15', FALSE, '555199999999', TRUE, '123456789', '2005-01-15', '12345678901', 'Centro', 'Rua das Flores, 123', 2000.00, TRUE, '1234567890', TRUE),
('Ana Pereira', 'Feminino', 'Negra', '1990-05-20', FALSE, '555188888888', TRUE, '987654321', '2010-02-20', '09876543210', 'Bela Vista', 'Rua dos Pinheiros, 456', 1500.00, FALSE, NULL, FALSE);

-- Inserindo os usuários  de filhos da mãe 1 (Maria Silva, com 1 filho) e mãe 2 (Ana Pereira, com 3 filhos)
INSERT INTO usuario (nome, genero, etnia, data_nascimento, deficiencia, telefone, alfabetizado, rg, data_emissao_rg, cpf, bairro, endereco, renda_familiar_mensal, recebe_bolsa_familia, nis, direito_imagem)
VALUES
-- Filho da Maria Silva
('João Silva', 'Masculino', 'Branca', '2010-07-10', FALSE, '555199999900', TRUE, '111222333', '2020-03-15', '11122233344', 'Centro', 'Rua das Flores, 123', 0.00, FALSE, NULL, FALSE),

-- Filhos da Ana Pereira
('Carlos Pereira', 'Masculino', 'Negra', '2008-08-12', FALSE, '555188888899', TRUE, '222333444', '2018-04-10', '22233344455', 'Bela Vista', 'Rua dos Pinheiros, 456', 0.00, FALSE, NULL, FALSE),
('Julia Pereira', 'Feminino', 'Negra', '2012-11-22', FALSE, '555188888800', TRUE, '333444555', '2018-05-10', '33344455566', 'Bela Vista', 'Rua dos Pinheiros, 456', 0.00, FALSE, NULL, FALSE),
('Pedro Pereira', 'Masculino', 'Negra', '2015-03-05', FALSE, '555188888811', TRUE, '444555666', '2020-06-01', '44455566677', 'Bela Vista', 'Rua dos Pinheiros, 456', 0.00, FALSE, NULL, FALSE);


-- Inserindo o filho da Maria Silva como aluno
INSERT INTO aluno (id_usuario, ano_escolar, escola, turno, turma, tem_irmao_instituicao, nome_responsavel, parentesco_responsavel)
VALUES
((SELECT id FROM usuario WHERE nome = 'João Silva'), '5º Ano', 'Escola Municipal Centro', 'Manhã', 'Turma A', FALSE, 'Maria Silva', 'Mãe');

-- Inserindo os filhos da Ana Pereira como alunos
INSERT INTO aluno (id_usuario, ano_escolar, escola, turno, turma, tem_irmao_instituicao, nome_responsavel, parentesco_responsavel)
VALUES
((SELECT id FROM usuario WHERE nome = 'Carlos Pereira'), '7º Ano', 'Escola Estadual Bela Vista', 'Tarde', 'Turma B', TRUE, 'Ana Pereira', 'Mãe'),
((SELECT id FROM usuario WHERE nome = 'Julia Pereira'), '3º Ano', 'Escola Estadual Bela Vista', 'Manhã', 'Turma A', TRUE, 'Ana Pereira', 'Mãe'),
((SELECT id FROM usuario WHERE nome = 'Pedro Pereira'), 'Pré-Escola', 'Escola Estadual Bela Vista', 'Manhã', 'Turma C', TRUE, 'Ana Pereira', 'Mãe');

-- Inserindo a mãe Maria Silva
INSERT INTO mae (id_usuario, quantos_filhos, trabalha_fora, tem_com_quem_deixar_filhos, com_quem_deixar_filhos, quer_participar_projeto, projeto, cpf_nota_gaucha, tipo_residencia, numero_pecas, possui_banheiro, possui_luz)
VALUES
((SELECT id FROM usuario WHERE nome = 'Maria Silva'), 1, TRUE, TRUE, 'Avó', TRUE, 'Culinária', TRUE, 'Casa', 5, TRUE, TRUE);

-- Inserindo a mãe Ana Pereira
INSERT INTO mae (id_usuario, quantos_filhos, trabalha_fora, tem_com_quem_deixar_filhos, com_quem_deixar_filhos, quer_participar_projeto, projeto, cpf_nota_gaucha, tipo_residencia, numero_pecas, possui_banheiro, possui_luz)
VALUES
((SELECT id FROM usuario WHERE nome = 'Ana Pereira'), 3, FALSE, TRUE, 'Tia', TRUE, 'Costura', FALSE, 'Apartamento', 4, TRUE, TRUE);

-- Associando o filho João Silva à mãe Maria Silva
INSERT INTO filhos (id_mae, id_usuario)
VALUES
((SELECT id FROM mae WHERE id_usuario = (SELECT id FROM usuario WHERE nome = 'Maria Silva')), (SELECT id FROM usuario WHERE nome = 'João Silva'));

-- Associando os filhos Carlos, Julia e Pedro Pereira à mãe Ana Pereira
INSERT INTO filhos (id_mae, id_usuario)
VALUES
((SELECT id FROM mae WHERE id_usuario = (SELECT id FROM usuario WHERE nome = 'Ana Pereira')), (SELECT id FROM usuario WHERE nome = 'Carlos Pereira')),
((SELECT id FROM mae WHERE id_usuario = (SELECT id FROM usuario WHERE nome = 'Ana Pereira')), (SELECT id FROM usuario WHERE nome = 'Julia Pereira')),
((SELECT id FROM mae WHERE id_usuario = (SELECT id FROM usuario WHERE nome = 'Ana Pereira')), (SELECT id FROM usuario WHERE nome = 'Pedro Pereira'));
