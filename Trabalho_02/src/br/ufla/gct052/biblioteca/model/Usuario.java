package br.ufla.gct052.biblioteca.model;

public abstract class Usuario {
    private final String id;
    private String nome;
    private int emprestimosAtivos;

    public Usuario(String id, String nome){
        if(id != null && !id.isEmpty() && nome != null && !nome.isEmpty()){
            this.id = id;
            this.nome = nome.toLowerCase();
        } else { 
            throw new IllegalArgumentException("Argumento inválido!");
        }
        this.emprestimosAtivos = 0;
    }

    public String getId(){
        return id;
    }
    
    public String getNome(){
        return nome;
    }

    public int getEmprestimosAtivos(){
        return emprestimosAtivos;
    }

    protected void incrementarEmprestimos(){
        emprestimosAtivos ++;
    }

    protected void decrementarEmprestimos(){
        if(emprestimosAtivos > 0){
            emprestimosAtivos--;
        }
    }

    //cada subclasse define
    public abstract int getLimiteEmprestimos();

    public boolean podeEmprestar(){
        return emprestimosAtivos < getLimiteEmprestimos();
    }

    @Override
    public String toString(){
        return "----" + tipo() + "-----" + "\nID: " + id
         + "\nNome: " + nome + "\nEmprestimos Ativos: " + 
         emprestimosAtivos + "\nLimite de Emprestimos: " + getLimiteEmprestimos();
    }

    public String tipo(){
        return "USUARIO";
    }
}