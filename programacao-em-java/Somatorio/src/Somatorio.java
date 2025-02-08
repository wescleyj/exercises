import java.util.Scanner;

public class Somatorio {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n, soma = 0;

        do {
            n = scanner.nextInt();
            
            if (n == 0) {
                scanner.close();
                System.out.println("Soma: 0");
                return;
            }
            else if (n < 0) {
                System.out.println("Digite um número positivo.");
                
            }

        } while (n < 0);

        scanner.close();

        for (int i = 1; i <= n; i++) {
            soma += i;
        }

        System.out.print("Soma: ");
        System.out.println(soma);
    }
}
