import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        float a, b, media;

        System.out.print("Digite a primeira nota: ");
        a = scanner.nextFloat();
        System.out.print("Digite a segunda nota: ");
        b = scanner.nextFloat();

        media = (a + b) / 2;

        System.out.println("A média é: " + media);

        scanner.close();
    }
}
