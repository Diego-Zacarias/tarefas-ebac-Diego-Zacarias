/**
 * Classe Pessoa
 */
public class Pessoa implements Comparable<Pessoa> {
  private String nome;
  private String sexo;

  public Pessoa(String nome, String sexo) {
    this.nome = nome;
    this.sexo = sexo;
  }

  public String getNome() {
    return this.nome;
  }

  public String getSexo() {
    return this.sexo;
  }

  @Override
  public int compareTo(Pessoa arg0) {
    return this.nome.compareTo(arg0.getNome());
  }

}
