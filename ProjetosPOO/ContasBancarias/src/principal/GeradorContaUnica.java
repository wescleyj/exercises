package principal;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author wescleyj
 */

public class GeradorContaUnica {
    private static final Set<String> contasGeradas = new HashSet<>();
    private static final Random gerador = new Random();
    private static final DecimalFormat formatoX = new DecimalFormat("00000000");
    private static final DecimalFormat formatoDigito = new DecimalFormat("00");
    
    static int soma = 0;

    public static String gerarContaUnica() {
        while (true) {
            int x = gerador.nextInt(100000000); // 0-99999999
            int digito = gerador.nextInt(100);  // 0-99
           
           // Extrair os dígitos de x
            int d1 = (x / 10000000) % 10;
            int d2 = (x / 1000000) % 10;
            int d3 = (x / 100000) % 10;
            int d4 = (x / 10000) % 10;
            int d5 = (x / 1000) % 10;
            int d6 = (x / 100) % 10;
            int d7 = (x / 10) % 10;
            int d8 = x % 10;

            // Extrair os dígito
            int d9 = (digito / 10) % 10;
            int d10 = digito % 10;
            
            soma = 0;
            
            somar(d9);
            somar(d7);
            somar(d5);
            somar(d3);
            somar(d1);
            
            soma += d2 + d4 + d6 + d8 + d10;
            
            soma %= 10;

            String conta = formatoX.format(x) + "-" + formatoDigito.format(digito);

            // Verifica se a conta já existe
            if (!contasGeradas.contains(conta) && soma == 0) {
                contasGeradas.add(conta);
                return conta;
            }
            // Se já existir, tenta novamente
        }
    }
    
    public static void removerConta(String x) {
        contasGeradas.remove(x);
    }
    
    public static void somar(int d9) {
        d9 *= 2;
        if(d9 >= 10) {
                int d01 = d9 % 10;
                int d02 = d9 / 10;
                
                soma += d01 +  d02;
            }
            else {
                soma += d9;
            }
    }
}
