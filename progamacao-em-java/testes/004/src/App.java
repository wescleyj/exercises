import java.util.Scanner;
import java.util.Locale;
import java.text.DecimalFormat;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        DecimalFormat casas = new DecimalFormat();
        casas.applyPattern("0.00");
        float a, newa;

        System.out.print("Qual o seu salário? ");
        a = scanner.nextFloat();

        newa = (a * 125)/100;

        System.out.println("Seu novo salário é: " + casas.format(newa));

        scanner.close();
    }
}
