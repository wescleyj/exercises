import java.util.ArrayList;
import java.util.List;

public class BolsaNinja<T> {
    // Inicializar o array

    private List<T> ferramentas;

    public BolsaNinja() {
        this.ferramentas = new ArrayList<>();
    }

    // Colocar ferramentas
    public void adicionarFerramenta(T ferramenta) {
        ferramentas.add(ferramenta);
    }

    // Mostrar ferramentas
    public void mostrarFerramentas() {
        for (T ferramenta : ferramentas) {
            System.out.println(ferramenta);
        }
    }
}
