public class Kunai {
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public Kunai(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
