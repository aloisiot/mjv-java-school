import model.*;
import output.GeradorDeArquivos;
import repository.ContratoRepository;
import model.TipoMenssageiro;

import java.time.LocalDateTime;
import java.util.List;

public class AguaLuzAtracaoApp {

    private static ContratoRepository contratoRepositorio = new ContratoRepository();

    public static void main(String[] args) {
        faseAtracao();
        faseGeracaoArquivo();
    }
    private static void faseGeracaoArquivo() {
        List<Contrato> contratos =  contratoRepositorio.listarTodos();
        GeradorDeArquivos gerador = new GeradorDeArquivos();
        gerador.gerarArquivoCsv(contratos);
        gerador.gerarArquivoTxt(contratos);
        gerador.gerarArquivosContratos(contratos);
    }
    private static void faseAtracao() {
        Contrato contrato1 = new Contrato();
        contrato1.setProtocolo(123);
        contrato1.setTipoServico(TipoServico.LUZ);

        Pessoa pessoa = new Pessoa();
        pessoa.setCpf("56737284094");
        pessoa.setNome("Marcia Santos de Oliveira");
        pessoa.setRg("89789");
        pessoa.setPais(Pais.BRASIL);
        pessoa.setTelefone("98965498760");

        Endereco endereco = new Endereco();
        endereco.setBairro("Santo Antonio");
        endereco.setCep("27310657");
        endereco.setCidade("São Paulo");
        endereco.setEstado("SP");
        endereco.setLogradouro("Rua das Cajazeiras 26");
        endereco.setNumero("243");
        pessoa.setEndereco(endereco);

        Cadastro cadastro = new Cadastro();
        cadastro.setNumero(2);
        cadastro.setAtivo(true);
        cadastro.setPessoa(pessoa);
        cadastro.setTipoMenssageiro(TipoMenssageiro.WHATSAPP);
        cadastro.setDataCadastro(LocalDateTime.now());

        contrato1.setCadastro(cadastro);
        contrato1.setDataHora(LocalDateTime.now());
        contratoRepositorio.gravar(contrato1);

        // Contrato 2
        Contrato contrato2 = new Contrato();
        contrato2.setProtocolo(78678);
        contrato2.setTipoServico(TipoServico.AGUA);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setCpf("11094986089");
        pessoa2.setNome("Raimundo Nonato Loureiro Castelo Branco");
        pessoa2.setRg("98908");
        pessoa2.setPais(Pais.ESTADOS_UNIDOS);
        pessoa2.setTelefone("11976349678");

        Endereco endereco2 = new Endereco();
        endereco2.setBairro("Santo Antonio");
        endereco2.setCep("27310657");
        endereco2.setCidade("São Paulo");
        endereco2.setEstado("SP");
        endereco2.setLogradouro("Rua das Marias");
        endereco2.setNumero("243");
        pessoa2.setEndereco(endereco2);

        Cadastro cadastro2 = new Cadastro();
        cadastro2.setNumero(1);
        cadastro2.setAtivo(true);
        cadastro2.setPessoa(pessoa2);
        cadastro2.setTipoMenssageiro(TipoMenssageiro.SMS);
        cadastro2.setDataCadastro(LocalDateTime.now());

        contrato2.setCadastro(cadastro2);
        contrato2.setDataHora(LocalDateTime.now());
        contratoRepositorio.gravar(contrato2);
    }
}
