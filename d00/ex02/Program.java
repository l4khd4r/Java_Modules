import java.util.Scanner;

class ReallyPrimeNumber {
    private  int prime;

    Boolean isPrime() {
        int limit = prime / 2;
        limit++;
        for (int i = 2; i < limit; i++) {
            if (prime % i == 0)
                return false;
        }
        return true;
    }

    void run() {
        Scanner obj = new Scanner(System.in);
        prime = obj.nextInt();

        if (prime < 0) {
            throw new IllegalArgumentException("Number must not be negative");
        }

        if (isPrime()) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        obj.close();
    }
    
}

public class Program {
    public static void main(String args[]) {
        ReallyPrimeNumber obj = new ReallyPrimeNumber();
        try {
            obj.run();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}