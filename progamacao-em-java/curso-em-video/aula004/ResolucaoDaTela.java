import java.awt.*;

public class ResolucaoDaTela {
    public static void main(String[] args) {
        // Obtém o Toolkit
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        
        // Obtém a resolução da tela
        Dimension screenSize = toolkit.getScreenSize();
        
        // Exibe a resolução
        System.out.println("Resolução da tela: " + screenSize.width + "x" + screenSize.height);
    }
}