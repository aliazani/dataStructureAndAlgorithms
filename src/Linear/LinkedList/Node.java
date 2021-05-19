package Linear.LinkedList;

class Node<N> {
    private final N value;
    private Node<N> next;

    public Node(N value) {
        this.value = value;
    }

    public N getValue() {
        return value;
    }

    public Node<N> getNext() {
        return next;
    }

    public void setNext(Node<N> next) {
        this.next = next;
    }
}
