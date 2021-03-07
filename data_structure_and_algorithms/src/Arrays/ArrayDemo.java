package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        var numbers1 = new Array<Integer>(3);
        var numbers2 = new Array<Integer>(2);
        numbers1.insert(1);
        numbers1.insert(2);
        numbers1.insert(3);
        numbers1.insert(4);

        numbers2.insert(1);
        numbers2.insert(2);
        System.out.println(numbers1);
        System.out.println(numbers2.intersect(numbers1));
        System.out.println(numbers1.max());
        numbers1.removeAt(2);
        System.out.println(numbers1);

    }

    public void show() {

        // Arrays in java
        int[] numbers = new int[10];
        numbers[9] = 10;
        System.out.println("Array: " + Arrays.toString(numbers));
        System.out.println("Array length: " + numbers.length);
    }

    public void showJavaImplementationOfArray() {
        var doubleArrayList = new ArrayList<Double>();
        doubleArrayList.add(1d);
        doubleArrayList.add(2d);
        doubleArrayList.add(3d);
        doubleArrayList.remove(0);
        System.out.println(doubleArrayList);
        System.out.println(doubleArrayList.size());
        System.out.println(doubleArrayList);
        System.out.println(doubleArrayList.lastIndexOf(2d));
    }
}
