package service;

import model.Contrato;

public abstract class TransmissorMensagem {
    public static String gerarNotificacao(Contrato contrato){
        return String.format(
                "Senhor(a) %s informamos que confogme contrato com protocolo %s",
                contrato.getCadastro().getPessoa().getNome(),
                contrato.getProtocolo()
        );
    }

    public abstract void transmitir(String mensagen);
}
