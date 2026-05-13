package br.ufla.gct052.biblioteca.app;

import java.util.List;

import br.ufla.gct052.biblioteca.model.Aluno;
import br.ufla.gct052.biblioteca.model.Biblioteca;
import br.ufla.gct052.biblioteca.model.Exemplar;
import br.ufla.gct052.biblioteca.model.Professor;
import br.ufla.gct052.biblioteca.model.Servidor;
import br.ufla.gct052.biblioteca.model.Usuario;

public class Main {
    public static void main(String[] args){
        Aluno aluno = new Aluno("202601", "Juka", "engenharia de software", 1);
        Professor professor = new Professor("202602", "Alysson", "ICTIN", "Doutorado");
        Servidor funcionario = new Servidor("202603", "Ana Beatriz", "secretaria", "auxiliar administrativa");
        Exemplar exemplar01 = new Exemplar("001", "Sistemas Operacionais Modernos");
        Exemplar exemplar02 = new Exemplar("002", "Rede de computadores");
        Exemplar exemplar03 = new Exemplar("003", "Clean Code");
        Exemplar exemplar04 = new Exemplar("004", "Arquitetura Limpa");
        Exemplar exemplar05 = new Exemplar("005", "Teste de Invasão");
        Exemplar exemplar06 = new Exemplar("006", "Microeconomia");
        Exemplar exemplar07 = new Exemplar("007", "A republica");
        Exemplar exemplar08 = new Exemplar("008", "Rapido e Devagar");
        Exemplar exemplar09 = new Exemplar("009", "Leviatan");
        Exemplar exemplar10 = new Exemplar("010", "Habitos Atomicos");
        
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.cadastrarUsuario(aluno);
        biblioteca.cadastrarUsuario(professor);
        biblioteca.cadastrarUsuario(funcionario);
        biblioteca.cadastrarExemplar(exemplar01);
        biblioteca.cadastrarExemplar(exemplar02);
        biblioteca.cadastrarExemplar(exemplar03);
        biblioteca.cadastrarExemplar(exemplar04);
        biblioteca.cadastrarExemplar(exemplar05);
        biblioteca.cadastrarExemplar(exemplar06);
        biblioteca.cadastrarExemplar(exemplar07);
        biblioteca.cadastrarExemplar(exemplar08);
        biblioteca.cadastrarExemplar(exemplar09);
        biblioteca.cadastrarExemplar(exemplar10);
        
        System.out.println("------- T2: POLIMORFISMO -------");
        List<Usuario> listaDeUsuarios = biblioteca.getUsuarios();
        for(Usuario u:listaDeUsuarios){
            System.out.println(u.toString());
            System.out.println(u.getLimiteEmprestimos());
        }

        System.out.println("\n------- T3 -------");
        System.out.println("Emprestimo para o Aluno " + aluno.getNome());
        System.out.println("Emprestimo 1: " + biblioteca.emprestar("202601", "001"));
        System.out.println("Emprestimo 2: " + biblioteca.emprestar("202601", "002"));
        System.out.println("Emprestimo 3: " + biblioteca.emprestar("202601", "003"));
        System.out.println("Emprestimo 4: " + biblioteca.emprestar("202601", "004"));
        System.out.println("Limite do Aluno: " + aluno.getLimiteEmprestimos());


        System.out.println("\nEmprestimo para o Professor " + professor.getNome());
        System.out.println("Emprestimo 1: " + biblioteca.emprestar("202602", "005"));
        System.out.println("Emprestimo 2: " + biblioteca.emprestar("202602", "006"));
        System.out.println("Emprestimo 3: " + biblioteca.emprestar("202602", "007"));
        System.out.println("Emprestimo 4: " + biblioteca.emprestar("202602", "008"));
        System.out.println("Emprestimo 5: " + biblioteca.emprestar("202602", "009"));
        System.out.println("Emprestimo 6: " + biblioteca.emprestar("202602", "010"));
        System.out.println("Limite do Professor: " + professor.getEmprestimosAtivos());

        System.out.println("\n-------- T4 -------");
        System.out.println("Emprestimo disponivel: " + biblioteca.emprestar("202603", "002"));

        System.out.println("\n------ T5 ---------");
        System.out.println("Devolução: " + biblioteca.devolver("202601", "002"));
        System.out.println("Emprestimo: " + biblioteca.emprestar("202603", "002"));

        List<Exemplar> listaDeExemplares = biblioteca.getExemplares();
        for(Exemplar e:listaDeExemplares){
            System.out.println(e.toString());
        }
    }
}
