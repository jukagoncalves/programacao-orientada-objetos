package br.ufla.gct052.biblioteca.model;

public class Exemplar {
    private final String codigo;
    private String titulo;
    private boolean disponivel = true;

    public Exemplar(String codigo, String titulo){
        if (codigo != null && !codigo.isBlank() && titulo != null && !titulo.isBlank()) {
            this.codigo = codigo;
            this.titulo = titulo;
        } else {
            throw new IllegalArgumentException("Argumento inválido");
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar(){
        if (!disponivel) {
            throw new IllegalStateException();
        }
        this.disponivel = false;
    }

    public void devolver(){
        this.disponivel = true;
    }

    @Override
    public String toString() {
        return "Codigo: " + this.getCodigo() + "\nTitulo: " + getTitulo() + 
        "\nDisponivel: " + this.isDisponivel();
    }
}
