


class SumOfDigits {
    void sod() {
        int number = 479598;
        int original = number;
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        System.out.println("Number: " + original);
        System.out.println("Sum of digits: " + sum);
    }
}
public class Program {
    public static void main(String args[])
    {
        SumOfDigits obj = new SumOfDigits();
        obj.sod();
    }
}