
import java.util.stream.Stream;

// ler lista de nomes e sexo separados por virgula pelo console,
// criar outra lista utilizando expressões lambda
// separar as mulheres do grupo e imprimir no console

public class App {
    public static void main(String[] args) throws Exception {
        String[] listaConsole = new LerLista().listaEntrada;
        ListaPessoas lista = new ListaPessoas(listaConsole);

        Stream<Pessoa> novaLista = lista.getPessoas().stream().filter((p) -> "f".equals(p.getSexo()));

        System.out.println("Lista filtrada por pessoas do sexo feminino - f:\n");

        novaLista.forEach((nl) -> System.out.println(nl));
    }

}