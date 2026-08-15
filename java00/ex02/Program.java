import java.util.Scanner;

import java00.lib.school.util.Digit;
import java00.lib.school.util.Prime;
class Google
{
    private int coffee_preps ;
    private int query_ ;

    public int getCoffee_preps()
    {
        return coffee_preps;
    }

    public Google()
    {
        System.out.println("Google constructor called");
    }

    public int getQuery()
    {
        return query_;
    }

    public void readQuery(int query) {
        this.query_ = query;
        Digit digit  = new Digit(query);
        Prime prime = new Prime(digit.SumOfDigits());
        if(prime.isPrime())
            coffee_preps++;
    }
}

public class Program {
    static void main(String[] args)
    {
        System.out.println("Program started");
        Google google = new Google();
        Scanner scanner = new Scanner(System.in);
        int query ;
        while(true)
        {
            System.out.print("->");
            query = scanner.nextInt();
            google.readQuery(query);

            if(google.getQuery() == 42)
            {
                System.out.println("Program finished");
                break;
            }
        }
        System.out.println("Coffee preparations: " + google.getCoffee_preps());

        scanner.close();
    }
}
