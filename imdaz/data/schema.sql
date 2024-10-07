CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    etnia VARCHAR(50) NOT NULL,
    data_nascimento DATE NOT NULL,
    deficiencia BOOLEAN NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    alfabetizado BOOLEAN,
    rg VARCHAR(20) NOT NULL,
    data_emissao_rg DATE NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    renda_familiar_mensal DECIMAL(10, 2) NOT NULL,
    recebe_bolsa_familia BOOLEAN,
	nis VARCHAR(20),
    direito_imagem BOOLEAN
);

CREATE TABLE aluno (
    id SERIAL PRIMARY KEY,
    id_usuario INT REFERENCES usuario(id),
    ano_escolar VARCHAR(20),
    escola VARCHAR(255) NOT NULL,
    turno VARCHAR(50) NOT NULL,
    turma VARCHAR(50) NOT NULL,
    tem_irmao_instituicao BOOLEAN,
    nome_responsavel VARCHAR(255) NOT NULL,
    parentesco_responsavel VARCHAR(100) NOT NULL
);

CREATE TABLE mae (
    id SERIAL PRIMARY KEY,
    id_usuario INT REFERENCES usuario(id),
    quantos_filhos INT NOT NULL,
    trabalha_fora BOOLEAN,
    tem_com_quem_deixar_filhos BOOLEAN,
    com_quem_deixar_filhos VARCHAR(255) NOT NULL,
    quer_participar_projeto BOOLEAN,
    projeto VARCHAR(255),
    cpf_nota_gaucha BOOLEAN,
    tipo_residencia VARCHAR(100) NOT NULL,
    numero_pecas INT NOT NULL,
    possui_banheiro BOOLEAN,
    possui_luz BOOLEAN
);

CREATE TABLE filhos (
    id SERIAL PRIMARY KEY,
    id_mae INT REFERENCES mae(id),
    id_usuario INT REFERENCES usuario(id),
	CONSTRAINT ul_mae_usuario UNIQUE (id_mae, id_usuario)
	
);

CREATE TABLE autorizado_buscar (
    id SERIAL PRIMARY KEY,
    id_usuario INT REFERENCES usuario(id),
    nome_pessoa_autorizada VARCHAR(255) NOT NULL
);

select * from usuario