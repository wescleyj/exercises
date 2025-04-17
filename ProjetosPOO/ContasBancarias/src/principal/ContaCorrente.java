package principal;

/**
 *
 * @author wescleyj
 */

public class ContaCorrente extends ContaBancaria{
    private double limiteChequeEspecial;
    private double usadoChequeEspecial;

    public ContaCorrente(double limiteChequeEspecial, String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
        this.limiteChequeEspecial = limiteChequeEspecial;
        usadoChequeEspecial = 0;
    }

    public ContaCorrente() {
        limiteChequeEspecial = 0;
        usadoChequeEspecial = 0;
    }
    
    public void sacar(double valor, char choice) {
        if (valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            System.out.println("Você sacou com sucesso: R$" + valor);
        }
        else if (valor <= (getSaldo() + limiteChequeEspecial)) {       
            if (choice == 'S') {
                System.out.println("R$" + getSaldo() + "retirado do saldo");
                valor -= getSaldo();
                setSaldo(0);
                limiteChequeEspecial -= valor;
                usadoChequeEspecial += valor;
                System.out.println("R$" + valor + "retirado do Cheque Especial");
                
            }
            else if (choice == 'N') {
                System.out.println("Operação cancelada");
                return;
            }
            else {
                System.out.println("Opção invalida. Operação cancelada");
            }
        }
        else {
            System.out.println("O saldo atual em conta e do cheque especial, é inferior ao valor solicitado, transação cancelada");
        }
    }
    
    @Override
    public void depositar(double valor) {
        if(valor > 0 && usadoChequeEspecial == 0) {
            setSaldo(getSaldo()+ valor);
            System.out.println("Valor adicionado com sucesso");
        }
        else if(valor > 0 && usadoChequeEspecial != 0) {
            if(valor > usadoChequeEspecial) {
                valor -= usadoChequeEspecial;
                limiteChequeEspecial += usadoChequeEspecial;
                usadoChequeEspecial = 0;
                setSaldo(getSaldo()+ valor);
                System.out.println("Valor adicionado com sucesso e Cheque especial pago");
            }
            else{
                usadoChequeEspecial -= valor;
                limiteChequeEspecial += valor;
                System.out.println("Parte do cheque especial pago com sucesso");
            }
        }
        else {
            System.out.println("Saldo invalido");
        }
    }
    
    @Override
    public String toString() {
        return "Conta Corrente {" +
               "Numero da conta = '" + getNumeroConta() + '\'' +
               " Titular da conta = '" + getTitular() + '\'' +
               " Saldo da conta = '" + getSaldo() + '\'' +
               " Limite cheque especial = R$'" + (limiteChequeEspecial - usadoChequeEspecial) + '\'' + 
               " Cheque especial usado = R$'" + usadoChequeEspecial + '\'' +
               '}';
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }
    
}
