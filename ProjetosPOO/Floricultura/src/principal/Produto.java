package principal;

/**
 *
 * @author wescleyj
 */

public class Produto {
    // Atributos/Propriedades
    private String nome;
    private float tamanho; // Centímetros
    private int validade; // Dias
    private float peso; // Gramas
    private String descricao;
    private int codigo;

    // Construtor padrão (sem parâmetros)
    public Produto() {
        nome = "";
        tamanho = 0;
        validade = 0;
        peso = 0;
        descricao = "";
        codigo = 0;
    }

    // Construtor com parâmetros
    public Produto(String nome, float tamanho, int validade, float peso, String descricao, int codigo) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.validade = validade;
        this.peso = peso;
        this.descricao = descricao;
        this.codigo = codigo;
    }
    
    // Métodos de classe
    public boolean estaVencido() {
        return (validade <= 0 );
    }
    
    public void comprar() {
        if (estaVencido()) {
            System.out.println("Você não comprou um(a) " + nome + ", por estar vencido.");
        }
        else {
            System.out.println("Você comprou um(a): " + nome + ".");
        }
    }
    
    public void imprimirPropriedades() {
        System.out.println("Nome: " + nome);
        System.out.println("Validade: " + validade);
        System.out.println("Descrição: " + descricao);
        System.out.println("Tamanho: " + tamanho);
        System.out.println("Peso: " + peso);
        System.out.println("Código: " + codigo);
        System.out.println("Vencido: " + estaVencido() + "\n");
    }
    
    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public int getValidade() {
        return validade;
    }

    public void setValidade(int validade) {
        this.validade = validade;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
