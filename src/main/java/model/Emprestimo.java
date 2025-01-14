package model;

import java.util.Date;

public class Emprestimo {
    private Livro livro;
    private Cliente cliente;
    private Date dataEmprestimo;

    public Emprestimo(Livro livro, Cliente cliente) {
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = new Date();
    }

    @Override
    public String toString() {
        return "Livro: " + livro.getTitulo() + ", Cliente: " + cliente.getNome() + ", Data de Empréstimo: " + dataEmprestimo;
    }
}
