public class Shuriken {
    private int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public Shuriken(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return  quantidade + " Shurikens";
    }
}
