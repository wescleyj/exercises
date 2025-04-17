public class Carta {
    private String naipe;
    private int valor;

    public Carta(String naipe, int valor) {
        this.naipe = naipe;
        this.valor = valor;
    }

    public Carta() {
        naipe = "";
        valor = 0;
    }

    public Carta(Carta carta) {
        this.naipe = carta.naipe;
        this.valor = carta.valor;
    }

    public int comparaValor(Carta carta) {
        return Integer.compare(this.valor, carta.valor);
    }

    public int comparaNaipe(Carta carta) {
        if (this.naipe.equals(carta.naipe)) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
