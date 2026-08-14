

import java.util.Scanner;
import school.util.Prime;

public class Program
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("->");
        int value = scanner.nextInt();
        System.out.println("Value: " + value);
        Prime prime = new Prime(value);
        if(prime.isPrime())
            System.out.println("true " + prime.getNiters());
        else
            System.out.println("false " + prime.getNiters());

        scanner.close();
    }
}