package model;

public class Pessoa {
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private Endereco endereco;
    private Pais pais;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String rg, String telefone, Endereco endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(Endereco endereco) {
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
