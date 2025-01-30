import java.util.Scanner;
import java.util.Locale;
import java.text.DecimalFormat;

public class App009 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        DecimalFormat casas = new DecimalFormat();
        casas.applyPattern("0.00");
        float area, base, altura;

        System.out.print("Qual a altura do triangulo? ");
        altura = scanner.nextFloat();

        System.out.print("Qual a medida da base do triangulo? ");
        base = scanner.nextFloat();

        area = (base * altura)/2;

        System.out.println("A area do traingulo é: " + casas.format(area));

        scanner.close();
    }
}
