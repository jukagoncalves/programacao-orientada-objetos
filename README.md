# GCT052 — Programação Orientada a Objetos

**Universidade Federal de Lavras (UFLA)**  
**Semestre:** 2026/1 — Turma 39A  
**Professor:** Dr. Alysson Alexander Naves Silva  
**Carga Horária:** 68h (34h Teórica + 34h Prática)

---

## 📖 Sobre a Disciplina

A disciplina tem como objetivo desenvolver competências para modelar e implementar soluções em Programação Orientada a Objetos (POO) utilizando Java, abordando desde conceitos básicos como classes, objetos e encapsulamento, até conceitos avançados como herança, polimorfismo, interfaces e tratamento de exceções, com foco em boas práticas e organização do código.

---

## 📁 Estrutura do Repositório

```
POO/
├── Trabalho_01/         ← Atividade 01 — Encapsulamento
│   ├── README.md
│   └── src/
│       └── br/ufla/gct052/encapsulamento/
│           ├── model/
│           └── app/
│
├── Trabalho_02/         ← (em breve)
├── Projeto_Final/       ← (em breve)
└── README.md            ← este arquivo
```

---

## 📋 Conteúdo Programático

### Módulo 1 — Conceitos Básicos de OO
- Paradigmas de programação: Imperativo × Orientado a Objetos
- Classe, objeto, atributos e métodos
- Encapsulamento: `private`, `public`, getters/setters, invariantes
- Construtores, sobrecarga e `this`
- Atributos e métodos estáticos, `final`
- Composição e agregação

### Módulo 2 — Relacionamentos e Herança
- Modelagem OO: responsabilidade de classe e coesão
- Relacionamentos e navegação entre objetos
- Coleções com `ArrayList`
- Herança simples: `extends`, `super`, visibilidade
- Sobrecarga × Sobrescrita, `@Override`
- `toString`, `equals`

### Módulo 3 — Conceitos Avançados
- Polimorfismo e referência do tipo base
- Classes abstratas e métodos abstratos
- Interfaces: contrato e implementação múltipla
- Herança múltipla via interfaces
- Tratamento de exceções: `try/catch/finally`, `throw`, `throws`
- Exceções customizadas

### Módulo 4 — UML e Projeto
- Diagrama de Classes UML
- Relacionamentos: associação, agregação, composição, herança
- Do UML ao código: mapeamento e refatoração
- Testes básicos com JUnit
- Arquitetura em camadas: modelo / serviço / app

---

## 📝 Atividades e Avaliações

| Avaliação | Peso |
|---|---|
| Prova 1 (P1) | 30% |
| Prova 2 (P2) | 30% |
| Projeto Final | 25% |
| Atividades e Listas | 15% |

### Trabalhos entregues

| Trabalho | Tema | Entrega | Status |
|---|---|---|---|
| Trabalho 01 | Encapsulamento em Java | 22/04/2026 | ✅ Concluído |

---

## 🗓️ Cronograma Resumido

| Período | Conteúdo |
|---|---|
| Mar/2026 | Introdução, Paradigmas, Conceitos OO, Encapsulamento |
| Abr/2026 | Construtores, Static, Composição, Herança — **P1 em 28/04** |
| Mai/2026 | Polimorfismo, Classes Abstratas, Projeto Final |
| Jun/2026 | Interfaces, Exceções, UML — **P2 em 17/06** |
| Jul/2026 | Apresentações do Projeto Final |

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java
- **IDE:** Visual Studio Code
- **Extensões:** Extension Pack for Java
- **Versionamento:** Git + GitHub

---

## ▶️ Como Executar os Projetos

Cada trabalho possui seu próprio `README.md` com instruções detalhadas de compilação e execução. De forma geral, todos seguem o padrão:

```bash
# Compilar a partir da pasta src/ do projeto
javac br/ufla/gct052/.../*.java

# Executar usando o nome completo da classe
java br.ufla.gct052....NomeDaClasse
```

> ⚠️ Na compilação use barras `/` nos caminhos. Na execução use pontos `.` no nome da classe.

---

## 📚 Bibliografia

**Básica:**
- KÖLLING, M. *Programação orientada a objetos com Java: uma introdução prática usando o BlueJ.* Pearson, 2004.
- GAMMA, E. et al. *Padrões de projeto: soluções reutilizáveis de software orientado a objetos.* Bookman, 2011.

**Complementar:**
- DEITEL, P.; DEITEL, H. *Java: como programar.* Pearson, 2017.
- HORSTMANN, C.; CORNELL, G. *Core Java, Volume I — Fundamentos.* Pearson, 2009.
