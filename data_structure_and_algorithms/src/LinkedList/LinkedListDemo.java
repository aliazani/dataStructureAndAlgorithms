package LinkedList;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        System.out.println("Linked List:");
        showLinkedListDefaultImplementation();
    }

    public static void showLinkedListDefaultImplementation() {
        var linkedList = new LinkedList<Integer>();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addLast(30);
        linkedList.addFirst(0);
        linkedList.remove(0);
        System.out.println(linkedList.contains(10));
        System.out.println(linkedList.indexOf(20));
        System.out.println(linkedList.size());
        System.out.println(Arrays.toString(linkedList.toArray()));
        System.out.println(linkedList);
    }
}
