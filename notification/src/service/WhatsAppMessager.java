package service;

public class WhatsAppMessager implements IMesseger {
    private String destine;

    public WhatsAppMessager(String numTelefone) {
        this.destine = numTelefone;
    }

    public void send(String mensagen) {
        System.out.printf("Transmitindo via WHATSAPP\nDestinatário: %s\n", this.destine);
        System.out.println(mensagen + "\n");
    }
}
