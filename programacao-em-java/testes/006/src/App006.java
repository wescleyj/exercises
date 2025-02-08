import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class App006 {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        DecimalFormat casas = new DecimalFormat("0.00");

        final int gratificacao = 5;
        final int imposto = 7;

        float salario, salarioFinal;

        System.out.println("Digite o salário: ");
        salario = scanner.nextFloat();

        salarioFinal = salario + (salario * gratificacao / 100) - (salario * imposto / 100);

        System.out.println("Salário final: " + casas.format(salarioFinal));

        scanner.close();
    }
}
