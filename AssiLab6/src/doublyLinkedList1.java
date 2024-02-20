public class doublyLinkedList1<E> {
    //q5
    private Node<E> sentinel;
    private int size;

    public doublyLinkedList1() {
        sentinel = new Node<>(null, null, null);
        sentinel.setNext(sentinel);
        sentinel.setPrev(sentinel);
        size = 0;
    }

    // Node class
    private static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    // DoublyLinkedList methods
    // ...

    public Node<E> getSentinel() {
        return sentinel;
    }

    public int size() {
        return size;
    }
}