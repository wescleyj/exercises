import java.util.Locale;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.lang.Math;

public class App010 {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        DecimalFormat casas = new DecimalFormat();
        casas.applyPattern("0.00");

        final double pi = 3.1415;

        double area, raio;

        System.out.print("Qual o raio da circuferencia? ");
        raio = scanner.nextDouble();

        area = pi * Math.pow(raio, 2);

        System.out.println("A area da esfera é aproximadamente: " + casas.format(area));

        scanner.close();
    }
}
