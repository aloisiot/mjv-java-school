package model;

public class Pessoa {
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private Endereco endereco;

    public Pessoa(String nome, String cpf, String rg, String telefone, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
