import java.util.Scanner;

/**
 * parte 1
 * Ler uma lista de nomes em uma única string separados por vírgula
 * ordenar a lista de nomes e imprimir;
 * 
 * parte 2
 * mesmo que a parte 1 mas agrupando por sexo;
 */

public class App {

    public static void main(String[] args) throws Exception {
        /**
         * Parte 1
         */
        Scanner sc = new Scanner(System.in);
        String textoParte1 = "Escreva uma lista de nomes separados por "
                            + "\nvirgula e pressione Enter para terminar.";
        String nomes = lerNomes(sc, textoParte1);

        ListaNomes ln = new ListaNomes(nomes);
        ln.imprimeNomes();

        /**
         * Parte 2
         */
        String textoParte2 = "Escreva uma lista no fomato nome-sexo onde sexo:"
                            + " m/f separados por \nvirgula e pressione Enter"
                            + " para terminar.";
        String pessoas = lerNomes(sc, textoParte2);
        ListaPessoas lns = new ListaPessoas(pessoas);
        lns.imprimeNomes();

        sc.close();
    }

    public static String lerNomes(Scanner scanner, String texto) {
        System.out.println(texto);
        String nomes = scanner.nextLine();
        return nomes;
    }
}
