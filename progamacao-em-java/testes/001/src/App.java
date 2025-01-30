import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int a, b, c, d, soma;

        System.out.print("Digite o valor de A: ");
        a = scanner.nextInt();
        System.out.print("Digite o valor de B: ");
        b = scanner.nextInt();
        System.out.print("Digite o valor de C: ");
        c = scanner.nextInt();
        System.out.print("Digite o valor de D: ");
        d = scanner.nextInt();

        soma = a + b + c + d;

        System.out.println("A soma dos valores é: " + soma);

        scanner.close();
    }
}
