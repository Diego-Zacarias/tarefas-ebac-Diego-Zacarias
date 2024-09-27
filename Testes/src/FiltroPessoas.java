import java.util.stream.Stream;

public final class FiltroPessoas {
    private Stream<Pessoa> listaFiltrada;

    public FiltroPessoas(ListaPessoas lista, String sexo){
        this.filtrarPorSexo(lista, sexo);
    }

    private void filtrarPorSexo(ListaPessoas lista, String sexo) {
        this.listaFiltrada = lista
                .getPessoas()
                .stream()
                .filter((item) -> item.getSexo().equals(sexo));
    }

    public Stream<Pessoa> getListaFiltrada() {
        return this.listaFiltrada;
    }
}
