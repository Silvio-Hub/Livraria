package biblioteca;

import model.Cliente;
import model.Emprestimo;
import model.Livro;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;
    private List<Cliente> clientes;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        livros = new ArrayList<>();
        clientes = new ArrayList<>();
        emprestimos = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void listarLivrosDisponiveis() {
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println(livro);
            }
        }
    }

    public Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id && livro.isDisponivel()) {
                return livro;
            }
        }
        return null;
    }

    public void realizarEmprestimo(Livro livro, Cliente cliente) {
        if (livro != null && livro.isDisponivel()) {
            livro.emprestar();
            emprestimos.add(new Emprestimo(livro, cliente));
            System.out.println("O livro \"" + livro.getTitulo() + "\" foi emprestado com sucesso para " + cliente.getNome());
        } else {
            System.out.println("Livro não disponível para empréstimo.");
        }
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
