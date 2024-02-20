//q3
public class LinkedQueue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    // Constructor and other methods
    public boolean isEmpty() {
        return size == 0;
    }
    public void concatenate(LinkedQueue<E> Q2) {
        if (Q2.isEmpty()) {
            return; // No need to concatenate if Q2 is empty
        }

        if (isEmpty()) {
            front = Q2.front;
        } else {
            rear.next = Q2.front;
        }

        rear = Q2.rear;
        size += Q2.size;

        Q2.front = null;
        Q2.rear = null;
        Q2.size = 0;
    }

    // Other methods for enqueue, dequeue, etc.

    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}