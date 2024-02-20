public class CircularlyLinkedList<E> {
    //q6
    public CircularlyLinkedList<E> clone() {
        CircularlyLinkedList<E> clonedList = new CircularlyLinkedList<>();

        if (size > 0) {
            Node<E> current = tail.getNext();
            Node<E> clonedNode = new Node<>(current.getElement(), null);

            clonedList.tail = clonedNode;

            Node<E> clonedCurrent = clonedNode;

            while (current.getNext() != tail.getNext()) {
                current = current.getNext();
                clonedNode = new Node<>(current.getElement(), null);
                clonedCurrent.setNext(clonedNode);
                clonedCurrent = clonedNode;
            }

            clonedCurrent.setNext(clonedList.tail);
        }

        clonedList.size = size;

        return clonedList;
    }
    //q5
    public void splitCircularList(CircularlyLinkedList<E> list) {
        Node<E> slow = list.tail.getNext();
        Node<E> fast = list.tail.getNext();

        while (fast.getNext() != list.tail && fast.getNext().getNext() != list.tail) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        CircularlyLinkedList<E> list1 = new CircularlyLinkedList<>();
        CircularlyLinkedList<E> list2 = new CircularlyLinkedList<>();

        list1.tail = slow;
        list2.head = slow.getNext();
        list2.tail = list.tail;

        list.tail.setNext(list1.tail.getNext());
        list2.tail.setNext(list2.head);

        list1.size = list.size / 2;
        list2.size = list.size / 2;

        list.size = 0;
        list.head = null;
        list.tail = null;
    }
    //q4
    public boolean sameSequence(CircularlyLinkedList<E> listL, CircularlyLinkedList<E> listM) {
        if (listL.isEmpty() && listM.isEmpty()) {
            return true;
        }

        Node<E> startL = listL.tail.getNext();
        Node<E> startM = listM.tail.getNext();

        Node<E> currentL = startL;
        Node<E> currentM;

        do {
            currentM = startM;

            while (!currentL.getElement().equals(currentM.getElement())) {
                currentM = currentM.getNext();

                if (currentM == startM) {
                    return false;
                }
            }

            currentL = currentL.getNext();
            startM = currentM.getNext();
        } while (currentL != startL);

        return true;
    }
    //q3
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CircularlyLinkedList<?> otherList = (CircularlyLinkedList<?>) obj;
        if (size != otherList.size) {
            return false;
        }
        Node<E> currentThis = tail.getNext();
        Node<?> currentOther = otherList.tail.getNext();
        for (int i = 0; i < size; i++) {
            if (!currentThis.getElement().equals(currentOther.getElement())) {
                return false;
            }
            currentThis = currentThis.getNext();
            currentOther = currentOther.getNext();
        }
        return true;
    }
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }
             // instance variables of the CircularlyLinkedList
             private Node<E> tail = null; // we store tail (but not head)
 private int size = 0; // number of nodes in the list
    //q2
//    public int size() {
//       int count = 0;
//       Node<E> current = tail;
//
//       if (current != null) {
//           do {
//              count++;
//               current = current.getNext();
//         } while (current != tail);
//     }
//
//     return count;
// }
 public CircularlyLinkedList( ) { } // constructs an initially empty list
 // access methods
         public int size( ) { return size; }
 public boolean isEmpty( ) { return size == 0; }
 public E first( ) { // returns (but does not remove) the first element
         if (isEmpty( )) return null;
         return tail.getNext( ).getElement( ); // the head is *after* the tail
         }
public E last( ) { // returns (but does not remove) the last element
         if (isEmpty( )) return null;
         return tail.getElement( );
         }
// update methods
         public void rotate( ) { // rotate the first element to the back of the list
         if (tail != null) // if empty, do nothing
             tail = tail.getNext( ); // the old head becomes the new tail
         }
         //q1
    public void addFirst(E e) { // adds element e to the front of the list
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail); // link to itself circularly
        } else {
            tail.setNext(new Node<>(e, tail.getNext()));
            tail = tail.getNext();
        }
        size++;
    }
 public void addLast(E e) { // adds element e to the end of the list
         addFirst(e); // insert new element at front of list
         tail = tail.getNext( ); // now new element becomes the tail
         }
 public E removeFirst( ) { // removes and returns the first element
         if (isEmpty( )) return null; // nothing to remove
         Node<E> head = tail.getNext( );
         if (head == tail) tail = null; // must be the only node left
         else tail.setNext(head.getNext( )); // removes ”head” from the list
         size--;
         return head.getElement( );
         }
}

