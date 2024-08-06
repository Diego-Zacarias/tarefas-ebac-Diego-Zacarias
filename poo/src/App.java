import java.util.Calendar;

public class App {
    public static void main(String[] args) throws Exception {
        Calendar dataNascimento = Calendar.getInstance();
        dataNascimento.set(Calendar.YEAR, 1990);
        dataNascimento.set(Calendar.MONTH, Calendar.JANUARY);
        dataNascimento.set(Calendar.DAY_OF_MONTH, 3);

        Pessoa pf = new PessoaFisica(
            "Diego Zcarias Santos de Lima",
            "123.456.789-89",
            dataNascimento,
            "Masculino",
            "Casado",
            "R. primeira, 43",
            "21986458792"
        );

        pf.imprimirDados();

        Calendar dataAbertura = Calendar.getInstance();
        dataNascimento.set(Calendar.YEAR, 2015);
        dataNascimento.set(Calendar.MONTH, Calendar.NOVEMBER);
        dataNascimento.set(Calendar.DAY_OF_MONTH, 7);
        Pessoa pj = new PessoaJuridica(
            dataAbertura,
            "Sociedade dos poetas S/A",
            "Poetas sem rima",
            "reunir poetas que não conseguem rimar",
            "Empresa",
            "ativo",
            "51.412.983/0001-04",
            "R. 1, 34",
            "11979875645"
        );

        pj.imprimirDados();
    }
}
