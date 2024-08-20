public class Car {
  private String brand;
  private String model;

  public Car(String brand, String model) {
    this.brand = brand;
    this.model = model;
  }

  public String getBrand() {
    return brand;
  }

  public String getModel() {
    return model;
  }

  @Override
  public String toString() {
    return "Car{" +
            "brand='" + brand + '\'' +
            ", model='" + model + '\'' +
            '}';
  }
}
