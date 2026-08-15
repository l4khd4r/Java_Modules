import java00.lib.school.util.Digit;

public class Program {
    public static void main(String[] args) {
        int value = 479598;
        Digit digit = new Digit(value);
        System.out.println("Number: " + value);
        System.out.println("Sum of digits: " + digit.SumOfDigits());
    }
}
