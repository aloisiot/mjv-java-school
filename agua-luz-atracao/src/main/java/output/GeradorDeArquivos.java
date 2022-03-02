package output;

import model.Contrato;
import model.Endereco;
import model.Pessoa;
import model.TipoServico;
import util.FormatadorDeTexto;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class GeradorDeArquivos {

    private final String outputPath = "/media/aloisiot/HD1/MJV/mjv-java-school/output-agua-luz-atracao/";

    public void gerarArquivoCsv(List<Contrato> contratos) {
        File outputDir = new File(outputPath);
        String conteudo = formatarConteudo(contratos, TipoTemplate.CSV);
        gerarArquivo(outputDir ,conteudo, "agua-luz-contratos", "csv");
    }

    public void gerarArquivoTxt(List<Contrato> contratos) {
        File outputDir = new File(outputPath);
        String conteudo = formatarConteudo(contratos, TipoTemplate.POSICIONAL);
        gerarArquivo(outputDir, conteudo, "agua-luz-contratos", "txt");
    }

    public void gerarArquivosContratos(List<Contrato> contratos) {
        File outputDir = new File(outputPath + "contratos/");
        for (Contrato contrato : contratos) {
            String conteudo = contrato.getContrato("dd/MM/yyyy", "HH:mm", Locale.getDefault());
            String nomeArquivo = "contrato-" + (new DecimalFormat("0000000000").format(contrato.getProtocolo()));
            gerarArquivo(outputDir, conteudo, nomeArquivo, "txt");
        }
    }

    private void gerarArquivo(File output,String conteudo, String nomeArquivo, String ext) {
        if (!output.exists()) {
            output.mkdirs();
        }

        Path path = Paths.get(String.format("%s/%s.%s", output.getPath(), nomeArquivo, ext));

        try {
            System.out.println(conteudo);
            Files.write(path, conteudo.toString().getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String formatarConteudo(List<Contrato> contratos, TipoTemplate template) {
        StringBuilder conteudo = new StringBuilder();

        for (Contrato ct : contratos) {
            Pessoa pessoa = ct.getCadastro().getPessoa();
            Endereco endereco = pessoa.getEndereco();
            double valorServico = ct.getTipoServico() == TipoServico.AGUA ? ct.getValorAgua() : ct.getValorLuz();

            conteudo.append(String.format( template.getValor() + "\n",
                    pessoa.getCpf(),
                    FormatadorDeTexto.ajustar(pessoa.getNome(), 30).toUpperCase(Locale.ROOT),
                    pessoa.getRg(),
                    pessoa.getPais().getSigla(),
                    pessoa.getTelefone(),
                    FormatadorDeTexto.ajustar(endereco.getCidade(), 20).toUpperCase(Locale.ROOT),
                    endereco.getCep(),
                    FormatadorDeTexto.ajustar(endereco.getLogradouro(), 30).toUpperCase(Locale.ROOT),
                    FormatadorDeTexto.ajustar(endereco.getNumero(), 5),
                    FormatadorDeTexto.ajustar(endereco.getBairro(), 20).toUpperCase(Locale.ROOT),
                    FormatadorDeTexto.ajustar(endereco.getEstado(), 2).toUpperCase(Locale.ROOT),
                    new DecimalFormat("0000000000").format(ct.getProtocolo()),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(ct.getDataHora()),
                    FormatadorDeTexto.ajustar(ct.getTipoServico().getValue(), 4).toUpperCase(Locale.ROOT),
                    new DecimalFormat("0000.00").format(valorServico)
            ));
        }
        return conteudo.toString();
    }

    private enum TipoTemplate {
        CSV("%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s;%s"),
        POSICIONAL("%s%s%s%s%s%s%s%s%s%s%s%s%s%s%s");

        private String valor;

        TipoTemplate(String valor) {
            this.valor = valor;
        }

        public  String getValor(){
            return this.valor;
        }
    }
}
