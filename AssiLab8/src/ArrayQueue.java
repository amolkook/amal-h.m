public class ArrayQueue<E> implements Cloneable{
    private E[] elements;
    private int front;
    private int size;

    // Constructor and other methods

    public void rotate() {
        if (size <= 1) {
            return;  // No need to rotate if there are 0 or 1 elements
        }

        front = (front + 1) % elements.length;
    }
    @SuppressWarnings("unchecked")
    @Override
    public ArrayQueue<E> clone() {
        try {
            ArrayQueue<E> clonedQueue = (ArrayQueue<E>) super.clone();
            clonedQueue.elements = elements.clone();
            return clonedQueue;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}