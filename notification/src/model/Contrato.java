package model;

public class Contrato {
    private long protocolo;
    private Cadastro cadastro;

    public Contrato(long protocolo, Cadastro cadastro) {
        this.protocolo = protocolo;
        this.cadastro = cadastro;
    }

    public long getProtocolo() {
        return protocolo;
    }

    public Cadastro getCadastro() {
        return cadastro;
    }
}
