import java.util.Calendar;

public class PessoaJuridica extends Pessoa {
  private Calendar dataDeAbertura;
  private String razaoSocial;
  private String nomeFantasia;
  private String descricaoDasAtividadesEconomicas;
  private String codigoEDescricaoDaNaturezaJuridica;
  private String situacaoCadastral;
  private String cnpj;

  /**
   * Esta classe modela as propriedades de uma
   * pessoa jurídica e extende a calsse Pessoa
   *
   * @see Pessoa
   *
   * @param dataDeAbertura
   * @param razaoSocial
   * @param nomeFantasia
   * @param descricaoDasAtividadesEconomicas
   * @param codigoEDescricaoDaNaturezaJuridica
   * @param situacaoCadastral
   * @param cnpj
   * @param endereco
   * @param contato
   */
  public PessoaJuridica(
    Calendar dataDeAbertura,
    String razaoSocial,
    String nomeFantasia,
    String descricaoDasAtividadesEconomicas,
    String codigoEDescricaoDaNaturezaJuridica,
    String situacaoCadastral,
    String cnpj,
    String endereco,
    String contato
  ) {
    this.dataDeAbertura = dataDeAbertura;
    this.razaoSocial = razaoSocial;
    this.nomeFantasia = nomeFantasia;
    this.descricaoDasAtividadesEconomicas = descricaoDasAtividadesEconomicas;
    this.codigoEDescricaoDaNaturezaJuridica = codigoEDescricaoDaNaturezaJuridica;
    this.situacaoCadastral = situacaoCadastral;
    this.cnpj = cnpj;
    this.setEndereco(endereco);
    this.setContato(contato);
  }

  public Calendar getDataDeAbertura() {
    return dataDeAbertura;
  }

  public String getRazaoSocial() {
    return razaoSocial;
  }

  public String getNomeFantasia() {
    return nomeFantasia;
  }

  public String getDescricaoDasAtividadesEconomicas() {
    return descricaoDasAtividadesEconomicas;
  }

  public String getCodigoEDescricaoDaNaturezaJuridica() {
    return codigoEDescricaoDaNaturezaJuridica;
  }

  public String getSituacaoCadastral() {
    return situacaoCadastral;
  }

  @Override
  public void imprimirDados() {
    System.out.println("\n** Dados de pessoa Jurídica **\n"
    +"\tRazao Social: " + this.razaoSocial
    +"\n\tData de Abertura: " + this.dataDeAbertura.getTime()
    +"\n\tNome Fantasia: " + this.nomeFantasia
    +"\n\tDescrição Das Atividades Economicas: " + this.descricaoDasAtividadesEconomicas
    +"\n\tCodigo E Descrição Da Natureza Jurídica: " + this.codigoEDescricaoDaNaturezaJuridica
    +"\n\tSituação Cadastral: " + this.situacaoCadastral
    +"\n\tCNPJ: " + this.cnpj
    +"\n\tEndereço: " + this.getEndereco()
    +"\n\tContato: " + this.getContato()
  );
  }
}
