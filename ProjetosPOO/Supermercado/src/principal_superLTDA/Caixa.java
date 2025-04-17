package principal_superLTDA;

import java.util.Scanner;

public class Caixa {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int quantidadeDeVenda;

        Estoque estoque = new Estoque(8);

        estocar(estoque);

        System.out.println("Bem vindo ao Super Mercado LTDA");

        Venda venda = new Venda(100);

        while(true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Mostrar carrinho");
            System.out.println("2 - Mostrar estoque");
            System.out.println("3 - Comprar item");
            System.out.println("4 - Finalizar compra");
            System.out.print("Escolha uma opção: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println(venda.mostrarVenda());
                    break;
                case 2:
                    System.out.println(estoque.mostrarEstoque());
                    break;
                case 3:
                    while(true) {
                        System.out.println("Qual o codigo do produto desejado?(0 retornar)");
                        String codigo = sc.next();
                        if (codigo.equals("0")) {
                            break;
                        }
                        else if (estoque.temNoEstoque(codigo, 1)) {
                            while (true) {
                                System.out.println("Quantidade desejada:");
                                quantidadeDeVenda = sc.nextInt();
                                sc.nextLine();
                                if (!estoque.temNoEstoque(codigo, quantidadeDeVenda)) {
                                    System.out.println("Estoque insuficiente!");
                                } else {
                                    break;
                                }
                            }

                            venda.addProduto(estoque.getProduto(codigo), quantidadeDeVenda);
                            estoque.removerItemProduto(codigo, quantidadeDeVenda);
                            System.out.println("Produto adicionado ao carrinho com sucesso!");
                        } else {
                            System.out.println("Produto não encontrado!");
                        }
                    }
                    break;
                case 4:
                    System.out.println("O valor da compra foi: " + venda.getPrecoTotal() + " reais");
                    System.out.println("Venda finalizada com sucesso!");
                    return;
                default:
                    System.out.println("Opção invalida");
            }
        }
    }

    public static void estocar(Estoque estoque) {

        Produto p1 = new Produto("11111", "Detergente ABC", 1.00);
        Produto p2 = new Produto("22222", "Sabão em pó OMO", 6.50);
        Produto p3 = new Produto("33333", "Shampoo Beleza Fácil", 12.00);
        Produto p4 = new Produto("44444", "Creme dental Colgate", 3.50);
        Produto p5 = new Produto("55555", "Sabonete Nívea", 1.80);
        Produto p6 = new Produto("66666", "Biscoito Maizena", 2.00);
        Produto p7 = new Produto("77777", "Leite desnatado Parmalat", 3.00);

        ItemProduto item1 = new ItemProduto(p1, 20);
        ItemProduto item2 = new ItemProduto(p2, 20);
        ItemProduto item3 = new ItemProduto(p3, 20);
        ItemProduto item4 = new ItemProduto(p4, 20);
        ItemProduto item5 = new ItemProduto(p5, 20);
        ItemProduto item6 = new ItemProduto(p6, 20);
        ItemProduto item7 = new ItemProduto(p7, 20);

        if (estoque.addItemProduto(item1) && estoque.addItemProduto(item2) && estoque.addItemProduto(item3) &&
                estoque.addItemProduto(item4) && estoque.addItemProduto(item5) && estoque.addItemProduto(item6) &&
                estoque.addItemProduto(item7)) {
            System.out.println("Estoque realizado com sucesso!");
        }
        else {
            System.out.println("Erro ao realizar estoque. Tente novamente");
        }
    }
}