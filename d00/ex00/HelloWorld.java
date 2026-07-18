import java.util.Arrays;

public class HelloWorld {
    public static void main(String[] args) {
        Arrays.stream(args)
              .map(String::toUpperCase)
              .forEach(System.out::println);
    }
}