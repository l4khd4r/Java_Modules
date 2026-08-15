
import java.util.ArrayList;
import java.util.Scanner;


class CharStorage
{
    private int numAppeared;
    private char character;
    private int charts;
    public CharStorage(char character)
    {
        this.character = character;
        this.numAppeared = 1;
    }
    public void incrementAppeared()
    {
        this.numAppeared++;
    }

    public char getCharacter()
    {
        return this.character;
    }
    public int getNumAppeared()
    {
        return this.numAppeared;
    }
    public int getCharts()
    {
        return this.charts;
    }
    public void setCharts(int charts)
    {
        this.charts = charts;
    }
}

public class Program
{
    public static void sortChars(char[] chars)
    {
        for(int i = 0; i < chars.length - 1; i++)
        {
            for(int j = 0; j < chars.length - i - 1; j++)
            {
                if(chars[j] > chars[j + 1])
                {
                    char temp = chars[j];
                    chars[j] = chars[j + 1];
                    chars[j + 1] = temp;
                }
            }
        }
    }
    public static void printCharStorageList(ArrayList<CharStorage> charStorageList)
    {
        for(CharStorage charStorage : charStorageList)
        {
            System.out.println(charStorage.getCharacter() + ": " + charStorage.getNumAppeared());
        }
    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in );
        String input = scanner.nextLine();

        char[] chars = input.toCharArray();
        // Sort the characters in the array
        sortChars(chars);
        ArrayList<CharStorage> charStorageList = new ArrayList<CharStorage>();
        for(char c : chars)
        {
            boolean found = false;
            for(CharStorage charStorage : charStorageList)
            {
                if(charStorage.getCharacter() == c)
                {
                    charStorage.incrementAppeared();
                    found = true;
                    break;
                }
            }
            if(!found)
            {
                charStorageList.add(new CharStorage(c));
            }
        }
        printCharStorageList(charStorageList);
        // get the biggest number of appearances
        int maxAppeared = 0;
        for(CharStorage charStorage : charStorageList)
        {
            if(charStorage.getNumAppeared() > maxAppeared)
            {
                maxAppeared = charStorage.getNumAppeared();
            }
        }
        for(CharStorage charStorage : charStorageList)
        {
            charStorage.setCharts((charStorage.getNumAppeared() * 10 ) / maxAppeared );
            System.out.println(charStorage.getCharacter() + ": " + charStorage.getCharts());
        }


        for(CharStorage charStorage : charStorageList)
        {
            System.out.print(charStorage.getCharacter() + " ");
        }
        for(int i = 0 ; i < maxAppeared; i++)
        {
            for(CharStorage charStorage : charStorageList)
            {
                if(charStorage.getCharts() >= maxAppeared - i)
                {
                    System.out.print("# ");
                }
                else
                {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        for(CharStorage charStorage : charStorageList)
        {
            System.out.print(charStorage.getCharacter() + " ");
        }
        // for(CharStorage charStorage : charStorageList)
        // {
        //     int spaces = maxAppeared - charStorage.getCharts();
        //     for(int i = 0; i < spaces; i++)
        //     {
        //         System.out.println(" ");
        //     }
        //     for(int i = 0; i < charStorage.getCharts(); i++)
        //     {
        //         System.out.println("# ");
        //     }
        // }
        // for(CharStorage charStorage : charStorageList)
        // {
        //     System.out.print(charStorage.getCharacter() + " ");
        // }

        System.out.println();

        scanner.close();
    }
}
