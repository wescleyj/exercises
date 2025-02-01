import java.util.Scanner;

public class App013 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String newstring = "", newstring2 = "";

        int tam = string.length();

        for (int j = tam - 1; j >= 0; j--) {
            newstring = newstring + string.charAt(j);
        }

        System.out.println(newstring);

        for (int j = 0; j < tam; j++) {
            if (Character.isLetter(newstring.charAt(j))) {
                if (newstring.charAt(j) == 'A' || newstring.charAt(j) == 'E' || newstring.charAt(j) == 'I'
                        || newstring.charAt(j) == 'O' || newstring.charAt(j) == 'U' || newstring.charAt(j) == 'a'
                        || newstring.charAt(j) == 'e' || newstring.charAt(j) == 'i' || newstring.charAt(j) == 'o'
                        || newstring.charAt(j) == 'u' || newstring.charAt(j) == ' ') {
                    newstring2 = newstring2 + newstring.charAt(j);
                    continue;
                }
            } else {
                newstring2 = newstring2 + '#';
            }
        }

        System.out.println(newstring2);
        scanner.close();
    }
}
