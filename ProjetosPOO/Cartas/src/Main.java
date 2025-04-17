public class Main {
    public static void main(String[] args) {
    Carta carta1 = new Carta("Copa", 5);
    Carta carta2 = new Carta("Ouro", 5);
    Carta carta3 = new Carta("Espada", 8);
    Carta carta4 = new Carta("Espada", 4);

    comparaNaipe(carta3, carta4);
    comparaNaipe(carta1, carta2);
    comparaValor(carta1, carta2);
    comparaValor(carta1, carta3);
    comparaValor(carta1, carta4);


    }

    public static void comparaNaipe(Carta carta, Carta carta2) {
        if (carta.comparaNaipe(carta2) == 1) {
            System.out.println("As cartas tem o mesmo naipe");
        }
        else {
            System.out.println("As cartas tem naipe diferente naipe");
        }
    }

    public static void comparaValor(Carta carta, Carta carta2) {
        if (carta.comparaValor(carta2) > 0) {
            System.out.println("A carta 1 é maior que a carta 2");
        } else if (carta.comparaValor(carta2) < 0) {
            System.out.println("A carta 1 é menor que a carta 2");
        }
        else {
            System.out.println("A carta 1 tem o mesmo valor que a carta 2");
        }
    }
}