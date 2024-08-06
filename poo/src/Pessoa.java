
/**
 * Esta classe modela as propriedades comuns 
 * entre pessoa física e pessoa jurídica definidos 
 * na legislação brasileira.
 */
public abstract class Pessoa {
  private String endereco;
  private String contato;

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public void setContato(String contato) {
    this.contato = contato;
  }

  public String getEndereco() {
    return endereco;
  }

  public String getContato() {
    return contato;
  }

  public abstract void imprimirDados();

}
