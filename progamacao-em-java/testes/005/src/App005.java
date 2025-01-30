import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class App005 {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        DecimalFormat casas = new DecimalFormat();
        casas.applyPattern("0.00");
        float a, newa, aumento;
        int percentual;

        System.out.print("Qual o seu salário? ");
        a = scanner.nextFloat();

        System.out.print("Qual o percentual de aumento e? ");
        percentual = scanner.nextInt();

        aumento = (a * percentual)/100;

        newa = a + aumento;

        System.out.println("Seu novo salário é: " + casas.format(newa));
        System.out.println("O aumento foi de: " + casas.format(aumento));

        scanner.close();
    }
}
