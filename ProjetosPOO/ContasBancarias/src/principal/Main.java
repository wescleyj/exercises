package principal;

/**
 *
 * @author wescleyj
 */

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<ContaCorrente> contasCorrentes = new ArrayList<>();
    private static ArrayList<ContaPoupanca> contasPoupancas = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        String conta;
        double valor;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    System.out.println("Qual conta deseja fechar(00000000-00)");
                    conta = scanner.next();
                    for(int i = 0; i < contasCorrentes.size(); i++){
                        if (contasCorrentes.get(i).getNumeroConta().equals(conta)) {
                            GeradorContaUnica.removerConta(conta);
                            contasCorrentes.remove(i);
                            System.out.println("Conta removida com sucesso.");
                            break; // Interrompe o loop após remover
                        }
                    }
                    for(int i = 0; i < contasPoupancas.size(); i++){
                        if (contasPoupancas.get(i).getNumeroConta().equals(conta)) {
                            GeradorContaUnica.removerConta(conta);
                            contasPoupancas.remove(i);
                            System.out.println("Conta removida com sucesso.");
                            break; // Interrompe o loop após remover
                        }
                    }
                    break;
                case 3:
                    System.out.println("Qual conta deseja sacar(00000000-00)");
                    conta = scanner.next();
                    for(int i = 0; i < contasCorrentes.size(); i++){
                        if (contasCorrentes.get(i).getNumeroConta().equals(conta)) {
                            System.out.println("Qual valor deseja sacar?");
                            valor = scanner.nextDouble();
                            scanner.nextLine();
                            if (valor > contasCorrentes.get(i).getSaldo()) {
                        System.out.println("Deseja utilizar o cheque especial (S/N)?");
                        char choice = scanner.nextLine().charAt(0);
                        contasCorrentes.get(i).sacar(valor, choice);
                    } else {
                        contasCorrentes.get(i).sacar(valor, 'N');
                    }
                        }
                    }
                    for(int i = 0; i < contasPoupancas.size(); i++){
                        if (contasPoupancas.get(i).getNumeroConta().equals(conta)) {
                            System.out.println("Qual valor deseja sacar?");
                            valor = scanner.nextDouble();
                            scanner.nextLine();
                            contasPoupancas.get(i).sacar(valor);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Qual conta deseja depositar(00000000-00)");
                    conta = scanner.next();
                    for(int i = 0; i < contasCorrentes.size(); i++){
                        if (contasCorrentes.get(i).getNumeroConta().equals(conta)) {
                            System.out.println("Qual valor deseja depositar?");
                            valor = scanner.nextDouble();
                            scanner.nextLine();
                            contasCorrentes.get(i).depositar(valor);
                        }
                    }
                    for(int i = 0; i < contasPoupancas.size(); i++){
                        if (contasPoupancas.get(i).getNumeroConta().equals(conta)) {
                            System.out.println("Qual valor deseja depositar?");
                            valor = scanner.nextDouble();
                            scanner.nextLine();
                            contasPoupancas.get(i).depositar(valor);
                        }
                    }
                    break;
                case 5:
                    for(int i = 0; i < contasCorrentes.size(); i++){
                        System.out.println(contasCorrentes.get(i).toString());
                    }
                    for(int i = 0; i < contasPoupancas.size(); i++){
                        System.out.println(contasPoupancas.get(i).toString());
                    }
                    break;
                case 6:
                    for(int i = 0; i < contasPoupancas.size(); i++){
                        contasPoupancas.get(i).aplicarRendimento();
                    }
                    System.out.println("Rendimento aplicado em todas as Conta");
                    break;
                case 7:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 7);
    }
    
    private static void exibirMenu() {
        System.out.println("\n=== MENU BANCÁRIO ===");
        System.out.println("1. Criar conta");
        System.out.println("2. Remover conta");
        System.out.println("3. Sacar");
        System.out.println("4. Depositar");
        System.out.println("5. Ver informações de todas as contas");
        System.out.println("6. Aplicar taxa de rendimento");
        System.out.println("7. Sair");
        System.out.print("Escolha uma opção: ");
    }
    
    private static void criarConta() {
    System.out.println("\n--- CRIAR CONTA ---");
    
    System.out.print("Nome do titular: ");
    String titular = scanner.nextLine();
    
    System.out.print("Saldo inicial: R$ ");
    double saldo = scanner.nextDouble();
    scanner.nextLine(); // Limpar buffer
    
    System.out.print("Tipo de conta (1-Corrente / 2-Poupança): ");
    int tipo = scanner.nextInt();
    scanner.nextLine(); // Limpar buffer
    
    if (tipo == 1) {
        System.out.print("Valor do cheque especial: R$ ");
        double chequeEspecial = scanner.nextDouble();
        ContaCorrente novaConta = new ContaCorrente(chequeEspecial, GeradorContaUnica.gerarContaUnica(), titular, saldo);
        contasCorrentes.add(novaConta);
    } else if (tipo == 2) {
        System.out.print("Taxa de rendimento (%): ");
        double taxa = scanner.nextDouble();
        ContaPoupanca novaConta = new ContaPoupanca(taxa, GeradorContaUnica.gerarContaUnica(), titular, saldo);
        contasPoupancas.add(novaConta);
    } else {
        System.out.println("Tipo de conta inválido!");
        return;
    }
    
    System.out.println("Conta criada com sucesso!");
}
}
