package Stack;

import java.util.Stack;

public class StringReverser {
    public static String reverseString(String str) {
        Stack<Character> stringStack = new Stack<>();
        StringBuffer reversed = new StringBuffer();

//        for (int i = 0; i < str.length(); i++)
//            stringStack.push(str.charAt(i));
        for (char ch : str.toCharArray())
            stringStack.push(ch);

//        for (int i = 0; i < str.length(); i++)
//            reversed += stringStack.pop();
        while (!stringStack.empty())
            reversed.append(stringStack.pop());

        return reversed.toString();
    }
}
