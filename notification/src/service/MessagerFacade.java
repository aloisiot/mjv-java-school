package service;

public class MessagerFacade implements IMesseger{
    private String destine;
    private MessagerType messagerType;
    private IMesseger messeger;

    public MessagerFacade(String destine, MessagerType messagerType) {
        this.destine = destine;

        if(messagerType == MessagerType.SMS) {
            this.messeger = new SmsMessager(destine);
        } else {
            this.messeger = new WhatsAppMessager(destine);
        }
    }

    @Override
    public void send(String message) {
        this.messeger.send(message);
    }

    public String getDestine() {
        return destine;
    }

    public void setDestine(String destine) {
        this.destine = destine;
    }

    public MessagerType getMessegerType() {
        return messagerType;
    }

    public void setMessegerType(MessagerType messagerType) {
        this.messagerType = messagerType;

        if(messagerType == MessagerType.SMS) {
            this.messeger = new SmsMessager(destine);
        } else {
            this.messeger = new WhatsAppMessager(destine);
        }
    }
}
