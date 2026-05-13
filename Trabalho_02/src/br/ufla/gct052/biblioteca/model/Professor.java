package br.ufla.gct052.biblioteca.model;

public class Professor extends Usuario{
    private String departamento;
    private String titulacao;

    public Professor(String id, String nome, String departamento, String titulacao){
        super(id, nome);

        if (departamento != null && !departamento.isBlank() && titulacao != null && !titulacao.isBlank()) {
            this.titulacao = titulacao;
            this.departamento = departamento;
        } else {
            throw new IllegalArgumentException("Argumento inválido");
        }
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getTitulacao() {
        return titulacao;
    }
    
    @Override
    public int getLimiteEmprestimos() {
        return 5;
    }

    @Override
    public String toString() {
        return super.toString()+"\ndepartamento: " + this.getDepartamento()
        + "\nTitulação: " + this.getTitulacao();
    }   
    
    @Override
    public String tipo(){
        return "PROFESSOR";
    }
}
