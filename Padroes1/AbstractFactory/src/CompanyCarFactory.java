public class CompanyCarFactory extends Factory {

  @Override
  Car retriveCar(String requstedGrade) {
    switch (requstedGrade) {
      case "A" :
        return new Tesla(1000, "full", "blue");
      case "B" :
        return new Audi(800, "full", "red");
      default:
        System.out.println("The requested car was unfortunately not available.");
        return null;
    }
  }
}
