import java.util.ArrayList;
import java.util.Scanner;

import java00.lib.school.util.Week;

public class Program
{
    private static final int MAX_WEEKS      = 18;
    private static final int TESTS_PER_WEEK = 5;

    private ArrayList<Week> weekList = new ArrayList<>(MAX_WEEKS);

    public boolean isValidGrade(int grade)
    {
        return grade >= 1 && grade <= 9;
    }

    public boolean isValidWeekNumber(int weekNumber)
    {
        return weekNumber >= 1 && weekNumber <= MAX_WEEKS;
    }

    public boolean isNotRepeatedWeekNumber(int weekNumber)
    {
        for(Week week : weekList)
        {
            if(week.getWeekNumber() == weekNumber)
                return false;
        }
        return true;
    }

    /** Returns -1 when the token is not a number, so every range check below rejects it. */
    private static int parseInt(String token)
    {
        try
        {
            return Integer.parseInt(token);
        }
        catch(NumberFormatException e)
        {
            return -1;
        }
    }

    /** Handles a "Week N" line. */
    public boolean readHeader(String[] parts)
    {
        if(parts.length != 2 || !parts[0].equals("Week"))
            return false;

        int weekNumber = parseInt(parts[1]);
        if(!isValidWeekNumber(weekNumber))
            return false;
        if(!isNotRepeatedWeekNumber(weekNumber))
            return false;
        // The Nth week entered must be week N, otherwise the order is wrong.
        if(weekNumber != weekList.size() + 1)
            return false;

        weekList.add(new Week("Week " + weekNumber, new ArrayList<>()));
        return true;
    }

    /** Handles a "g g g g g" line, filling the week opened by the previous header. */
    public boolean readGrades(String[] parts)
    {
        if(weekList.isEmpty())
            return false;

        Week current = weekList.get(weekList.size() - 1);
        if(!current.getGradeList().isEmpty())
            return false;
        if(parts.length != TESTS_PER_WEEK)
            return false;

        for(String part : parts)
        {
            int grade = parseInt(part);
            if(!isValidGrade(grade))
                return false;
            current.getGradeList().add(grade);
        }
        return true;
    }

    public int minGrade(Week week)
    {
        int min = 9;
        for(int grade : week.getGradeList())
        {
            if(grade < min)
                min = grade;
        }
        return min;
    }

    /** Built in one StringBuilder so there is no concatenation inside the loop. */
    public void printChart()
    {
        StringBuilder chart = new StringBuilder();
        for(Week week : weekList)
        {
            if(week.getGradeList().size() != TESTS_PER_WEEK)
                continue;
            chart.append(week.getWeek()).append(' ');
            int min = minGrade(week);
            for(int i = 0; i < min; i++)
                chart.append('=');
            chart.append('>').append(System.lineSeparator());
        }
        System.out.print(chart);
    }

    private static void fail(Scanner scanner)
    {
        System.err.println("IllegalArgument");
        scanner.close();
        System.exit(-1);
    }

    public static void main(String[] args)
    {
        Program program = new Program();
        Scanner scanner = new Scanner(System.in);
        boolean expectHeader = true;

        while(true)
        {
            if(expectHeader && program.weekList.size() == MAX_WEEKS)
                break;

            System.out.print("->");
            if(!scanner.hasNextLine())
                break;

            String input = scanner.nextLine().trim();
            if(input.equals("42"))
                break;

            String[] parts = input.split("\\s+");
            boolean ok = expectHeader ? program.readHeader(parts) : program.readGrades(parts);
            if(!ok)
                fail(scanner);

            expectHeader = !expectHeader;
        }

        scanner.close();
        System.out.println();
        program.printChart();
    }
}
