package LinkedList;

import java.util.Iterator;

public class LinkedList<N> implements Iterable<Node<N>> {

    private Node<N> first;
    private Node<N> last;
    private Node<N> current;
    private int index;

    public LinkedList() {
        first = null;
        last = null;
        current = null;
        index = 0;
    }

    public void addLast(N item) {
        var node = new Node<>(item);

        if (isLinkedListEmpty())
            insertNewNodeToEmptyLinkedList(node);
        else
            insertNewNodeAtTheEnd(node);
    }

    public void addFirst(N item) {
        var node = new Node<>(item);

        if (isLinkedListEmpty())
            insertNewNodeToEmptyLinkedList(node);
        else
            insertNewNodeAtTheBeginning(node);
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
        first = first.getNext();
    }

    public void deleteLast() {
        for (var node : this)
            if (node.getNext().getNext() == null)
                replaceTheLastNode(node);
    }

    private void replaceTheLastNode(Node<N> current) {
        last = current;
        last.setNext(null);
    }

    public int indexOf(N item) {
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

    @Override
    public String toString() {
        var stringFormOfLinkedList = new StringBuilder("[");

        for (var node : this)
            if (node.getNext() != null)
                stringFormOfLinkedList.append(node.getValue()).append(" -> ");

        stringFormOfLinkedList.append(last.getValue()).append("]");

        return stringFormOfLinkedList.toString();
    }

    @Override
    public Iterator<Node<N>> iterator() {
        current = this.first;
        return new LinkedListIterator<N>(this);
    }

    private class LinkedListIterator<N> implements Iterator<Node<N>> {

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