package enums;

public enum Precisao {

    BASICA(1),
    DUPLA(2),
    TRIPLA(3);

    private final int valor;

    Precisao(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
