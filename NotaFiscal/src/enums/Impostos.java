package enums;

public enum Impostos {

    IMPOSTOSOBREVENDA(10),
    IMPOSTODEIMPORATACAO(5);

    private final double valor;

    public double getValor() {
        return valor;
    }

    Impostos(double value) {
        this.valor = value;
    }
}
