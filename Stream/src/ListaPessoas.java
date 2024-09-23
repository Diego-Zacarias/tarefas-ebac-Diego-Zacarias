
import java.util.ArrayList;
import java.util.List;

public class ListaPessoas {
  private List<Pessoa> pessoas;

  public ListaPessoas(String[] listaConsole) {
    this.preencherLista(listaConsole);
  }

  public ListaPessoas() {
  }



  public List<Pessoa> getPessoas() {
    return pessoas;
  }

  public final void preencherLista(String[] listaConsole) {
    this.pessoas = new ArrayList<>();
    for (String itemObject : listaConsole) {
      String[] item = itemObject.split(" ");
      String nome = item[0];
      String sexo = item[1];
      Pessoa pessoa = new Pessoa(nome, sexo);
      this.pessoas.add(pessoa);
    }
  }
}
