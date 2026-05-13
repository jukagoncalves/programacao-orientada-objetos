# GCT052 — Programação Orientada a Objetos
## Trabalho 01 — Encapsulamento em Java

**Universidade Federal de Lavras (UFLA)**  
**Prof. Dr. Alysson Naves**  
**Entrega:** 22/04/2026

---

## Estrutura do Projeto

```
Trabalho_01/
└── src/
    └── br/ufla/gct052/encapsulamento/
        ├── model/
        │   ├── Cliente.java
        │   ├── Conta.java
        │   └── Endereco.java
        └── app/
            ├── App.java      ← Parte A
            ├── AppB.java     ← Parte B
            └── AppC.java     ← Parte C
```

---

## Como Compilar e Executar

Todos os comandos devem ser executados a partir da pasta `src/`.

```bash
cd Trabalho_01/src
```

### Compilar todos os arquivos

```bash
javac br/ufla/gct052/encapsulamento/model/*.java br/ufla/gct052/encapsulamento/app/*.java
```

### Executar cada parte

**Parte A — Demonstração de Problemas:**
```bash
java br.ufla.gct052.encapsulamento.app.App
```

**Parte B — Encapsulamento:**
```bash
java br.ufla.gct052.encapsulamento.app.AppB
```

**Parte C — Referência Mutável:**
```bash
java br.ufla.gct052.encapsulamento.app.AppC
```

> Atenção: na compilação use barras `/` nos caminhos. Na execução use pontos `.` no nome da classe.

---

## Parte A — Demonstração de Problemas com Estado Exposto

O arquivo `App.java` foi escrito com os atributos de `Cliente` e `Conta` públicos (`public`), demonstrando como a ausência de encapsulamento permite que qualquer parte do programa coloque os objetos em estados inválidos e incoerentes.

Foram demonstradas 4 situações problemáticas:

| Problema | Descrição | Risco |
|---|---|---|
| Saldo negativo direto | `conta.saldo = -1000` | Corrompe o estado financeiro sem qualquer validação |
| Limite negativo | `conta.limite = -500` | Reduz indevidamente a capacidade de saque do cliente |
| Titular nulo | `conta.titular = null` seguido de acesso ao campo | Causa `NullPointerException`, tornando a conta inacessível |
| CPF fraudado | `cliente.cpf = "cpf-fraudado"` | Compromete a identidade do cliente, permitindo fraudes |

> Após a refatoração da Parte B, os acessos diretos aos atributos deixaram de compilar — o que demonstra na prática que o encapsulamento torna impossível, já em tempo de compilação, qualquer manipulação indevida do estado interno dos objetos.

---

## Parte B — Refatoração com Encapsulamento

A refatoração aplicou encapsulamento completo nas classes `Cliente` e `Conta`, corrigindo todos os problemas identificados na Parte A.

### O que foi corrigido em `Cliente`

- Atributos `nome` e `cpf` tornados `private`
- Construtor valida que `nome` e `cpf` não sejam nulos ou vazios, lançando `IllegalArgumentException` em caso de violação
- CPF não possui setter — uma vez cadastrado, não pode ser alterado
- Getter para `nome` e `cpf` fornecidos apenas para leitura
- `toString()` implementado para facilitar a exibição

### O que foi corrigido em `Conta`

- Atributos `numero`, `saldo`, `limite` e `titular` tornados `private`
- Construtor valida que `saldo >= 0`, `limite >= 0` e `titular != null`, lançando `IllegalArgumentException` em caso de violação
- Numeração automática e sequencial via atributo estático `proximoNumero`
- `saldo` não possui setter — só pode ser alterado pelos métodos de domínio
- Métodos de domínio implementados com validações:
  - `depositar(double valor)` — exige valor maior que zero
  - `sacar(double valor)` — só realiza o saque se `saldo + limite >= valor`
  - `transferir(Conta destino, double valor)` — utiliza `sacar()` e `depositar()` internamente, garantindo consistência
- Getters fornecidos para `numero`, `saldo`, `limite` e `titular`
- `toString()` implementado para facilitar a exibição

### Testes realizados no AppB

- Criação de objetos válidos e exibição via `toString()`
- Tentativa de criar `Cliente` com CPF vazio — exceção capturada
- Tentativa de criar `Conta` com titular nulo — exceção capturada
- Depósito, saque e transferência com exibição de saldo antes e depois
- Tentativa de saque impossível — sistema rejeita corretamente sem alterar o saldo

---

## Parte C — Referência Mutável

### O problema

Mesmo com atributos `private`, existe uma vulnerabilidade sutil: quando um getter retorna a **referência direta** de um objeto interno, quem recebe essa referência pode modificar o estado interno da classe sem passar por nenhuma validação.

No exemplo implementado, `Cliente` possui um atributo `private Endereco endereco`. O método `getEnderecoInseguro()` retorna a referência direta:

```java
public Endereco getEnderecoInseguro() {
    return endereco; // retorna a referência real
}
```

Isso permite que código externo faça:

```java
cliente.getEnderecoInseguro().setRua("Rua Falsa");
```

E o endereço interno do cliente é alterado **sem que Cliente tenha qualquer controle sobre isso**, tornando o `private` ineficaz.

### A correção — Cópia Defensiva

A correção foi aplicada no método `getEndereco()`, que em vez de retornar a referência direta, retorna uma **nova instância** de `Endereco` com os mesmos dados:

```java
public Endereco getEndereco() {
    return new Endereco(endereco.getRua(), endereco.getNumero(), endereco.getBairro());
}
```

Agora, quem recebe o endereço recebe uma **cópia independente**. Qualquer alteração feita nessa cópia não afeta o objeto interno de `Cliente`, garantindo que o estado interno só possa ser modificado por métodos controlados da própria classe.

---

## Principais Aprendizados

- **Encapsulamento** não é apenas tornar atributos privados — é garantir que o estado interno de um objeto só possa ser alterado de formas válidas e controladas, por meio de métodos com regras de negócio bem definidas.

- **Atributos públicos** permitem que qualquer parte do programa coloque objetos em estados inválidos, tornando o sistema imprevisível e difícil de manter.

- **Métodos de domínio** como `depositar()`, `sacar()` e `transferir()` centralizam as regras de negócio dentro da própria classe, evitando duplicação e garantindo consistência.

- **Referências mutáveis** são uma forma sutil de quebrar o encapsulamento mesmo com atributos privados. A cópia defensiva é uma estratégia eficaz para proteger o estado interno quando um objeto precisa expor referências a outros objetos.

- **Construtores com validação** são a primeira linha de defesa para garantir que um objeto nunca seja criado em um estado inválido.
