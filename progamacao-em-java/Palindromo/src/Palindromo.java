import java.util.Scanner;

public class Palindromo {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String frase = scanner.nextLine();

        if (isPalindromo(frase)) {
            System.out.println("É palíndromo");
        } else {
            System.out.println("Não é palíndromo");
        }

        scanner.close();
    }

    public static boolean isPalindromo(String frase) {
        String fraseSemEspacos = frase.replace(" ", "");
        String fraseInvertida = new StringBuilder(fraseSemEspacos).reverse().toString();

        return fraseSemEspacos.equalsIgnoreCase(fraseInvertida);
    }
}
