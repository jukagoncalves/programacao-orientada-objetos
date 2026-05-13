package br.ufla.gct052.biblioteca.model;

public class Aluno extends Usuario {
    private String curso;
    private int periodo;

    public Aluno(String id, String nome, String curso, int periodo){
        super(id, nome);
        
        if(curso != null && !curso.isBlank()){
            this.curso = curso;
        } else {
            throw new IllegalArgumentException("Argumento Inválido");
        }
        if (periodo > 0 && periodo <= 12) {
            this.periodo = periodo;
        } else {
            throw new IllegalArgumentException("Período Inválido");
        }
    }

    public String getCurso(){
        return curso;
    }

    public int getPeriodo(){
        return periodo;
    }

    @Override
    public int getLimiteEmprestimos() {
        return 3;
    }

    @Override
    public String toString(){
        return super.toString()+"\ncurso: " + getCurso() + "\nPeriodo: " + getPeriodo();        
    }

    @Override
    public String tipo(){
        return "ALUNO";
    }
}
