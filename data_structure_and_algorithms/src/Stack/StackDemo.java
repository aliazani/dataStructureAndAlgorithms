package Stack;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        show();
        System.out.println(StringReverser.reverseString("ABCD"));
        Expression exp = new Expression("(a + b]");
        System.out.println(exp.isBalanced());

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<Integer>();
        System.out.println("Array:");
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        System.out.println(arrayStack.minimum());
        System.out.println(arrayStack);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack);
        System.out.println(arrayStack.peek());
        System.out.println(arrayStack);
        System.out.println(arrayStack.isEmpty());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack);


        System.out.println("LinkedList:");
        linkedListStack.push(1);
        linkedListStack.push(2);
        linkedListStack.push(3);
        System.out.println(linkedListStack);
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack);
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack);
        System.out.println(linkedListStack.peek());
        System.out.println(linkedListStack);
        System.out.println(linkedListStack.isEmpty());
        System.out.println(linkedListStack.pop());
        System.out.println(linkedListStack);
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