package model;

public enum TipoServico {
    AGUA("Água"),
    LUZ("Luz");
    private String value;

    private TipoServico(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
