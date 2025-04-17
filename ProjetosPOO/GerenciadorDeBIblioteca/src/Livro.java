public class Livro {
    private String ISBN;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String status;

    public Livro() {
        ISBN = null;
        titulo = null;
        autor = null;
        anoPublicacao = 0;
        status = null;
    }

    public Livro(String ISBN, String titulo, String autor, int anoPublicacao) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        status = "Disponivel";
    }

    public void emprestar() {
        if(this.status.equals("Disponivel")) {
            this.status = "Emprestado";
        }
    }

    public void devolver() {
        this.status = "Disponivel";
    }

    public void excluir_livro() {
        ISBN = null;
        titulo = null;
        autor = null;
        anoPublicacao = 0;
        status = null;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "ISBN='" + ISBN + '\'' +
                ", Titulo='" + titulo + '\'' +
                ", Autor='" + autor + '\'' +
                ", AnoPublicacao='" + anoPublicacao + '\'' +
                ", Status='" + status + '\'' +
                '}';
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
