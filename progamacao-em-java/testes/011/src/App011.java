import java.util.Scanner;
import java.util.Locale;
import java.text.DecimalFormat;

public class App011 {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("0.00");

        int code[] = new int[10];
        int quantity[] = new int[10];
        int codeC, produto, qtd;
        Boolean flag = false;

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter the code and quantity of the product " + (i + 1) + ": ");
            code[i] = scanner.nextInt();
            quantity[i] = scanner.nextInt();
        }

        while (true) {
            System.out.print("Qual o codigo do cliente?(0 para sair) ");
            codeC = scanner.nextInt();

            if (codeC == 0) {
                break;
            }

            System.out.print("Qual o codigo do produto? ");

            do {
                produto = scanner.nextInt();

                for (int i = 0; i < 10; i++) {
                    if (code[i] == produto) {
                        flag = true;
                        break;
                    } else {
                        flag = false;
                    }

                    if (i == 9 && !flag) {
                        System.out.println("Produto nao cadastrado, tente novamente.");
                    }
                }
            } while (!flag);

            System.out.print("Qual a quantidade? ");

            do {
                qtd = scanner.nextInt();

                if (qtd <= 0) {
                    System.out.println("Quantidade invalida, tente novamente.");
                    flag = false;
                } else {
                    flag = true;
                }

                if (flag) {
                    if (quantity[produto - 1] < qtd) {
                        System.out.println("Não temos estoque suficiente dessa mercadoria.");
                        flag = false;
                        break;
                    } else {
                        quantity[produto - 1] -= qtd;
                        System.out.println("Pedido atendido. Obrigado e volte sempre");
                        flag = true;
                    }

                }
            } while (!flag);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Produto " + (i + 1) + ": " + code[i] + " - " + quantity[i] + " unidades");
        }

        scanner.close();
    }
}
