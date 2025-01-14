package model;

import java.util.Date;

public class Autor {
    private int id;
    private String nome;
    private Date dataNascimento;

    public Autor(int id, String nome, Date dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }
}
