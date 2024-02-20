public class DoublyLinkedList<E> {
    //q7
    public DoublyLinkedList<E> clone() {
        DoublyLinkedList<E> clonedList = new DoublyLinkedList<>();

        Node<E> current = header.getNext();
        while (current != trailer) {
            clonedList.addLast(current.getElement());
            current = current.getNext();
        }

        return clonedList;
    }
    //q1
    public Node<E> findMiddleNode(DoublyLinkedList<E> list) {
        Node<E> slow = list.getHeader().getNext();
        Node<E> fast = list.getHeader().getNext();

        while (fast != list.getTrailer() && fast.getNext() != list.getTrailer()) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }
    //q2
    public int size() {
        int count = 0;
        Node<E> current = header.getNext();

        while (current != trailer) {
            count++;
            current = current.getNext();
        }

        return count;
    }
    //q3
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        DoublyLinkedList<?> otherList = (DoublyLinkedList<?>) obj;

        if (size() != otherList.size()) {
            return false;
        }

        Node<E> currentNode = header.getNext();
        Node<?> otherNode = otherList.getHeader().getNext();

        while (currentNode != trailer) {
            if (!currentNode.getElement().equals(otherNode.getElement())) {
                return false;
            }

            currentNode = currentNode.getNext();
            otherNode = otherNode.getNext();
        }

        return true;
    }
    //4
    public DoublyLinkedList<E> concatenateLists(DoublyLinkedList<E> L, DoublyLinkedList<E> M) {
        DoublyLinkedList<E> concatenatedList = new DoublyLinkedList<>();

        concatenatedList.setheader(L.getHeader());
        concatenatedList.settrailer(M.getTrailer());

        L.getTrailer().setNext(M.getHeader());
        M.getHeader().setPrev(L.getTrailer());

        concatenatedList.setSize(L.size() + M.size());

        return concatenatedList;
    }
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element, trailer.getPrev(), trailer);
        trailer.getPrev().setNext(newNode);
        trailer.setPrev(newNode);
        size++;
    }

    private void setheader(Node<E> header) {
    }

    private void settrailer(Node<E> trailer) {
    }

    private void setSize(int i) {
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
       // size = 0;
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

    public Node<E> getHeader() {
        return header;
    }

    public Node<E> getTrailer() {
        return trailer;
    }
}