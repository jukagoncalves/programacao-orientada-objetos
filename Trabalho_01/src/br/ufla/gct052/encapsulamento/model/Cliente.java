package br.ufla.gct052.encapsulamento.model;
public class Cliente {
    //public String nome; //PARTE A
    //public String cpf;
    
    private String nome;
    private String cpf;
    private Endereco endereco;
    
    //public Cliente(String nome, String cpf){
    //    this.nome = nome;
    //    this.cpf = cpf;
    //}
    
    public Cliente(String nome, String cpf){
        if (nome != null && !nome.isEmpty() && cpf != null && !cpf.isEmpty()) {
            this.nome = nome;
            this.cpf = cpf;
        } else{ 
            throw new IllegalArgumentException("Argumento invalido");
        }
    }

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    @Override
    public String toString(){
        return "Cliente: " + nome + " | Cpf: " + cpf;
    }

    public Endereco getEnderecoInseguro(){
        return endereco;
    }
    
    public Endereco getEndereco(){
        //copia defensiva
        return new Endereco(endereco.getRua(), endereco.getNumero(), endereco.getBairro());
    }

    public void setEndereco(Endereco end){
        this.endereco = end;
    } 
}