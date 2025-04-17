package principal_superLTDA;

public class Venda {
    private ItemProduto[] produto;
    private  double precoTotal;

    public Venda(int quantidade) {
        produto = new ItemProduto[quantidade];
        precoTotal = 0;
    }

    public void addProduto(Produto prod, int quantidade) {
        for (int i = 0; i < produto.length; i++) {
            if (produto[i] != null && prod.getCodigo().equals(produto[i].getProduto().getCodigo())) {
                produto[i].setQuantidade(produto[i].getQuantidade() + quantidade);
                precoTotal += prod.getPreco() * quantidade;
                return;
            }
            else if (produto[i] == null) {
                ItemProduto item1 = new ItemProduto(prod, quantidade);
                produto[i] = item1;
                precoTotal += prod.getPreco() * quantidade;
                return;
            }
        }
    }

    public String mostrarVenda() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("\n" + String.format("%-27s", "Descrição") + "- " + String.format("%-10s", "Preco") + "- Quantidade - " + "Total" +"\n");
        for (ItemProduto produto : produto) {
            if (produto != null) {
                resultado.append(produto.getProduto().getDescricao()).append(" - R$ ").append
                        (String.format("%-6s", produto.getProduto().getPreco())).append(" - ").append(String.format("%-10s", produto.getQuantidade())).append
                        (" - R$ ").append(produto.getQuantidade() * produto.getProduto().getPreco()).append("\n");
            }
        }

        if (!resultado.isEmpty()) {
            resultado.append(String.format("%57s", "R$ ")).append(precoTotal).append("\n");
            return resultado.toString();
        }
        else {
            return "\nNenhum produto adicionado ao carrinho!";
        }
    }

    public ItemProduto[] getProduto() {
        return produto;
    }

    public void setProduto(ItemProduto[] produto) {
        this.produto = produto;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
