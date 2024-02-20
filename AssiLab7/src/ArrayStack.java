public class ArrayStack<E> implements Cloneable {
    private E[] elements;
    private int size;

    // Constructor and other methods

    @Override
    public ArrayStack<E> clone() {
        try {
            @SuppressWarnings("unchecked")
            ArrayStack<E> clonedStack = (ArrayStack<E>) super.clone();
            clonedStack.elements = elements.clone();
            return clonedStack;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }
}