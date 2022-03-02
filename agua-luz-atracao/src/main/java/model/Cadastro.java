package model;

import java.time.LocalDateTime;

public class Cadastro {
    private int numero;
    private boolean ativo;
    private Pessoa pessoa;
    private TipoMenssageiro tipoMenssageiro;
    private LocalDateTime dataCadastro;

    public Cadastro() {
    }

    public Cadastro(int numero, boolean ativo, Pessoa pessoa, TipoMenssageiro tipoMenssageiro, LocalDateTime dataCadastro) {
        this.numero = numero;
        this.ativo = ativo;
        this.pessoa = pessoa;
        this.tipoMenssageiro = tipoMenssageiro;
        this.dataCadastro = dataCadastro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public TipoMenssageiro getTipoMenssageiro() {
        return tipoMenssageiro;
    }

    public void setTipoMenssageiro(TipoMenssageiro tipoMenssageiro) {
        this.tipoMenssageiro = tipoMenssageiro;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
