public class Media {
  public static void main(String[] args) {
    double nota1 = 4, nota2 = 10, nota3 = 7, nota4 = 6;
    double media = 0;

    media = (nota1 + nota2 + nota3 + nota4)/4;

    if (media >= 7 ) {
      System.out.println("Aprovado");
    } else if (media >= 5) {
      System.out.println("Recuperação");
    } else {
      System.out.println("Reprovado");
    }
  }
}
