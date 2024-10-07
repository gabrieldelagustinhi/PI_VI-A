# IMDAZ

API para gestão de usuários do IMDAZ

## Funcionalidades

### Usuário

- Criar um novo usuário: `POST /usuarios` 
- Listar usuários: `GET /usuarios`
- Buscar usuários por ID: `GET /usuarios/{id}`
- Remover usuário: `DELETE /usuarios/{id}`

### Aluno

- Criar um novo aluno: `POST /alunos`
- Listar alunos: `GET /alunos`
- Buscar aluno por ID: `GET /alunos/{id}`
- Remover aluno: `DELETE /alunos/{id}`

### Mãe

- Criar uma mãe: `POST /maes`
- Listar mães: `GET /maes`
- Buscar mãe por ID: `GET /maes/{id}`
- Remover mãe: `DELETE /maes/{id}`

### Filhos

- Adicionar filho: `POST /filhos`
- Remover filho: `DELETE /filhos/{id}`

### Aniversários

- Lista aniversários: `GET /filhos`

## Dependências

- Java 17
- PostgreSQL 17
- Criar objetos de banco: `data/schema.sql`
- Carga inicial: `data/insert.sql`
- Arquivo do postman: `data/imdaz.postman_collection.json`
