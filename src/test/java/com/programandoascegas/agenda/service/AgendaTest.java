package com.programandoascegas.agenda.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    private Agenda agenda;

    @BeforeEach
    void setup() {
        this.agenda = new Agenda();
    }

    @Test
    @DisplayName("Testar a adição de um contato na lista")
    void adicionar() {
        String nome = "Vinícios";
        String telefone = "11985103026";
        agenda.cria(nome, telefone);
        assertEquals(1, agenda.getContatos().size());
        assertEquals(nome, agenda.getContatos().get(0).getNome());
        assertEquals(telefone, agenda.getContatos().get(0).getTelefone());
    }

    @Test
    @DisplayName("Testando a exclusãodo contato")
    void excluir() {
        String nome = "Vinícios";
        String telefone = "11985103026";
        agenda.cria(nome, telefone);
        assertEquals(1, agenda.getContatos().size());
        assertTrue(agenda.exclui(0));
assertEquals(0, agenda.getContatos().size());
    }
    @Test
@DisplayName("Testando a exclusão de um contato passando uma posição inválida")
    void excluirPosicaoInvalida(){
        String nome = "Vinícios";
        String telefone = "11985103026";
        agenda.cria(nome, telefone);
        assertEquals(1, agenda.getContatos().size());
assertFalse(agenda.exclui(2));
assertEquals(1, agenda.getContatos().size());
    }

}