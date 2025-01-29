import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), a = 0, b = 1, c;

        for (int i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;

            System.out.print(a + " ");
        }

        scanner.close();
    }
}
