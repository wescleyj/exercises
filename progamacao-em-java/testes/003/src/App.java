import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Locale;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        DecimalFormat casas = new DecimalFormat();
        casas.applyPattern("0.00");
        float a, pa, b, pb, c, pc, media;


        System.out.print("Digite a nota A: ");
        a = scanner.nextFloat();
        System.out.print("Digite o peso da nota A: ");
        pa = scanner.nextFloat();
        System.out.print("Digite a nota B: ");
        b = scanner.nextFloat();
        System.out.print("Digite o peso da nota B: ");
        pb = scanner.nextFloat();
        System.out.print("Digite a nota C: ");
        c = scanner.nextFloat();
        System.out.print("Digite o peso da nota C: ");
        pc = scanner.nextFloat();

        media = (a * pa + b * pb + c * pc) / (pa + pb + pc);

        System.out.println("Média ponderada: " + casas.format(media));

        scanner.close();
    }
}
