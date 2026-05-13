package br.ufla.gct052.encapsulamento.app;

/*
PARTE A — Demonstração de Problemas com Estado Exposto

ATENÇÃO: Este arquivo foi escrito quando os atributos de Cliente e Conta
eram públicos (public). Após a refatoração da Parte B, os atributos foram
encapsulados (private), o que fez com que os acessos diretos deixassem de compilar. 
Isso é exatamente o objetivo do encapsulamento:
tornar impossível, em tempo de compilação, qualquer manipulação indevida
do estado interno dos objetos.

Os imports, criações de objetos e linhas de acesso direto foram comentados
para preservar o código original como registro histórico da Parte A.
 */

//import br.ufla.gct052.encapsulamento.model.Cliente;
//import br.ufla.gct052.encapsulamento.model.Conta;

public class App {
    public static void main(String[] args) throws Exception {        
        //Cliente juka = new Cliente("Juka", "123.456.789-99");
        //Conta contaJuka = new Conta(10000.00, 7500.00, juka);
        
        System.out.println("===================================");
        System.out.println("Problema 1: Saldo negativo direto!");
        System.out.println("===================================");
        //System.out.println("[ANTES] Saldo: " + contaJuka.saldo); //saldo antes de alterar
        //System.out.println("[AÇÃO] contaJuka.saldo = -1000 (acesso direto ao atributo publico)");
        //contaJuka.saldo = -1000;
        //System.out.println("[DEPOIS] Saldo atual: " + contaJuka.saldo);
        System.out.println("[RISCO] Um banco com saldo negativo é incoerente, Há uma ausencia de controle." + "\n" + 
                            "Qualquer parte do programa pode corromper o estado financeiro sem validação");
        
        System.out.println("\n===================================");
        System.out.println("Problema 2: Limite negativo!");
        System.out.println("===================================");
        //System.out.println("[ANTES] Limite: " + contaJuka.limite);
        System.out.println("[AÇÃO] conta.limite = -500.00 (acesso direto ao atributo publico)");
        //contaJuka.limite = -500.00;
        //System.out.println("[DEPOIS] Limite atual: " + contaJuka.limite);
        System.out.println("[RISCO] Um banco com limite negativo é incoerente." + "\n" +
                            "Reduz a capacidade de saque do cliente!");
        
        System.out.println("\n===================================");
        System.out.println("Problema 3: Conta titular null!");
        System.out.println("===================================");
        //System.out.println("[ANTES] Conta titular: " + contaJuka.titular.nome);
        System.out.println("[AÇÃO] conta.titular = null (acesso direto ao atributo publico" + "\n" +
                            "conta.titular.nome (tentar acessar um campo de um atributo nulo)");
        //contaJuka.titular = null;
        //System.out.println("[DEPOIS] Conta titular: " + contaJuka.titular);
        try{
            //System.out.println(contaJuka.titular.nome);
        } catch (NullPointerException exception){
            System.out.println("Erro: Acesso a titular nulo causou NullPointerException!");
        }
        System.out.println("[RISCO] NullPointerException é um erro de exceção para acessar atributos nulo." + "\n" +
                            "É incoerente ter uma conta sem titular, se torna uma conta fantasma sem movimentação.");
        
        System.out.println("\n===================================");
        System.out.println("Problema 4: Cpf alterado após cadastro!");
        System.out.println("===================================");
        //System.out.println("[ANTES] CPF: " + juka.cpf);
        System.out.println("[AÇÃO] cliente.cpf = 'cpf-fraudado' (Alteração de atributo publico)");
        //juka.cpf = "cpf-fraudado";
        //System.out.println("[DEPOIS] CPF: " + juka.cpf);
        System.out.println("[RISCO] Alterar o cpf compromete a integridade e seguranca do cliente" + "\n" + 
                            "Pode levar a fraude de identidade,rastreabilidade,etc.");
    }
}
