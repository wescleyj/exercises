public class Usuario {
    private String ID;
    private String Nome;
    private Livro[] livros;

    public Usuario(String ID, String Nome) {
        this.ID = ID;
        this.Nome = Nome;
    }

    public Usuario() {
        this.ID = "";
        this.Nome = "";
    }

    public void pegar_emprestado(Livro livro) {
        livro.emprestar();

        for (int i = 0; i < livros.length; i++) {
            if (livros[i] == null) {
                livros[i] = livro;
                break;
            }
        }
    }

    public void devolver_emprestado(Livro livro) {
        livro.devolver();

        for (int i = 0; i < livros.length; i++) {
            if (livros[i] == livro) {
                livros[i] = null;
                break;
            }
        }
    }

    public String listar_emprestados() {
        String emprestados = "";

        for (int i = 0; i < livros.length; i++) {
            if (livros[i] != null) {
                emprestados += livros[i].getTitulo() + "\n";
            }
        }

        return emprestados;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public Livro[] getLivros() {
        return livros;
    }

    public void setLivros(Livro[] livros) {
        this.livros = livros;
    }
}
