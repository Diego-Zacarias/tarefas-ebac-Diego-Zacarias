public class App {

  public static void main(String[] args) {
    Customer customer = new Customer("B", true);
    Factory factory = getCarFactory(customer);
    Car car = factory.create(customer.getGradeRequest());
  }

  private static  Factory getCarFactory(Customer customer) {
    if (customer.isHasCompanyContract()) {
      return new CompanyCarFactory();
    }
    return new CarFactory();
  }
}
