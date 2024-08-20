import java.util.ArrayList;
import java.util.List;

public class ListaCarros<T extends Car> {
  List<T> listaCarros = new ArrayList<T>();

  public List<T> getListaCarros() {
    return listaCarros;
  }

  public void setListaCarros(T carro) {
    this.listaCarros.add(carro);
  }
}
