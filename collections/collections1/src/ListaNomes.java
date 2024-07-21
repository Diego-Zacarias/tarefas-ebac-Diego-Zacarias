import java.util.ArrayList;
import java.util.List;

/**
 * Classe ListaNomes
 */
public class ListaNomes {
  private List<String> ListaNomes = new ArrayList<String>();

  public ListaNomes(String nomes) {
    String[] lista = nomes.split(",");
    for (String nome : lista) {
      this.ListaNomes.add(nome.trim());
    }
  }

  public void imprimeNomes() {
    System.out.println("lista de nomes ordenada!");
    this.ListaNomes.sort(null);
    for (String nome : ListaNomes) {
      System.out.println(nome);
    }
  }

  public List<String> geListaNomes() {
    return this.ListaNomes;
  }
}
