
import java.util.stream.Stream;

// ler lista de nomes e sexo separados por virgula pelo console,
// criar outra lista utilizando expressões lambda
// separar as mulheres do grupo e imprimir no console

public class App {
    public static void main(String[] args) throws Exception {
//        String[] listaConsole = new LerLista().listaEntrada;
        String[] entrada = {"diego m", "quezia f", "joao m", "maria f"};
        ListaPessoas lista = new ListaPessoas(entrada);

        Stream<Pessoa> listaMulheres = new FiltroPessoas(lista, "f").getListaFiltrada();

        System.out.println("Lista filtrada por pessoas do sexo feminino - f:\n");

        listaMulheres.forEach(System.out::println);
    }

}