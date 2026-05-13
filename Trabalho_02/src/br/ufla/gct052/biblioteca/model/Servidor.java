package br.ufla.gct052.biblioteca.model;

public class Servidor extends Usuario{
    private String setor;
    private String cargo;

    public Servidor(String id, String nome, String setor, String cargo){
        super(id, nome);
        if (setor != null && !setor.isBlank() && cargo != null && !cargo.isBlank()) {
            this.setor = setor;
            this.cargo = cargo;
        } else {
            throw new IllegalArgumentException("Argumento inválido");
        }
    }

    public String getSetor() {
        return setor;
    }

    public String getCargo() {
        return cargo;
    }

    @Override
    public int getLimiteEmprestimos() {
        return 4;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSetor: " + this.getSetor()
        + "\nCargo: " + this.getCargo();
    }   
    
    @Override
    public String tipo(){
        return "SERVIDOR";
    }
}
