package principal;

/**
 *
 * @author wescleyj
 */

public class ContaBancaria {
    private String numeroConta;
    private String titular;
    private double saldo;
    
    // Contrutores
    // Construtor (sem parametros)
    public ContaBancaria() {
        numeroConta = "";
        titular = "";
        saldo = 0;
    }
    
    // Construtor (com parametros)
    public ContaBancaria(String numeroConta, String titular, double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
    }
    
    // Metodos
    public void depositar(double valor) {
        if(valor > 0) {
            saldo += valor;
            System.out.println("Valor adicionado com sucesso");
        }
        else {
            System.out.println("Saldo invalido");
        }
    }
    
    public void sacar(double valor) {
        if(valor <= saldo) {
            saldo -= valor;
            System.out.println("Você sacou com sucesso: R$" + valor);
        }
        else {
            System.out.println("O saldo atual em conta é inferior ao valor solicitado, transação não concluida");
        }
    }
    
    @Override
    public String toString() {
        return "Conta Bancaria {" +
               "Numero da conta = '" + numeroConta + '\'' +
               " Titular da conta = '" + titular + '\'' +
               " Saldo da conta = '" + saldo + '\'' +
               '}';
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
