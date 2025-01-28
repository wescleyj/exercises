import java.util.Scanner;

public class Impar {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in); // Criando o objeto Scanner
        int i = scanner.nextInt(); // Lendo um número inteiro

        if (i % 2 == 0) {
            System.out.println("Par");
        } else {
            System.out.println("Impar");
        }

        scanner.close(); // Fechando o objeto Scanner
    }
}
