import java.util.Scanner;
import java.util.Locale;
import java.text.DecimalFormat;

public class App012 {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("0.00");

        float precos[] = new float[10];
        int armazen[][] = new int[5][10];

        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o preço do produto " + (i + 1) + ": ");
            precos[i] = input.nextFloat();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print("Digite a quantidade do produto " + (j + 1) + " no armazém " + (i + 1) + ": ");
                armazen[i][j] = input.nextInt();
            }
        }

        exibirEstoque(precos, armazen);
        exibirEstoqueProdutos(precos, armazen, df);
        maiorEstoquePreco(precos, armazen);
        menorEstoque(armazen);
        valorTotal(precos, armazen, df);

        input.close();
    }

    public static void exibirEstoque(float precos[], int armazen[][]) {
        for (int i = 0; i < 5; i++) {
            System.out.println("Armazém " + (i + 1));
            for (int j = 0; j < 10; j++) {
                System.out.println("Produto " + (j + 1) + ": " + armazen[i][j] + " unidades");
            }
        }
    }

    public static void exibirEstoqueProdutos(float precos[], int armazen[][], DecimalFormat df) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Produto " + (i + 1) + ": R$ " + df.format(precos[i]));
            for (int j = 0; j < 5; j++) {
                System.out.println("Armazém " + (j + 1) + ": " + armazen[j][i] + " unidades");
            }
        }
    }

    // Mostra o preço do produto com maior estoque em cada armazem
    public static void maiorEstoquePreco(float precos[], int armazen[][]) {
        for (int i = 0; i < 5; i++) {
            int maior = 0;
            for (int j = 0; j < 10; j++) {
                if (armazen[i][j] > armazen[i][maior]) {
                    maior = j;
                }
            }
            System.out.println("Armazém " + (i + 1) + ": Produto " + (maior + 1) + " - R$ " + precos[maior]);
        }
    }

    // Mostra o menor estoque de cada produto
    public static void menorEstoque(int armazen[][]) {
        for (int i = 0; i < 10; i++) {
            int menor = 0;
            for (int j = 0; j < 5; j++) {
                if (armazen[j][i] < armazen[menor][i]) {
                    menor = j;
                }
            }
            System.out.println("Produto " + (i + 1) + ": Armazém " + (menor + 1) + " - " + armazen[menor][i] + " unidades");
        }
    }

    // Mostra o valor total em cada armazem
    public static void valorTotal(float precos[], int armazen[][], DecimalFormat df) {
        for (int i = 0; i < 5; i++) {
            float total = 0;
            for (int j = 0; j < 10; j++) {
                total += precos[j] * armazen[i][j];
            }
            System.out.println("Armazém " + (i + 1) + ": R$ " + df.format(total));
        }
    }
}
