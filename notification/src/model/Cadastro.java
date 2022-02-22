package model;

public class Cadastro {
    private int numero;
    private boolean ativo;
    private Pessoa pessoa;
    private TipoNotificacao tipoNotificacao;

    public Cadastro(int numero, boolean ativo, Pessoa pessoa, TipoNotificacao tipoNotificacao) {
        this.numero = numero;
        this.ativo = ativo;
        this.pessoa = pessoa;
        this.tipoNotificacao = tipoNotificacao;
    }

    public TipoNotificacao getTipoNotificacao() {
        return tipoNotificacao;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }
}
