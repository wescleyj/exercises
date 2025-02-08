import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class App008 {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        DecimalFormat casas = new DecimalFormat("#.00");

        int deposito;
        double taxa, rendimento;

        System.out.print("Digite o valor do depósito: ");
        deposito = scanner.nextInt();

        System.out.print("Digite a taxa de juros: ");
        taxa = scanner.nextDouble();

        rendimento = deposito * (taxa / 100);

        System.out.println("O rendimento é de: " + casas.format(rendimento));
        System.out.println("O valor total é de: " + casas.format(deposito + rendimento));

        scanner.close();
    }
}
