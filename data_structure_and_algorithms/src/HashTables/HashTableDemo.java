package HashTables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
        HashTable<Integer, String> table = new HashTable<>(4);
        table.put(1, "ali");
        table.put(1, "reza");
        table.put(2, "mohammad");
        table.put(3, "maryam");
        System.out.println(table);
    }
}
