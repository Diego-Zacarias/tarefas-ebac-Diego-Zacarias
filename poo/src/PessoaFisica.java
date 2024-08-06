import java.util.Calendar;

public class PessoaFisica extends Pessoa {
  private String nome;
  private String cpf;
  private Calendar dataNascimento;
  private String sexo;
  private String estadoCivil;

  /**
   * Esta classe modela as propriedades de uma
   * pessoa jurídica e extende a calsse Pessoa
   *
   * @see Pessoa
   *
   * @param nome
   * @param cpf
   * @param dataNascimento
   * @param sexo
   * @param estadoCivil
   * @param endereco
   * @param contato
   */
  public PessoaFisica(
      String nome,
      String cpf,
      Calendar dataNascimento,
      String sexo,
      String estadoCivil,
      String endereco,
      String contato) {
    this.nome = nome;
    this.cpf = cpf;
    this.dataNascimento = dataNascimento;
    this.sexo = sexo;
    this.estadoCivil = estadoCivil;
    this.setEndereco(endereco);
    this.setContato(contato);
  }

  public String getNome() {
    return nome;
  }

  public String getCpf() {
    return cpf;
  }

  public Calendar getDataNascimento() {
    return dataNascimento;
  }

  public String getSexo() {
    return sexo;
  }

  public String getEstadoCivil() {
    return estadoCivil;
  }

  @Override
  public void imprimirDados() {
    System.out.println("\n** Dados de pessoa Fisíca **\n"
        + "\tNome: " + this.nome
        + "\n\tData de nascimento: " + this.dataNascimento.getTime()
        + "\n\tEstado civíl: " + this.estadoCivil
        + "\n\tCpf: " + this.cpf
        + "\n\tsexo: " + this.sexo
        + "\n\tEndereço: " + this.getEndereco()
        + "\n\tContato: " + this.getContato());
  }
}
