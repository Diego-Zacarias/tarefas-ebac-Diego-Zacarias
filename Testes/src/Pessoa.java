import java.util.Objects;

public class Pessoa {
  private String nome;
  private String sexo;

  public Pessoa(String nome, String sexo) {
    this.nome = nome;
    this.sexo = sexo;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getSexo() {
    return sexo;
  }
  public void setSexo(String sexo) {
    this.sexo = sexo;
  }
  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return "Nome: " + this.nome + " - Sexo: " + this.sexo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Pessoa pessoa = (Pessoa) o;
    return Objects.equals(nome, pessoa.nome) && Objects.equals(sexo, pessoa.sexo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, sexo);
  }
}
