package HashTables;

import java.util.*;

public class HashTableDemo {
    public static void main(String[] args) {
        showHashMap();
        System.out.println(findFirstNonRepeatingCharacter("A Green apple"));
        showSet();
        System.out.println(findFirstRepeatedCharacter("A Green apple"));
        System.out.println(hash("12345-A"));
        String str = "Ali";
        System.out.println("Ali's hashCode: " + str.hashCode());
        showMyHashTable();
        int[] numbers = {1, 2, 3, 3, 3, 1, 2, 4, 5, 4, 3, 9, 3};
        System.out.println(mostFrequent(numbers));
        var res = countPairsWithDiff(new int[]{1, 7, 5, 9, 2, 12, 3}, 2);
        System.out.println(res);
        var res2 = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println(Arrays.toString(res2));
        System.out.println("MyHashMap:");
        showMyHashMap();
    }

    private static void showHashMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "ali");
        map.put(2, "reza");
        map.put(3, "mohammad");
        map.put(1, "mohammadali");
        System.out.println(map);
        System.out.println(map.get(2));
        System.out.println(map.containsValue("reza"));
        System.out.println(map.containsKey(1));
        map.put(null, null);
        System.out.println(map);
        map.remove(null);
        System.out.println(map);
        for (var item : map.entrySet()) {
            System.out.println(item.getKey());
            System.out.println(item.getValue());
        }
    }

    public static void showSet() {
        Set<Integer> set = new HashSet<>();
        int[] numbers = {1, 2, 3, 3, 4, 4, 5, 6, 7, 8, 8};
        for (var num : numbers)
            set.add(num);
        System.out.println(set);
    }

    public static char findFirstNonRepeatingCharacter(String str) {
        Map<Character, Integer> alphabets = new HashMap<>();
        var chars = str.toLowerCase().toCharArray();

        for (var ch : chars) {
            var count = alphabets.getOrDefault(ch, 0);
            alphabets.put(ch, count + 1);
        }

        for (var ch : chars)
            if (alphabets.get(ch) == 1)
                return ch;
        return Character.MIN_VALUE;
    }

    public static int mostFrequent(int[] numbers) {
        Map<Integer, Integer> repeat = new HashMap<>();

        for (var number : numbers) {
            var count = repeat.getOrDefault(number, 0);
            repeat.put(number, count + 1);
        }

        int frequent = 0;
        for (var entry : repeat.entrySet())
            if (entry.getValue() > frequent)
                frequent = entry.getKey();

        return frequent;
    }

    public static char findFirstRepeatedCharacter(String str) {
        Set<Character> alphabets = new HashSet<>();
        var chars = str.toLowerCase().toCharArray();

        for (var ch : chars) {
            if (alphabets.contains(ch))
                return ch;
            alphabets.add(ch);
        }
        return Character.MIN_VALUE;
    }

    public static int hash(String key) {
        int hashValue = 0;
        for (var ch : key.toCharArray())
            hashValue += ch;
        return hashValue % 100;
    }

    public static void showMyHashTable() {
        HashTable<Integer, String> table = new HashTable<>(5);
        table.put(6, "A");
        table.put(6, "A+");
        table.put(8, "B");
        table.put(11, "C");
        System.out.println(table);
        System.out.println(table.get(6));
        table.remove(6);
        System.out.println(table);
        table.remove(8);
        System.out.println(table);
        table.put(8, "ali");
        System.out.println(table);
        table.put(13, "ali+");
        System.out.println(table);
    }

    public static int countPairsWithDiff(int[] numbers, int difference) {
        int count = 0;
        Arrays.sort(numbers);

        for (var num : numbers)
            if (Arrays.binarySearch(numbers, num - difference) >= 0)
                count++;

        return count;
    }

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++)
            for (int j = 0; j < numbers.length; j++)
                if (numbers[i] + numbers[j] == target)
                    return new int[]{i, j};

        return null;

    }

    public static void showMyHashMap(){
        MyHashMap<Integer, String> map = new MyHashMap<>(5);
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "B");
        map.put(4, "D");
        map.put(5, "E");
        System.out.println(map);
        map.put(1, "Mohammadali");
        System.out.println(map);
        map.remove(5);
        System.out.println(map);
        map.put(8, "S");
        System.out.println(map);
        System.out.println(map.get(8));
        System.out.println(map.size());

    }
}
