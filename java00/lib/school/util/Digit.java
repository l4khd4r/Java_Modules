package java00.lib.school.util;

public class Digit {
    private final int number;

    public Digit(int number) {
        this.number = number;
    }

    public int getDigit(int index) {
        String str = String.valueOf(Math.abs(number));
        if (index < 0 || index >= str.length()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return Character.getNumericValue(str.charAt(index));
    }

    public int numberOfDigits() {
        String str = String.valueOf(Math.abs(number));
        return str.length();
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    public int SumOfDigits()
    {
        int sum = 0;
        for(int i =  0 ; i < numberOfDigits(); ++i)
            sum += getDigit(i);
        return sum ;
    }
}
