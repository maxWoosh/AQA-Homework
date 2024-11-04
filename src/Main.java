import java.lang.reflect.Array;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        printThreeWords();
        checkSumSign(2, -3);
        printColor(10);
        compareNumbers(1,2);
        System.out.println(compareSum(20,1));
        printSignOfNumber(1);
        System.out.println(getSignOfNumber(-1));
        printString("Король орел", 3);
        System.out.println(isLeapYear(2012));

        int[] array = {1,1,0,0,1,0,1,1,0,0};
        for (int i =0; i < array.length; i++)
            array[i] = (array[i] == 0)? 1 : 0;

        //for (var a : array)
            //System.out.print(a + " ");
        //System.out.println();

        int[] array2 = new int[100];
        for (int i = 0; i < array2.length; i++)
            array2[i] = i + 1;

        //for (var a : array2)
            //System.out.print(a + " ");
        //System.out.println();

        int[] array3 = {1,5,3,2,11,4,5,2,4,8,9,1};
        for (int i = 0; i < array3.length; i++)
        {
            if (array3[i] < 6)
                array3[i] *= 2;
        }

       // for (var a : array3)
            //System.out.print(a + " ");
        //System.out.println();

        int[][] array4 = new int[5][5];
        for (int i = 0; i < array4.length; i++)
        {
           array4[i][i] = 1;
           array4[i][array4.length - i - 1] = 1;
        }

        //System.out.println(Arrays.deepToString(array4));

        int[] array5 = fillArray(5, 5);

         for (var a : array5)
            System.out.print(a + " ");
        System.out.println();
    }

    public static void printThreeWords()
    {
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign(int a, int b)
    {
        if (a + b >= 0)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");
    }

    public static void printColor(int value)
    {
        if (value <= 0)
            System.out.println("Красный");
        else if (value > 100)
            System.out.println("Зеленый");
        else
            System.out.println("Желтый");
    }

    public static void compareNumbers(int a, int b)
    {
        if (a >= b)
            System.out.println("a >= b");
        else
            System.out.println("a < b");
    }

    public static boolean compareSum(int a, int b)
    {
        return (a + b >= 10 && a + b <=20);
    }

    public static void printSignOfNumber(int number)
    {
        if (number >= 0)
            System.out.println("Число положительное");
        else
            System.out.println("Число отрицательное");
    }

    public static boolean getSignOfNumber(int number)
    {
        return number < 0;
    }

    public static void printString(String string, int count)
    {
        for (int i = 0; i < count; i++)
            System.out.println(string);

    }

    public static boolean  isLeapYear(int numberOfYear)
    {
        return (numberOfYear % 4 == 0 && numberOfYear % 100 != 0 || numberOfYear % 400 == 0);
    }

    public static int[] fillArray(int len, int initialValue)
    {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }


}