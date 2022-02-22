package service;

public class TransmissorWhatsApp extends TransmissorMensagem {
    @Override
    public void transmitir(String mensagen) {
        System.out.println("Transmitindo via WHATSAPP");
        System.out.println(mensagen);
    }
}
