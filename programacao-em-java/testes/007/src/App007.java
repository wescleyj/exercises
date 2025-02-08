import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class App007 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        DecimalFormat casas = new DecimalFormat("0.00");

        final int gratificacao = 50;
        final int imposto = 10;

        float salario, salarioFinal;

        System.out.print("Digite o salário do funcionário: ");
        salario = scanner.nextFloat();

        salarioFinal = salario + gratificacao - (salario * imposto)/100;

        System.out.println("Salário final: R$ " + casas.format(salarioFinal));

        scanner.close();
    }
}
