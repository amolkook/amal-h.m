//q6
public class CircularDoublyLinkedList<E> {
    private Node<E> head;
    private int size;

    public CircularDoublyLinkedList() {
        head = null;
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

    // CircularDoublyLinkedList methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return head.getPrev().getElement();
    }

    public void addFirst(E element) {
        if (isEmpty()) {
            head = new Node<>(element, null, null);
            head.setPrev(head);
            head.setNext(head);
        } else {
            Node<E> newNode = new Node<>(element, head.getPrev(), head);
            head.getPrev().setNext(newNode);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
    }

    public void addLast(E element) {
        addFirst(element);
        head = head.getNext();
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E removedElement = head.getElement();

        if (size == 1) {
            head = null;
        } else {
            Node<E> tail = head.getPrev();
            head = head.getNext();
            tail.setNext(head);
            head.setPrev(tail);
        }

        size--;
        return removedElement;
    }

    public void rotate() {
        if (!isEmpty()) {
            head = head.getNext();
        }
    }

    public void rotateBackward() {
        if (!isEmpty()) {
            head = head.getPrev();
        }
    }
}