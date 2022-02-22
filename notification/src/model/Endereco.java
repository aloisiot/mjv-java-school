package model;

public class Endereco {
    private String logradouro;
    private String numbero;
    private String cep;
    private String bairro;
    private String cidade;
    private String estados;

    public Endereco(String logradouro, String numbero, String cep, String bairro, String cidade, String estados) {
        this.logradouro = logradouro;
        this.numbero = numbero;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estados = estados;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumbero() {
        return numbero;
    }

    public String getCep() {
        return cep;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstados() {
        return estados;
    }
}
