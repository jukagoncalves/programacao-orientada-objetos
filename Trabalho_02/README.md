# Trabalho 02 — Encapsulamento, Herança e Sobrescrita

**Disciplina:** GCT052 — Programação Orientada a Objetos  
**Universidade Federal de Lavras (UFLA)**  
**Entrega:** 18/05/2026

---

## Objetivo

Aplicar os conceitos de encapsulamento, herança e sobrescrita de métodos em Java, com introdução prática a classes abstratas e polimorfismo, por meio da modelagem de um sistema de controle de usuários e empréstimos de uma biblioteca universitária.

---

## Estrutura do Projeto

```
Trabalho_02/
└── src/
    └── br/ufla/gct052/biblioteca/
        ├── model/
        │   ├── Usuario.java       <- Classe abstrata base
        │   ├── Aluno.java         <- Subclasse: limite de 3 empréstimos
        │   ├── Professor.java     <- Subclasse: limite de 5 empréstimos
        │   ├── Servidor.java      <- Subclasse: limite de 4 empréstimos
        │   ├── Exemplar.java      <- Representa uma cópia física do acervo
        │   └── Biblioteca.java    <- Centraliza operações e regras de negócio
        └── app/
            └── Main.java          <- Demonstração dos cenários de teste
```

---

## Modelagem

### Usuario (abstrata)

Classe base que representa qualquer usuário do sistema. Define atributos comuns (`id`, `nome`, `emprestimosAtivos`), regras de validação e o contrato abstrato `getLimiteEmprestimos()`, que cada subclasse é obrigada a implementar.

### Aluno, Professor, Servidor

Subclasses que herdam de `Usuario` e definem seus próprios atributos específicos e limites de empréstimo:

| Tipo | Limite de Empréstimos | Atributos Específicos |
|---|---|---|
| Aluno | 3 | curso, periodo |
| Professor | 5 | departamento, titulacao |
| Servidor | 4 | setor, cargo |

### Exemplar

Representa uma cópia física de um item do acervo. Controla sua própria disponibilidade e lança `IllegalStateException` caso seja emprestado quando indisponível.

### Biblioteca

Centraliza as operações do sistema. Gerencia as listas internas de usuários e exemplares sem expô-las diretamente, retornando apenas listas não modificáveis via `Collections.unmodifiableList`.

---

## Regras de Negócio

- Um usuário não pode ter empréstimos ativos acima do limite do seu tipo.
- Um exemplar indisponível não pode ser emprestado.
- Ao emprestar: o exemplar torna-se indisponível e os empréstimos ativos do usuário aumentam.
- Ao devolver: o exemplar torna-se disponível e os empréstimos ativos do usuário diminuem.
- Cadastros não aceitam identificadores duplicados.

---

## Conceitos Aplicados

- **Encapsulamento:** atributos privados, validações no construtor, invariantes garantidas
- **Herança:** `Aluno`, `Professor` e `Servidor` reutilizam comportamento de `Usuario`
- **Classe abstrata:** `Usuario` define contrato obrigatório via `getLimiteEmprestimos()`
- **Sobrescrita:** `@Override` em `getLimiteEmprestimos()`, `toString()` e `tipo()` nas subclasses
- **Polimorfismo:** referência do tipo `Usuario` invocando comportamentos distintos em tempo de execução

---

## Como Executar

```bash
# A partir da pasta src/ do projeto
javac br/ufla/gct052/biblioteca/model/*.java br/ufla/gct052/biblioteca/app/Main.java

# Executar
java br.ufla.gct052.biblioteca.app.Main
```

---

## Cenários de Teste (Main)

| Cenário | Descrição |
|---|---|
| T1 | Cadastro de 1 Aluno, 1 Professor, 1 Servidor e 10 exemplares |
| T2 | Polimorfismo: iteração sobre lista de Usuario imprimindo limite de cada tipo |
| T3 | Empréstimos até o limite do Aluno (3) e do Professor (5), com falha na tentativa seguinte |
| T4 | Tentativa de empréstimo de exemplar indisponível |
| T5 | Devolução e novo empréstimo do mesmo exemplar |