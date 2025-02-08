import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String form = String.format("%2d", n);

        for (int i = 1; i <= 10; i++) {
            String formatado = String.format("%2d", i);
            System.out.println(form + " x " + formatado + " = " + (i * n));
        }

        scanner.close();
    }
}
