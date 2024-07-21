import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe ListaPessoas
 */
public class ListaPessoas {
  private Map<String, List<String>> listaPessoas = new HashMap<String, List<String>>();
  private List<String> pessoasMasculino = new ArrayList<String>();
  private List<String> pessoasFeminino = new ArrayList<String>();

  public ListaPessoas(String pessoas) {
    this.listaPessoas.put("Masculino", pessoasMasculino);
    this.listaPessoas.put("Feminino", pessoasFeminino);

    String[] pessoasSplited = pessoas.split(",");

    for (String nomeSexo : pessoasSplited) {
      String[] pessoa = nomeSexo.split("-");
      String nome = pessoa[0].trim();
      String sexo = pessoa[1].trim().toLowerCase();
      if (sexo.equals("m")) {
        this.pessoasMasculino.add(nome);
      }
      if (sexo.equals("f")) {
        this.pessoasFeminino.add(nome);
      }
    }

  }

  public void imprimeNomes() {
    System.out.println("Pessoas do sexo masculino:");
    pessoasMasculino.sort(null);
    for (String nome : pessoasMasculino) {
      System.out.println("Nome: " + nome + "\tsexo: m");
    }

    System.out.println("Pessoas do sexo feminino:");
    Collections.sort(pessoasFeminino);
    for (String nome : pessoasFeminino) {
      System.out.println("Nome: " + nome + "\tsexo: f");
    }
  }
}
