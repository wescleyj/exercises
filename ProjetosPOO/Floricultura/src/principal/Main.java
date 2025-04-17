package principal;

/**
 *
 * @author wescleyj
 */

public class Main {
    
    public static void main(String[] args) {
            // Exemplo de construtor (sem parâmetros)
            Produto flor1 = new Produto();
            
            // Exemplos de construtores (com parâmetros)
            Produto flor2 = new Produto(
                    "Rosa Vermelha", 
                    50.0f, 
                    1, 
                    100.0f, 
                     "Rosa vermelha fresca, ideal para decoração", 
                    3001); 
            Produto bombom = new Produto(
                    "Bombom de Chocolate", 
                    5.0f, 
                    2,
                    50.0f, 
                    "Delicioso bombom de chocolate ao leite", 
                    1001); 
            Produto pelucia = new Produto(
                    "Urso de Pelúcia Médio", 
                    30.0f, 
                    365, 
                    500.0f, 
                    "Urso de pelúcia fofinho, perfeito para presentes", 
                    2001); 
            
           // Exemplo de uso de setters
           flor1.setNome("Girassol");
           flor1.setValidade(0);
           flor1.setDescricao("Girassol fresco, símbolo de alegria e energia");
           flor1.setTamanho(70.0f);
           flor1.setPeso(150.0f);
           flor1.setCodigo(3002);

           imprimirPropriedades(flor2);
           
           // Exemplos de uso de métodos de classe
           bombom.imprimirPropriedades();
           pelucia.imprimirPropriedades();
           flor1.imprimirPropriedades();
            
           flor1.comprar();
           flor2.comprar();
    }
    
    // Exemplo de uso de getters(codigo duplicado)
    public static void imprimirPropriedades(Produto produto) {
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Validade: " + produto.getValidade());
        System.out.println("Descrição: " + produto.getDescricao());
        System.out.println("Tamanho: " + produto.getTamanho());
        System.out.println("Peso: " + produto.getPeso());
        System.out.println("Código: " + produto.getCodigo() );
        System.out.println("Vencido: " + produto.estaVencido() + "\n");
    }
}


