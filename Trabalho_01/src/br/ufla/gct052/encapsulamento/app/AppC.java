package br.ufla.gct052.encapsulamento.app;

import br.ufla.gct052.encapsulamento.model.Cliente;
import br.ufla.gct052.encapsulamento.model.Endereco;

public class AppC {
    public static void main(String[] args) {
        Cliente fulana = new Cliente("maria", "111.222.333-44");
        Endereco endFulana = new Endereco("Corleone", 15, "Vila prudente");
        fulana.setEndereco(endFulana);
        
        System.out.println("[ANTES] Endereco interno do cliente:");
        System.out.println(fulana.getEndereco());

        //alterando endereco interno
        System.out.println("\n[AÇÃO] Pega a referencia via getter e altera.");
        fulana.getEnderecoInseguro().setRua("null");
        fulana.getEnderecoInseguro().setNumero(00);
        fulana.getEnderecoInseguro().setBairro("null");

        System.out.println("\n[DEPOIS] Endereço interno mudou sem passar por Cliente:");
        System.out.println(fulana.getEndereco());

        System.out.println("\n==============CORREÇÃO==============\n");
        
        Cliente fulano = new Cliente("Mário", "999.888.777-66");
        Endereco endFulano = new Endereco("Paulo Nogueira", 77, "Centro");
        fulano.setEndereco(endFulano);
        
        System.out.println("[ANTES] Endereco interno do cliente:");
        System.out.println(fulano.getEndereco());

        //tentativa de alteracao com copia defensiva
        System.out.println("\n[AÇÃO] Tenta alterar via getEndereco() com copia defensiva.");
        fulano.getEndereco().setRua("null");
        fulano.getEndereco().setNumero(0);
        fulano.getEndereco().setBairro("null");

        System.out.println("\n[DEPOIS] Endereço interno não mudou:");
        System.out.println(fulano.getEndereco());
    }
}
