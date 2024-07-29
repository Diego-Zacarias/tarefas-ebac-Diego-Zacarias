import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Pessoa pessoas = new Pessoa();
		Character continua = 's';
		while (continua.equals('s')) {
			System.out.println("Insira um nome: ");
			String nome = sc.nextLine();
			System.out.println("Insira o sexo: [m - masculino | f - feminino]");
			Character sexo = sc.nextLine().charAt(0);
			pessoas.adicionarPessoa(sexo, nome);
			System.out.println("Deseja inserir um nome? [s - Sim | n - não]");
			continua = sc.nextLine().charAt(0);
		}
		pessoas.imprimirPessoas();
		sc.close();
	}

}
