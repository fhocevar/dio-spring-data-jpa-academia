# Academia Digital — DIO Spring Data JPA

API RESTful de gerenciamento de academia com **Java 21, Spring Boot 3.5.16, Spring Data JPA e PostgreSQL 16**, desenvolvida como implementação própria do desafio da DIO ministrado por Camila Cavalcante.

## Funcionalidades
- CRUD de alunos, matrícula e avaliação física (cadastro, listagem e exclusão dos registros relacionados)
- Consultas por nome e bairro, e por aluno nas matrículas/avaliações
- Validação de entrada e mensagens de erro HTTP
- Cálculo de IMC na resposta da avaliação
- Swagger UI e testes com JUnit / H2

## Requisitos (Windows 11 ou Linux Zorin)
- JDK 21 (`java -version`)
- Maven 3.9+ (`mvn -version`)
- Docker com Compose (`docker compose version`), **ou** PostgreSQL 16 instalado localmente
- VS Code (opcional)

## Início rápido

### Windows PowerShell
```powershell
Expand-Archive .\dio-spring-data-jpa-academia.zip -DestinationPath .
cd .\dio-spring-data-jpa-academia
.\scripts\iniciar-windows.ps1
```
Se a política do PowerShell bloquear scripts, execute manualmente `docker compose up -d` e `mvn spring-boot:run`.

### Linux (Zorin OS)
```bash
unzip dio-spring-data-jpa-academia.zip
cd dio-spring-data-jpa-academia
bash scripts/iniciar-linux.sh
```

### Sem Docker
Crie no PostgreSQL o banco `academia` e um usuário com permissão para criar tabelas. Configure `DB_URL`, `DB_USER`, `DB_PASSWORD` no terminal, então execute `mvn spring-boot:run`. Exemplo de URL: `jdbc:postgresql://localhost:5432/academia`.

> Se a porta 5432 já estiver ocupada, configure `DB_PORT=5433` no Compose **e** `DB_URL=jdbc:postgresql://localhost:5433/academia` para a aplicação.

## Documentação interativa
- http://localhost:8080/swagger-ui.html
- http://localhost:8080/v3/api-docs

## Endpoints
| Método | Rota | Descrição |
|---|---|---|
| POST | /api/alunos | Cadastrar aluno |
| GET | /api/alunos | Listar; filtros `nome` e `bairro` |
| GET | /api/alunos/{id} | Buscar |
| PUT | /api/alunos/{id} | Atualizar |
| DELETE | /api/alunos/{id} | Excluir se não houver registros associados |
| POST | /api/matriculas | Matricular aluno |
| GET | /api/matriculas | Listar; filtro `alunoId` |
| DELETE | /api/matriculas/{id} | Excluir matrícula |
| POST | /api/avaliacoes | Registrar avaliação |
| GET | /api/avaliacoes | Listar; filtro `alunoId` |
| DELETE | /api/avaliacoes/{id} | Excluir avaliação |

### Exemplo de cadastro
```json
{"nome":"Maria Silva","cpf":"12345678901","bairro":"Centro","dataDeNascimento":"1995-05-10"}
```
O CPF é validado quanto ao formato (11 dígitos), não quanto aos dígitos verificadores.

### Exemplo de matrícula
```json
{"alunoId":1}
```

### Exemplo de avaliação
```json
{"alunoId":1,"peso":72.5,"altura":1.75}
```

## Testes
```bash
mvn test
mvn clean package
```
Os testes usam H2 em memória e não precisam de PostgreSQL.

## Arquitetura
`Controller -> Service -> Repository -> PostgreSQL`

Entidades: `Aluno (1) -> (N) Matricula` e `Aluno (1) -> (N) AvaliacaoFisica`.

## Publicar no GitHub
```bash
git init
git add .
git commit -m "feat: implementa API academia digital com Spring Data JPA"
git branch -M main
git remote add origin https://github.com/SEU_USUARIO/dio-spring-data-jpa-academia.git
git push -u origin main
```
Crie antes um repositório vazio no GitHub. Não publique senhas reais.

## Observações
- `ddl-auto=update` é adequado para laboratório, mas em produção prefira migrações Flyway ou Liquibase.
- A API não possui autenticação e não deve ser exposta publicamente sem controles adicionais.
- Credenciais do Compose são apenas para desenvolvimento local.
- Projeto elaborado a partir do desafio DIO; código de referência: https://github.com/cami-la/academia-dio
