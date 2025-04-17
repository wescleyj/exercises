import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        montar_biblioteca(biblioteca);

        System.out.println(biblioteca.gerar_relatorio());

        System.out.println("Digite o nome do livro: ");
        String nome = scanner.nextLine();
        System.out.println(biblioteca.buscar_livro(nome));
    }

    public static void montar_biblioteca(Biblioteca biblioteca) {
        // Usuários
        Usuario u1 = new Usuario("1", "Maria Silva");
        Usuario u2 = new Usuario("2", "Carlos Oliveira");
        Usuario u3 = new Usuario("3", "Ana Costa");
        Usuario u4 = new Usuario("4", "Pedro Santos");
        Usuario u5 = new Usuario("5", "Laura Mendes");

        // Livros
        Livro l1 = new Livro("978-85-333-0227-3", "1984", "George Orwell", 1949);
        Livro l2 = new Livro("978-85-325-2408-1", "Dom Quixote", "Miguel de Cervantes", 1605);
        Livro l3 = new Livro("978-85-8041-062-3", "O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943);
        Livro l4 = new Livro("978-85-359-1626-9", "Cem Anos de Solidão", "Gabriel García Márquez", 1967);
        Livro l5 = new Livro("978-85-01-05067-6", "A Revolução dos Bichos", "George Orwell", 1945);
        Livro l6 = new Livro("978-85-7232-227-5", "Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1997);

        biblioteca.add_livro(l1);
        biblioteca.add_livro(l2);
        biblioteca.add_livro(l3);
        biblioteca.add_livro(l4);
        biblioteca.add_livro(l5);
        biblioteca.add_livro(l6);

        biblioteca.add_usuario(u1);
        biblioteca.add_usuario(u2);
        biblioteca.add_usuario(u3);
        biblioteca.add_usuario(u4);
        biblioteca.add_usuario(u5);
    }
}
