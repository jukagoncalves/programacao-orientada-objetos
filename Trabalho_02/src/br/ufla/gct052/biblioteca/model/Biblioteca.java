package br.ufla.gct052.biblioteca.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Biblioteca{
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Exemplar> exemplares = new ArrayList<>();

    public void cadastrarUsuario(Usuario u){
        if (u == null) {
            throw new IllegalArgumentException("Usuario nulo");
        }
        for(Usuario usuario:usuarios){
            if (u.getId().equals(usuario.getId())) {
                throw new IllegalArgumentException("Id ja existente!");
            }
        }
        usuarios.add(u);
    }

    public void cadastrarExemplar(Exemplar e){
        if (e == null) {
            throw new IllegalArgumentException("Exemplar nulo");
        }
        
        for(Exemplar exemplar:exemplares){
            if (e.getCodigo().equals(exemplar.getCodigo())) {
                throw new IllegalArgumentException("Exemplar ja cadastrado");
            }
        }
        exemplares.add(e);
    }

    public Usuario buscarUsuarioPorId(String id){
        for(Usuario usuario:usuarios){
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        throw new IllegalArgumentException("Usuario nao encontrado");
    }

    public Exemplar buscarExemplarPorCodigo(String codigo){
        for(Exemplar exemplar:exemplares){
            if (exemplar.getCodigo().equals(codigo)) {
                return exemplar;
            }
        }
        throw new IllegalArgumentException("Exemplar nao encontrado!");
    }

    public boolean emprestar(String idUsuario, String codExemplar){
        Usuario usr = buscarUsuarioPorId(idUsuario);
        Exemplar expl = buscarExemplarPorCodigo(codExemplar);

        if (usr.podeEmprestar() && expl.isDisponivel()) {
            expl.emprestar();
            usr.incrementarEmprestimos();
            return true;
        }
        return false;
    }

    public boolean devolver(String idUsuario, String codExemplar){
        Usuario usr = buscarUsuarioPorId(idUsuario);
        Exemplar expl = buscarExemplarPorCodigo(codExemplar);

        if (expl.isDisponivel()) {
            return false;
        } else {
            expl.devolver();
            usr.decrementarEmprestimos();
            return true;
        }
    }

    public List<Usuario> getUsuarios(){
        return Collections.unmodifiableList(usuarios);
    }

    public List<Exemplar> getExemplares(){
        return Collections.unmodifiableList(exemplares);
    }
}
