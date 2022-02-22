package service;

public class TranmissorSms extends TransmissorMensagem{
    @Override
    public void transmitir(String mensagen) {
        System.out.println("Transmitindo via SMS");
        System.out.println(mensagen);
    }
}
