import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FiltroPessoasTest {
    @Test
    public void filtroPorSexoTest() {
        String[] entrada = {"diego m", "quezia f", "joao m", "maria f"};
        ListaPessoas lista = new ListaPessoas(entrada);
        String[] saida = {"quezia f", "maria f"};
        List<Pessoa> listaMulheres = new ListaPessoas(saida)
                .getPessoas();
        String sexo = "f";

        List<Pessoa> listaMulherestest = new FiltroPessoas(lista, sexo)
                .getListaFiltrada()
                .collect(Collectors.toList());

        assertEquals(listaMulherestest,listaMulheres);
    }
}
