import java.util.Locale;

public class IdiomaDoSistema {
    public static void main(String[] args) {
        // Obtém o Locale do sistema
        Locale locale = Locale.getDefault();
        
        // Exibe o idioma e o país do sistema
        System.out.println("Idioma: " + locale.getLanguage());
        System.out.println("País: " + locale.getCountry());
    }
}
