package principal;

/**
 *
 * @author wescleyj
 */

public class ContaPoupanca extends ContaBancaria{
    private double taxaRendimento;
    
    public ContaPoupanca() {
        taxaRendimento = 0;
    }

    public ContaPoupanca(double taxaRendimento, String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
        this.taxaRendimento = taxaRendimento / 100;
    }
    
    
    
    public void aplicarRendimento() {
        setSaldo(getSaldo() + (taxaRendimento * getSaldo()));
    }
    
    @Override
    public String toString() {
        return "Conta Poupança {" +
               "Numero da conta = '" + getNumeroConta() + '\'' +
               " Titular da conta = '" + getTitular() + '\'' +
               " Saldo da conta = '" + getSaldo() + '\'' +
               " Taxa de rendimento = '" + taxaRendimento * 100 + "%" + '\'' + 
               '}';
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }
    
    
}
