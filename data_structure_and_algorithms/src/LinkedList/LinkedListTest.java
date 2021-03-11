package LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
    private LinkedList<Integer> linkedListOfInteger;
    private LinkedList<String> linkedListOfString;

    @Before
    public void createLinkedList() {
        linkedListOfInteger = new LinkedList<Integer>();
        linkedListOfString = new LinkedList<String>();
    }

    @Test
    public void addNodesAtLastLinkedListOfInteger() throws Exception {
        linkedListOfInteger.addLast(0);
        linkedListOfInteger.addLast(1);
        linkedListOfInteger.addLast(2);
        Assert.assertEquals("[0 -> 1 -> 2]", linkedListOfInteger.toString());
    }

    @Test
    public void addNodesAtFirst() throws Exception {
        linkedListOfInteger.addFirst(3);
        linkedListOfInteger.addFirst(2);
        linkedListOfInteger.addFirst(1);
        linkedListOfInteger.addFirst(0);
        linkedListOfInteger.addLast(4);
        Assert.assertEquals("[0 -> 1 -> 2 -> 3 -> 4]", linkedListOfInteger.toString());
    }

    @Test
    public void deleteFirstNodeOfLinkedList() throws Exception {
        linkedListOfInteger.addFirst(0);
        linkedListOfInteger.addLast(1);
        linkedListOfInteger.addLast(2);
        linkedListOfInteger.addLast(3);
        linkedListOfInteger.deleteFirst();
        linkedListOfInteger.deleteFirst();
        Assert.assertEquals("[2 -> 3]", linkedListOfInteger.toString());
    }

    @Test
    public void deleteLastNodeOfLinkedList() throws Exception {
        linkedListOfInteger.addLast(0);
        linkedListOfInteger.addLast(1);
        linkedListOfInteger.addLast(2);
        linkedListOfInteger.addLast(3);
        linkedListOfInteger.addLast(4);
        linkedListOfInteger.deleteFirst();
        linkedListOfInteger.deleteLast();
        linkedListOfInteger.deleteLast();
        Assert.assertEquals("[1 -> 2]", linkedListOfInteger.toString());
    }

    @Test
    public void containsANodeInLinkedList() throws Exception {
        linkedListOfInteger.addLast(0);
        linkedListOfInteger.addLast(1);
        linkedListOfInteger.addLast(2);
        linkedListOfInteger.deleteFirst();
        linkedListOfInteger.deleteFirst();
        Assert.assertEquals(false, linkedListOfInteger.contains(1));
    }


    @Test
    public void indexOfNodeInLinkedList() throws Exception {
        linkedListOfInteger.addLast(0);
        linkedListOfInteger.addLast(1);
        linkedListOfInteger.addLast(2);
        linkedListOfInteger.addLast(3);
        linkedListOfInteger.deleteLast();
        linkedListOfInteger.deleteFirst();
        Assert.assertEquals(1, linkedListOfInteger.indexOf(2));
    }
    @Test
    public void checkOneOperationForAnotherType() throws Exception {
        linkedListOfString.addLast("a");
        linkedListOfString.addLast("b");
        linkedListOfString.addLast("c");
        Assert.assertEquals("[a -> b -> c]", linkedListOfString.toString());
    }

}
