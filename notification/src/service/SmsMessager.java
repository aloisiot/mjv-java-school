package service;

public class SmsMessager implements IMesseger{
    private String destine;

    public SmsMessager(String numTelefone) {
        this.destine = numTelefone;
    }

    public void send(String mensagen) {
        System.out.printf("Transmitindo via SMS\nDestinatário: %s\n", this.destine);
        System.out.println(mensagen + "\n");
    }
}
