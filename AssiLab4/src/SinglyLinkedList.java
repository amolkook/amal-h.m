//q1
public class SinglyLinkedList<T> {
    private Node<T> head;

    // ... other methods of the SinglyLinkedList class ...


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SinglyLinkedList<?> otherList = (SinglyLinkedList<?>) obj;
        Node<T> currentNode = this.head;
        Node<?> otherNode = otherList.head;
        while (currentNode != null && otherNode != null) {
            if (!currentNode.data.equals(otherNode.data)) {
                return false;
            }
            currentNode = currentNode.next;
            otherNode = otherNode.next;
        }
        return currentNode == null && otherNode == null;
    }
    //q3
    public int size() {
        int count = 0;
        Node<T> currentNode = head;

        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }

        return count;
    }
    //q4
    public void rotate() {
        if (head == null || head.next == null) {
            return; // No need to rotate for empty or single-node list
        }

        Node<T> temp = head;
        head = head.next;
        Node<T> current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = temp;
        temp.next = null;
    }
//q6
public void reverse() {
    if (head == null || head.next == null) {
        return; // No need to reverse for empty or single-node list
    }

    Node<T> previous = null;
    Node<T> current = head;
    Node<T> next = null;

    while (current != null) {
        next = current.next;
        current.next = previous;
        previous = current;
        current = next;
    }

    head = previous;
}
    private static class Node<T> {
        public T value;
        private T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    //q2
    public Node<T> findSecondToLastNode() {
        if (head == null || head.next == null) {
            return null; // Handle edge cases with less than 2 nodes
        }

        Node<T> current = head;
        Node<T> previous = null;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        return previous;
    }

    //q5
    public SinglyLinkedList<T> concatenate(SinglyLinkedList<T> L, SinglyLinkedList<T> M) {
        if (L == null) {
            return M;
        } else if (M == null) {
            return L;
        }

        SinglyLinkedList<T> concatenatedList = new SinglyLinkedList<>();
        Node<T> current = L.head;
        Node<T> tail = null;

        while (current != null) {
            Node<T> newNode = new Node<>(current.value);
            if (tail == null) {
                concatenatedList.head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            current = current.next;
        }

        tail.next = M.head;

        return concatenatedList;
    }
}

