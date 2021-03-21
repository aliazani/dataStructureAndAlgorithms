package Stack;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        show();
        System.out.println(StringReverser.reverseString("ABCD"));
        Expression exp = new Expression("(a + b]");
        System.out.println(exp.isBalanced());
        // Stack -> push, pop, peek, isEmpty, int[]
    }

    public static void show() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        var top = stack.pop();
        System.out.println(top);
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.empty());
    }

}