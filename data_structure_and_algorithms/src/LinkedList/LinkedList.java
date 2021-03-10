package LinkedList;

public class LinkedList<N> {

    private Node<N> first;
    private Node<N> last;
    private int index;

    public LinkedList() {
        first = null;
        last = null;
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
        last.next = node;
        last = node;
    }

    private void insertNewNodeAtTheBeginning(Node<N> node) {
        node.next = first;
        first = node;
    }

    public void deleteFirst() {
        first = first.next;
    }

    public void deleteLast() {
        var current = first;

        while (current != null) {
            if (current.next == last)
                replaceTheLastNode(current);
            current = current.next;
        }
    }

    private void replaceTheLastNode(Node<N> current) {
        last = current;
        last.next = null;
    }

    public int indexOf(N item) {
        var current = first;

        while (current != null) {
            if (current.value == item)
                return index;
            index++;
            current = current.next;
        }
        return -1;
    }

    public boolean contains(N item) {
        return indexOf(item) != -1;
    }

    @Override
    public String toString() {
        var stringFormOfLinkedList = "[";
        var current = first;

        while (current.next != null) {
            stringFormOfLinkedList += current.value + " -> ";
            current = current.next;
        }
        stringFormOfLinkedList += current.value + "]";
        return stringFormOfLinkedList;
    }

    static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

}