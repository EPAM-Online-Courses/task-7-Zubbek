package efs.task.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ClassInspector {

  /**
   * Metoda powinna wyszukać we wszystkich zadeklarowanych przez klasę polach te które oznaczone
   * są adnotacją podaną jako drugi parametr wywołania tej metody. Wynik powinien zawierać tylko
   * unikalne nazwy pól (bez powtórzeń).
   *
   * @param type       klasa (typ) poddawana analizie
   * @param annotation szukana adnotacja
   * @return lista zawierająca tylko unikalne nazwy pól oznaczonych adnotacją
   */
  public static Collection<String> getAnnotatedFields(final Class<?> type,
      final Class<? extends Annotation> annotation) {
    //TODO usuń zawartość tej metody i umieść tutaj swoje rozwiązanie
    Set<String> annotatedFields = new HashSet<>();
    Field[] fields = type.getDeclaredFields();
    for (Field field : fields) {
      if (field.isAnnotationPresent(annotation)) {
        annotatedFields.add(field.getName());
      }
    }
    return annotatedFields;
  }

  /**
   * Metoda powinna wyszukać wszystkie zadeklarowane bezpośrednio w klasie metody oraz te
   * implementowane przez nią pochodzące z interfejsów, które implementuje. Wynik powinien zawierać
   * tylko unikalne nazwy metod (bez powtórzeń).
   *
   * @param type klasa (typ) poddawany analizie
   * @return lista zawierająca tylko unikalne nazwy metod zadeklarowanych przez klasę oraz te
   * implementowane
   */
  public static Collection<String> getAllDeclaredMethods(final Class<?> type) {
    //TODO usuń zawartość tej metody i umieść tutaj swoje rozwiązanie
    Set<String> allMethods = new HashSet<>();
    Method[] methods = type.getDeclaredMethods();
    for (Method method : methods) {
      allMethods.add(method.getName());
    }
    Class<?>[] interfaces = type.getInterfaces();
    for (Class<?> iface : interfaces) {
      Method[] ifaceMethods = iface.getDeclaredMethods();
      for (Method method : ifaceMethods) {
        allMethods.add(method.getName());
      }
    }
    return allMethods;
  }

  /**
   * Metoda powinna odszukać konstruktor zadeklarowany w podanej klasie który przyjmuje wszystkie
   * podane parametry wejściowe. Należy tak przygotować implementację aby nawet w przypadku gdy
   * pasujący konstruktor jest prywatny udało się poprawnie utworzyć nową instancję obiektu
   * <p>
   * Przykładowe użycia:
   * <code>ClassInspector.createInstance(Villager.class)</code>
   * <code>ClassInspector.createInstance(Villager.class, "Nazwa", "Opis")</code>
   *
   * @param type klasa (typ) którego instancje ma zostać utworzona
   * @param args parametry które mają zostać przekazane do konstruktora
   * @return nowa instancja klasy podanej jako parametr zainicjalizowana podanymi parametrami
   * @throws Exception wyjątek spowodowany nie znalezieniem odpowiedniego konstruktora
   */
  public static <T> T createInstance(final Class<T> type, final Object... args) throws Exception {
    //TODO usuń zawartość tej metody i umieść tutaj swoje rozwiązanie
    Constructor<?>[] constructors = type.getDeclaredConstructors();
    for (Constructor<?> constructor : constructors) {
      Class<?>[] parameterTypes = constructor.getParameterTypes();
      if (parameterTypes.length == args.length) {
        boolean match = true;
        for (int i = 0; i < parameterTypes.length; i++) {
          if (!parameterTypes[i].isInstance(args[i])) {
            match = false;
            break;
          }
        }
        if (match) {
          constructor.setAccessible(true);
          return type.cast(constructor.newInstance(args));
        }
      }
    }
    throw new Exception("No matching constructor found");
  }
}
