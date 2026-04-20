package br.ufla.gct052.encapsulamento.model;

public class Conta {
    public static int proximoNumero = 1;
    /* PARTE A
    public int numero = 0;
    public double saldo;
    public double limite;
    public Cliente titular;
    */

    private int numero = 0;
    private double saldo;
    private double limite;
    private Cliente titular;

    //construtor
    public Conta(double saldo,double limite, Cliente titular){
        if(saldo >= 0 && limite >= 0 && titular != null){
            this.saldo = saldo;
            this.limite = limite;
            this.titular = titular;
            
            //incrementa o numero da conta
            this.numero = proximoNumero;
            proximoNumero ++;
        } else{
            throw new IllegalArgumentException("Erro ao criar conta. Argumento invalido!");
        }
        
    }

    public void depositar(double valor){
        if (valor > 0) {
            this.saldo += valor;
        }
    }

    public boolean sacar(double valor){
        if (valor > 0 && this.limite >= 0) {
            if (this.saldo + this.limite >= valor) {
                saldo -= valor;
                return true;
            }
        }
        return false;
    }

    public boolean transferir(Conta destino, double valor){
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    //getters
    public int getNumero(){
        return this.numero;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public double getLimite(){
        return this.limite;
    }

    public Cliente getTitular(){
        return this.titular;
    }

    @Override
    public String toString(){
        return "Numero: " + numero + " | Saldo: " + saldo + " | Limite: " + limite + " | Titular: " + titular.toString();
    }
}
