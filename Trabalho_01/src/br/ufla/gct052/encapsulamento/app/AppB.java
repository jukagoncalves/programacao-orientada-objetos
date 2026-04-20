package br.ufla.gct052.encapsulamento.app;

import br.ufla.gct052.encapsulamento.model.Cliente;
import br.ufla.gct052.encapsulamento.model.Conta;

public class AppB {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Juka", "123.456.789-12");
        Conta contaJuka = new Conta(10000, 5000, cliente1);
        Cliente cliente2 = new Cliente("joao", "001.002.003-04");
        Conta contaJoao = new Conta(3200, 2000, cliente2);

        System.out.println(contaJuka.toString());
        System.out.println(contaJoao.toString());

        System.out.println("\nTentativa de erro de criação de obj:");
        try {
            new Cliente("Fantasma", "");
        } catch (Exception e) {
            System.out.println("Erro capturado: " + e.getMessage());
        }
        
        try{
            new Conta(10000, 5000, null);
        } catch (Exception e){
            System.out.println("Erro capturado: " + e.getMessage());
        }
        
        
        System.out.println("\n===================================");
        System.out.println("Teste: Depósito");
        System.out.println("===================================");
        System.out.println("[ANTES] " + contaJuka.toString());
        System.out.println("[AÇÃO] depositar(3500)");
        contaJuka.depositar(3500);
        System.out.println("[DEPOIS] " + contaJuka.toString());
        
        System.out.println("\n===================================");
        System.out.println("Teste: Saque");
        System.out.println("===================================");
        System.out.println("[ANTES] " + contaJuka.toString());
        System.out.println("[AÇÃO] sacar(7000)");
        contaJuka.sacar(7000);
        System.out.println("[DEPOIS] " + contaJuka.toString());

        System.out.println("\n===================================");
        System.out.println("Teste: Transferencia");
        System.out.println("===================================");
        System.out.println("[ANTES] " + contaJuka.toString() + "\n" + 
                                        contaJoao.toString());
        System.out.println("[AÇÃO] transferir(contaJoao, 1500)");
        contaJuka.transferir(contaJoao, 1500);
        System.out.println("[DEPOIS]" + contaJuka.toString() + "\n" +
                                        contaJoao.toString());
        
        System.out.println("\n===================================");
        System.out.println("Teste: Saque Impossivel");
        System.out.println("===================================");
        System.out.println("[ANTES] " + contaJuka.toString());
        System.out.println("[AÇÃO] sacar(20000)");
        contaJuka.sacar(20000);
        System.out.println("Saque inválido!");
        System.out.println("[DEPOIS] " + contaJuka.toString());
    }
}
