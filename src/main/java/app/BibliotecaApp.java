package app;

import biblioteca.Biblioteca;
import model.Autor;
import model.Cliente;
import model.Livro;

import java.util.Date;
import java.util.Scanner;

public class BibliotecaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Autor autor1 = new Autor(1, "J.K. Rowling", new Date());
        Autor autor2 = new Autor(2, "George Orwell", new Date());

        Livro livro1 = new Livro(1, "Harry Potter e a Pedra Filosofal", autor1);
        Livro livro2 = new Livro(2, "1984", autor2);

        Cliente cliente1 = new Cliente(1, "Maria", "maria@gmail.com");
        Cliente cliente2 = new Cliente(2, "João", "joao@gmail.com");

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionarLivro(livro1);
        biblioteca.adicionarLivro(livro2);
        biblioteca.cadastrarCliente(cliente1);
        biblioteca.cadastrarCliente(cliente2);

        boolean continuar = true;
        while (continuar) {
            System.out.println("\nBem-vindo à Biblioteca!");
            System.out.println("1. Ver livros disponíveis");
            System.out.println("2. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.println("\nLivros disponíveis:");
                biblioteca.listarLivrosDisponiveis();
                System.out.print("\nEscolha o ID do livro para emprestar: ");
                int livroId = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Informe seu nome: ");
                String nomeCliente = scanner.nextLine();
                Cliente clienteSelecionado = null;
                for (Cliente c : biblioteca.getClientes()) {
                    if (c.getNome().equalsIgnoreCase(nomeCliente)) {
                        clienteSelecionado = c;
                        break;
                    }
                }

                Livro livroEmprestado = biblioteca.buscarLivroPorId(livroId);
                if (livroEmprestado != null && clienteSelecionado != null) {
                    biblioteca.realizarEmprestimo(livroEmprestado, clienteSelecionado);
                } else {
                    System.out.println("Livro não encontrado ou cliente inválido.");
                }
            } else if (opcao == 2) {
                System.out.println("Fim da aplicação.");
                continuar = false;
            } else {
                System.out.println("Opção inválida, tente novamente.");
            }
        }

        scanner.close();
    }
}
