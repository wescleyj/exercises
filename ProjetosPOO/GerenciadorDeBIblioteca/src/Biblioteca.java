public class Biblioteca {
    private final Livro[] livros;
    private final Usuario[] usuarios;

    public Biblioteca() {
        this.livros = new Livro[100];
        this.usuarios = new Usuario[100];
    }

    public void add_livro(Livro livro) {
        for (int i = 0; i < livros.length; i++) {
            if (livros[i] == null) {
                this.livros[i] = livro;
                break;
            }
        }
    }

    public void remover_livro(String ISBN) {
        for (int i = 0; i < livros.length; i++) {
            if (livros[i].getISBN().equals(ISBN)) {
                livros[i].excluir_livro();
                livros[i] = null;
                break;
            }
        }
    }

    public String buscar_livro(String nome) {
        for (Livro livro : livros) {
            if (livro != null && livro.getTitulo().equals(nome)) {
                return livro.toString();
            }
        }
        return "Livro não encontrado";
    }

    public String gerar_relatorio() {
        String relatorio = "";
        int emprestados, total, disponiveis, users;
        emprestados = total = disponiveis = users = 0;

        for (Livro livro : livros) {
            if (livro != null) {
                if (livro.getStatus().equals("Emprestado")) {
                    emprestados++;
                } else {
                    disponiveis++;
                }
                total++;
            }
        }

        for (Usuario usuario : usuarios) {
            if (usuario != null) {
                 users++;
            }
        }

        relatorio += "Total de livros: " + total + "\n";
        relatorio += "Total de usuarios: " + users + "\n";
        relatorio += "Livros emprestados: " + emprestados + "\n";
        relatorio += "Livros disponiveis: " + disponiveis + "\n";

        return relatorio;
    }

    public void add_usuario(Usuario usuario) {
        for (int i = 0; i < usuarios.length; i++) {
            if (usuarios[i] == null) {
                usuarios[i] = usuario;
                return;
            }
        }
    }
}