/**
 * <h1>Esta classe modela um vendedor</h1>
 * 
 * @author diego
 * 
 * @version 1.0
 */
public class Vendedor {
	private String 	nome;
	private String 	matricula;
	private int 	qtdVendas = 0;
	
	/**
	 * Para instanciar um vendedor, informe os 
	 * parâmetros solicitados
	 * 
	 * @param nome
	 * @param matricula
	 */
	public Vendedor(String nome, String matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public int getQtdVendas() {
		return qtdVendas;
	}
	
	/**
	 * Método que registra a quantidade de vendas 
	 * de um vendedor.
	 * 
	 * @param qtdVenda
	 */
	public void atribuirVenda(int qtdVenda) {
		this.qtdVendas += qtdVenda;
	}
	

}
