package com.programandoascegas.agenda.service;

import com.programandoascegas.agenda.model.Contato;

import java.util.ArrayList;
import java.util.List;

public class Agenda {

    private final List<Contato> contatos;

    public List<Contato> getContatos() {
        return contatos;
    }

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void cria(String nome, String telefone) {
        var contato = new Contato(nome, telefone);
        contatos.add(contato);
    }

    public boolean atualiza(int posicao, String nome, String telefone) {
        if (posicao >= contatos.size() || posicao < 0) {
            return false;
        }
        contatos.get(posicao).setNome(nome);
        contatos.get(posicao).setTelefone(telefone);
        return true;
    }

    public boolean exclui(int posicao) {
        if (posicao >= contatos.size() || posicao < 0) {
            return false;
        }
        contatos.remove(posicao);
        return true;
    }


}