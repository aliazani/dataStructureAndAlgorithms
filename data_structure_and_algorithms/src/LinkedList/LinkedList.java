package LinkedList;

import Arrays.Array;

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