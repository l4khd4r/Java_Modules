package java00.lib.school.util;

public class Prime
{
    private int niters ;
    private int number ;

    public Prime(int number)
    {
        this.number = number ;
        this.niters = 0 ;
    }

    public boolean isPrime()
    {
        if(number <= 1)
            return false;

        int sqrt = (int)Math.sqrt(number);
        for(int i = 2 ; i <= sqrt ; ++i)
        {
            ++niters ;
            if(number % i == 0)
                return false;
        }
        return true;
    }

    public int getNiters()
    {
        return niters ;
    }
}
