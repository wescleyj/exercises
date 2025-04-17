package principal_superLTDA;

public class Estoque {
    private ItemProduto[] estante;

    public Estoque(int quantidade) {
        estante = new ItemProduto[quantidade];
    }

    public boolean addItemProduto(ItemProduto itemProduto) {
        for (int i = 0; i < estante.length; i++) {
            if (estante[i] == null) {
                estante[i] = itemProduto;
                return true;
            }
        }
        return false;
    }

    public void removerItemProduto(String codigo, int quantidade) {
        for (ItemProduto itemProduto : estante) {
            if (itemProduto != null && itemProduto.getProduto().getCodigo().equals(codigo)) {
                itemProduto.setQuantidade(itemProduto.getQuantidade() - quantidade);
            }
        }
    }


    public String mostrarEstoque() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("\nCodigo - " + String.format("%-25s", "Descrição") + "- " + String.format("%-10s", "Preco") + "- Quantidade\n");
        for (ItemProduto itemProduto : estante) {
            if (itemProduto != null) {
                resultado.append(String.format("%-8s", itemProduto.getProduto().getCodigo())).append(" ").append
                        (itemProduto.getProduto().getDescricao()).append(" R$").append
                        (String.format("%-6s", itemProduto.getProduto().getPreco())).append("    ").append(itemProduto.getQuantidade()).append("\n");
            }
        }
        return resultado.toString();
    }

    public boolean temNoEstoque(String codigo, int quantidade) {
        for (ItemProduto itemProduto : estante) {
            if (itemProduto != null && itemProduto.getProduto().getCodigo().equals(codigo) && itemProduto.getQuantidade() > quantidade) {
                return true;
            }
        }
        return false;
    }

    public Produto getProduto(String codigo) {
        for (ItemProduto itemProduto : estante) {
            if (itemProduto != null && itemProduto.getProduto().getCodigo().equals(codigo)) {
                return itemProduto.getProduto();
            }
        }
        return null;
    }

    public ItemProduto[] getEstante() {
        return estante;
    }

    public void setEstante(ItemProduto[] estante) {
        this.estante = estante;
    }
}
