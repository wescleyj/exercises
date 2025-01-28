public class Pergaminho {
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public Pergaminho(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pergaminho de " + tipo;
    }
}
