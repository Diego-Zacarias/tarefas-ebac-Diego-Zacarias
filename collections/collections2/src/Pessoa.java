import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Pessoa {
	private Map<Character, ArrayList<String>> pessoas = new TreeMap<Character, ArrayList<String>>();

	public void imprimirPessoas() {
		this.pessoas.forEach((sexo, nomes) -> {
			System.out.println(sexo.equals('m') ? "Homem\t" : "Mulher\t");
			nomes.forEach(nome -> {
				System.out.println(nome);
			});
		});
	}

	public void adicionarPessoa(Character sexo, String nome) {
		if(this.pessoas.get(sexo) == null) {
			ArrayList<String> nomes = new ArrayList<String>();
			nomes.add(nome);
			this.pessoas.put(sexo, nomes);
		} else {
			ArrayList<String> listaNomes = this.pessoas.get(sexo);
			listaNomes.add(nome);
			this.pessoas.put(sexo, listaNomes);
		}
	}
	
}
