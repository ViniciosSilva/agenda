package com.programandoascegas.agenda.view;

import com.programandoascegas.agenda.model.Contato;
import com.programandoascegas.agenda.service.Agenda;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public void menu() {
        Scanner teclado = new Scanner(System.in);
        String nome;
        String telefone;
        int posicao;
        int opcao = 0;
        Agenda agenda = new Agenda();
        while (opcao != 5) {

            System.out.println("Digite o número da opção correspondente");
            System.out.println("1 - Criar contato, \n 2 - Listar todos os contatos, \n 3 - Editar um contato, \n 4 - Excluir um contato, \n 5 - Sair,");
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Nome do contato que você quer adicionar:");
                    nome = teclado.next();
                    System.out.println("Número de telefoe do contato:");
                    telefone = teclado.next();
                    agenda.cria(nome, telefone);
                    System.out.println("Contato criado com sucesso!");
                    break;
                case 2:
                    listaContatos(agenda.getContatos());
                    break;
                case 3:
                    System.out.println("Atualizar contato");
                    listaContatos(agenda.getContatos());
                    System.out.println("Digite a posição referente ao contato a atualizar:");
                    posicao = teclado.nextInt();
                    System.out.println("Digite o novo nome do contato:");
                    nome = teclado.next();
                    System.out.println("Digite o novo telefone  do contato");
                    telefone = teclado.next();
                    agenda.atualiza(posicao, nome, telefone);
                    if (agenda.atualiza(posicao, nome, telefone)) {
                        System.out.println("Contato atualizado com sucesso!");
                    } else {
                        System.out.println("Posição inválida, erro ao atualizar o contato");
                    }
                    break;
                case 4:
                    System.out.println("Excluir  contato");
                    listaContatos(agenda.getContatos());
                    System.out.println("Digite a posição referente ao contato a excluir:");
                    posicao = teclado.nextInt();
                    agenda.exclui(posicao);
                    if (agenda.exclui(posicao)) {
                        System.out.println("Contato excluído  com sucesso!");
                    } else {
                        System.out.println("Posição inválida, erro ao excluir  o contato");
                    }
                    break;
                case 5:
                    System.out.println("Fim da agenda");
                    break;
                default:
                    System.out.println("Posiçãoinválida");
                    break;
            }
        }
    }

    private void listaContatos(List<Contato> contatos) {
        for (int i = 0; i < contatos.size(); i++) {
            System.out.printf("%d - %s - %s%n", i, contatos.get(i).getNome(), contatos.get(i).getTelefone());
        }
    }


}