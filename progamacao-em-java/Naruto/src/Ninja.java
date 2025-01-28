public class Ninja {
    private String nome;
    private String aldeia;
    private int idade;

    // Getters
    public String getNome() {
        return nome;
    }
    public String getAldeia() {
        return aldeia;
    }
    public int getIdade() {
        return idade;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setAldeia(String aldeia) {
        this.aldeia = aldeia;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void imprimir() {
        System.out.println("Nome: " + getNome());
        System.out.println("Aldeia: " + getAldeia());
        System.out.println("Idade: " + getIdade());
    }

    public void ataqueBasico() {
        System.out.println("Ataque Básico!");
    }
}
