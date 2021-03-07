package BigONotation;

import java.text.MessageFormat;

public class Main {

    public static void main(String[] args) {
        int[] numbers = new int[10];

        for (int i = 0; i < 10; i++)
            numbers[i] = i;
    }

    // O(1) -> constant time
    public static void printFirstNumber(int[] numbers) {
        System.out.println(numbers[0]);
        System.out.println(numbers[1]);
    }

    // O(n) -> print n numbers -> growth linearly
    public static void printNumbers(int[] numbers) {
        for (var number : numbers)
            System.out.println(number);

    }

    // O(2n) -> O(n)
    public static void printNumbers2(int[] numbers) {
        for (var number : numbers)
            System.out.println(number);

        for (var number : numbers)
            System.out.println(number);
    }

    // O(n+m) -> O(n)
    public static void printNumbersAndString(int[] numbers, String[] strings) {
        for (var number : numbers)
            System.out.println(number);

        for (var str : strings)
            System.out.println(str);
    }

    // o(n^2) -> quadratic
    public static void printFirstAndSecondNumber(int[] numbers) {
        for (var firstNumber : numbers)
            for (var secondNumber : numbers)
                System.out.println(MessageFormat
                        .format("firstNumber={0}, secondNumber={1}", firstNumber, secondNumber));
    }

    // Binary search -> logarithmic
    // Exponential
}