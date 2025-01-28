public class Main {
    public static void main(String[] args) {
        BolsaNinja<Object> bolsaNinja = new BolsaNinja<Object>();

        bolsaNinja.adicionarFerramenta(new Kunai("Kunai Explosiva"));
        bolsaNinja.adicionarFerramenta(new Shuriken(3));
        bolsaNinja.adicionarFerramenta(new Pergaminho("Invocação: Kuchiyose no Jutsu"));

        System.out.println("Ferramentas na bolsa:");
        bolsaNinja.mostrarFerramentas();

        System.out.println();

        Uzumaki naruto = new Uzumaki();
        naruto.setNome("Naruto Uzumaki");
        naruto.setAldeia("Konoha");
        naruto.setIdade(17);

        Uchiha sasuke = new Uchiha();
        sasuke.setNome("Sasuke Uchiha");
        sasuke.setAldeia("Konoha");
        sasuke.setIdade(17);

        sasuke.imprimir();
        sasuke.ataqueBasico();
        sasuke.sharingan();

        System.out.println();

        naruto.imprimir();
        naruto.ataqueBasico();
        naruto.rasengan();
    }
}