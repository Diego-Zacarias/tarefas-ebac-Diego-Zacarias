import java.util.Scanner;

public class Wrapper {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numero = scanner.nextInt();
    Integer numInteger = numero;
    System.out.println(numInteger);
    scanner.close();
  }
}
