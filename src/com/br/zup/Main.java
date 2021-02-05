package com.br.zup;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    private Scanner l;
    private boolean execute;
    private List<Dados> dados;

    public static void main(String[] args) {
        final Main main = new Main();
    }


    private Main() {
        l = new Scanner(System.in);
        execute = true;
        dados = new ArrayList<Dados>();

        System.out.println("BEM VINDO AO CADASTRO DE USUÁRIOS");

        while (execute) {
            String opcao = menu();

            if (opcao.equalsIgnoreCase("n")) {
                cadastrar();
            } else if (opcao.equalsIgnoreCase("l")) listarCadastros();
            else if (opcao.equalsIgnoreCase("x")) {
                execute = false;
            } else {
                System.out.println("\nOpção Inválida! \n");
            }
        }
    }

    private String menu() {
        System.out.println("Selecione a opção:");
        System.out.println("N - Novo cadastro");
        System.out.println("L - Listar cadastros");
        System.out.println("X - Sair");
        return l.nextLine();
    }

    private void cadastrar() {
        boolean cadastrando = true;

        while (cadastrando) {
            System.out.println("Cadastro de Usuário");
            Dados d = new Dados();
            d.setNome((String) textInput("Nome:"));
            d.setTelefone(intInput("Telefone: "));
            d.setEmail((String) textInput("Email: "));

            String cadastrar = (String) textInput("Adicionar cadastro (S/N) ?");
            if (cadastrar.equalsIgnoreCase("s")) {
                System.out.println("Cadastro adicionado!");
                dados.add(d);
            } else if (cadastrar.equalsIgnoreCase("n")){
                System.out.println("Cadastro ignorado!");
            } else {
                System.out.println("\nOpção inválida! \n");
            }

            String continua = (String) textInput("Continuar cadastrando (S/N) ?");
            if (continua.equalsIgnoreCase("N")) {
                cadastrando = false;
            } else if (continua.equalsIgnoreCase("s")){

            } else {
                System.out.println("\nOpção inválida! \n");
                cadastrando = false;
            }
        }
    }

    private int intInput(Object s) {
        return 0;
    }

    private void listarCadastros() {
        if (dados.size() == 0) {
            System.out.println("\nNão existem cadastros !!!\n");
        } else {
            System.out.println("\nLista de Cadastros\n");
            for (int i = 0; i < dados.size(); i++) {
                Dados d = dados.get(i);
                System.out.println("Cadastro número: " + i);
                System.out.printf("\tNome: %s%n", d.getNome());
                System.out.printf("\tLogin: %s%n", d.getTelefone());
                System.out.printf("\tCargo: %s\n%n", d.getEmail());
            }
            System.out.println("\nFim da lista\n");
        }
    }

    private Object textInput(String label) {
        System.out.println(label);
        return l.nextLine();
    }
}
