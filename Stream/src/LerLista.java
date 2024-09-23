
import java.util.Scanner;

public class LerLista {
  public String[] listaEntrada;

  public LerLista() {
    this.preencher();
  }

  private String ler() {
    String lista;
    try (Scanner sc = new Scanner(System.in)) {
        System.out.println("Digite a lista de nomes usando o formato: nome m|f, ...outros nomes.");
        lista = sc.nextLine();
    }
    return lista;
  }

  private void preencher() {
    String lista = this.ler();
    this.listaEntrada = lista.split(",");
  }
}
