import model.*;
import service.TranmissorSms;
import service.TransmissorMensagem;
import service.TransmissorWhatsApp;

public class NotificationApp {
    public static void main(String[] args) {
        Endereco endereco = new Endereco(
            "Rua das flores",
            "342",
            "2342343242",
            "centro",
            "Belo Horizonte",
            "MG"
        );

        Pessoa pessoa = new Pessoa(
            "Joao",
            "23454623403",
            "423534509",
            "3243265768543",
            endereco
        );

        Cadastro cadastro = new Cadastro(
            1,
            true,
            pessoa, TipoNotificacao.WHATSAPP
        );

        Contrato contrato = new Contrato(112, cadastro);

        String notificacao = TransmissorMensagem.gerarNotificacao(contrato);

        TransmissorMensagem transmissorMensagem = new TransmissorWhatsApp();
        transmissorMensagem.transmitir(notificacao);

        transmissorMensagem = new TranmissorSms();
        transmissorMensagem.transmitir(notificacao);
    }
}
