package model;

import util.FormatadorDeTexto;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Contrato {
    private long protocolo;
    private TipoServico tipoServico;
    private Cadastro cadastro;
    private final double valorAgua = 137.21;
    private final double valorLuz = 132.15;
    private LocalDateTime dataHora;

    public Contrato() {
    }

    public Contrato(long protocolo, Cadastro cadastro, TipoServico tipoServico) {
        this.protocolo = protocolo;
        this.cadastro = cadastro;
        this.tipoServico = tipoServico;
    }

    public String getContrato(String datePattern, String timePattern, Locale locale) {

        return String.format(
                "%s\n" +
                "Senhor(a) %s CPF de número %s, Informamos que conforme contrato com protocolo de número %d está agendado para a data %s às %s a instalação da %s com taxa de valor R$ %s em sua residência localizada no endereço abaixo:\n" +
                "- Logradouro: %s, %s\n" +
                "- Bairro: %s\n" +
                "- Cidade: %s\n" +
                "- Cep: %s",
                getCadastro().getTipoMenssageiro(),
                this.getCadastro().getPessoa().getNome(),
                FormatadorDeTexto.formatarCpf(this.getCadastro().getPessoa().getCpf()),
                this.getProtocolo(),
                DateTimeFormatter.ofPattern(datePattern).format(this.getCadastro().getDataCadastro().toLocalDate()),
                DateTimeFormatter.ofPattern(timePattern).format(this.getCadastro().getDataCadastro().toLocalTime()),
                this.tipoServico.getValue(),
                DecimalFormat.getCurrencyInstance(locale).format(this.tipoServico == TipoServico.AGUA ? this.valorAgua : this.valorLuz),
                this.cadastro.getPessoa().getEndereco().getLogradouro(),
                this.cadastro.getPessoa().getEndereco().getNumero(),
                this.cadastro.getPessoa().getEndereco().getBairro(),
                this.cadastro.getPessoa().getEndereco().getCidade(),
                FormatadorDeTexto.formatarCep(this.cadastro.getPessoa().getEndereco().getCep())
        );
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public long getProtocolo() {
        return protocolo;
    }

    public Cadastro getCadastro() {
        return cadastro;
    }

    public void setProtocolo(long protocolo) {
        this.protocolo = protocolo;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    public double getValorAgua() {
        return valorAgua;
    }

    public double getValorLuz() {
        return valorLuz;
    }
}
