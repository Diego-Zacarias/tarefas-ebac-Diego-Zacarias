public class App {
  public static void main(String[] args) {
    Car car1 = new Volvo("xc60");
    Car car2 = new Renault("Megane");
    Car car3 = new Byd("Dolphin");

    ListaCarros<Car> listaCarros = new ListaCarros<Car>();
    listaCarros.setListaCarros(car1);
    listaCarros.setListaCarros(car2);
    listaCarros.setListaCarros(car3);

    for (Car carro : listaCarros.getListaCarros()) {
      System.out.println(carro);
    }
  }
}
