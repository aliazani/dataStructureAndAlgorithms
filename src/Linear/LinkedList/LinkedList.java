package Linear.LinkedList;

import Linear.Arrays.*;

import java.text.MessageFormat;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<N extends Comparable<N>> implements Iterable<Node<N>> {

    private Node<N> first;
    private Node<N> last;
    private Node<N> current;
    private int count;

    public LinkedList() {
        first = null;
        last = null;
        current = null;
        count = 0;
    }

    public void createWithLoop() {
        current = first;
        while (current != last)
            current = current.getNext();
        current.setNext(first);
    }

    public void addLast(N item) {
        var node = new Node<>(item);

        if (isLinkedListEmpty())
            insertNewNodeToEmptyLinkedList(node);
        else
            insertNewNodeAtTheEnd(node);
        count++;
    }

    public void addFirst(N item) {
        var node = new Node<>(item);

        if (isLinkedListEmpty())
            insertNewNodeToEmptyLinkedList(node);
        else
            insertNewNodeAtTheBeginning(node);
        count++;
    }

    private boolean isLinkedListEmpty() {
        return first == null;
    }

    private void insertNewNodeToEmptyLinkedList(Node<N> node) {
        first = last = node;
    }

    private void insertNewNodeAtTheEnd(Node<N> node) {
        last.setNext(node);
        last = node;
    }

    private void insertNewNodeAtTheBeginning(Node<N> node) {
        node.setNext(first);
        first = node;
    }

    public void deleteFirst() {
        if (isLinkedListEmpty())
            throw new NoSuchElementException();
        else if (linkedListHasOneItem())
            first = last = null;
        else {
            replaceFirstNodeWithSecondNode();
        }
        count--;
    }

    private void replaceFirstNodeWithSecondNode() {
        var second = first.getNext();
        first.setNext(null);
        first = second;
    }

    public void deleteLast() {
        if (isLinkedListEmpty())
            throw new NoSuchElementException();
        else if (linkedListHasOneItem())
            first = last = null;
        else {
            var node = getPrevious(last);
            replaceTheLastNodeWithPrevious(node);
        }
        count--;
    }

    private boolean linkedListHasOneItem() {
        return first == last;
    }

    private Node<N> getPrevious(Node<N> node) {
        for (var eachNode : this)
            if (eachNode.getNext() == node)
                return eachNode;

        return null;
    }


    private void replaceTheLastNodeWithPrevious(Node<N> previous) {
        last = previous;
        last.setNext(null);
    }

    public int indexOf(N item) {
        int index = 0;
        for (var node : this) {
            if (current.getValue() == item)
                return index;
            index++;
        }
        return -1;
    }

    public boolean contains(N item) {
        return indexOf(item) != -1;
    }

    public int size() {
        return count;
    }

    public Array<N> toArray() {
        Array<N> array = new Array<N>(count);

        for (var node : this)
            array.insert(node.getValue());
        return array;
    }

    public void reverse() {
        if (isLinkedListEmpty()) return;

        var previous = first;
        var current = first.getNext();
        while (current != null) {
            var next = current.getNext();
            current.setNext(previous);

            previous = current;
            current = next;
        }
        swapFirstAndLast(previous);
    }

    private void swapFirstAndLast(Node<N> previous) {
        last = first;
        last.setNext(null);
        first = previous;
    }

    public N getKthFromTheEnd(int k) {
        if (isLinkedListEmpty()) throw new IllegalArgumentException();

        if (k > count) throw new IllegalArgumentException();

        var firstNode = first;
        var secondNode = first;

        secondNode = createDistanceFromFirst(k, secondNode);
        while (secondNode != last) {
            firstNode = firstNode.getNext();
            secondNode = secondNode.getNext();
        }
        return firstNode.getValue();
    }

    private Node<N> createDistanceFromFirst(int k, Node<N> secondNode) {
        for (int n = 0; n < k - 1; n++)
            secondNode = secondNode.getNext();
        return secondNode;
    }

    public String getMiddle() {
        if (isLinkedListEmpty()) throw new IllegalArgumentException();

        var middle = first;
        var end = first;

        while (isNotAtTheEndOfTheList(end)) {
            middle = middle.getNext();
            end = end.getNext().getNext();
        }

        if (isNumberOfNodeOdd(end))
            return MessageFormat.format("Middle = {0}", middle.getValue());
        else
            return MessageFormat.format("Middle = {0}, {1}", middle.getValue(), middle.getNext().getValue());
    }

    private boolean isNotAtTheEndOfTheList(Node<N> end) {
        return end != last && end.getNext() != last;
    }

    private boolean isNumberOfNodeOdd(Node<N> end) {
        return end == last;
    }

    public boolean hasLoop() {
        Node<N> slow = first;
        Node<N> fast = first;

        while (slow != null && fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast)
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        var stringFormOfLinkedList = new StringBuilder("[");

        if (!isLinkedListEmpty()) {
            appendNodes(stringFormOfLinkedList);
        }
        stringFormOfLinkedList.append("]");
        return stringFormOfLinkedList.toString();
    }

    private void appendNodes(StringBuilder stringFormOfLinkedList) {
        for (var node : this)
            if (node.getNext() != null)
                stringFormOfLinkedList.append(node.getValue()).append(" -> ");

        stringFormOfLinkedList.append(last.getValue());
    }

    @Override
    public Iterator<Node<N>> iterator() {
        current = this.first;
        return new LinkedListIterator<N>(this);
    }

    private class LinkedListIterator<N extends Comparable<N>> implements Iterator<Node<N>> {
        private LinkedList linkedList;
        private int numberOfCallGetNext = 0;

        private LinkedListIterator(LinkedList<N> linkedList) {
            this.linkedList = linkedList;
        }

        @Override
        public boolean hasNext() {
            return (current.getNext() != null);
        }

        @Override
        public Node<N> next() {
            current = first; // Point to the first Node

            for (int j = 0; j < numberOfCallGetNext; j++) // First the loop will not run to return 0th Node after that 1 time , 2 time, ...
                current = current.getNext();
            numberOfCallGetNext++;
            return (Node<N>) current;
        }
    }
}