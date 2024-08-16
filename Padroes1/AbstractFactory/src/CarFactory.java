public class CarFactory extends Factory {

  @Override
  Car retriveCar(String requstedGrade) {
    switch (requstedGrade) {
      case "A" :
        return new Volvo(1000, "full", "blue");
      case "B" :
        return new Renault(800, "full", "red");
      default:
        System.out.println("The requested car was unfortunately not available.");
        return null;
    }
  }
}
