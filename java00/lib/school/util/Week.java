package java00.lib.school.util;
import java.util.ArrayList;
// max weeks is 18

public class Week
{
    private String week;
    private int weekNumber;
    private ArrayList<Integer> gradeList = new ArrayList<>(5);// every week has 5 grades, grade is between 1 and 9
    public Week()
    {
        this.weekNumber = 0 ;
        this.week = "Week 0";
    }

    public Week(String week, ArrayList<Integer> gradeList)
    {

        this.weekNumber = Integer.parseInt(week.split(" ")[1]);
        this.week = week;
        this.gradeList = gradeList;
    }

    public String getWeek()
    {
        return week;
    }

    public int getWeekNumber()
    {
        return weekNumber;
    }

    public ArrayList<Integer> getGradeList()
    {
        return gradeList;
    }

    public void setWeek(String week)
    {
        this.week = week;
    }

    public void setWeekNumber(int weekNumber)
    {
        this.weekNumber = weekNumber;
    }
}
