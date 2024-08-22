import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class App {
  public static void main(String[] args) {
    Class<?> clazz = Teste.class;

    Method[] methods = clazz.getMethods();

    for (Method method : methods) {
      if (method.getName().equals("test")) {
        Tabela annotation = method.getAnnotation(Tabela.class);
        System.out.println("Campo Nome: " + annotation.Nome());
      }
    }
  }
}
