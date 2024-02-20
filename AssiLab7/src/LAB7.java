import java.util.Stack;

public class LAB7 {
    //q1
    public static <E> void transfer(Stack<E> S, Stack<E> T) {
        Stack<E> tempStack = new Stack<>();

        while (!S.isEmpty()) {
            tempStack.push(S.pop());
        }

        while (!tempStack.isEmpty()) {
            T.push(tempStack.pop());
        }
    }
    //q2
    public static <E> void removeAllElements(Stack<E> stack) {
        if (!stack.isEmpty()) {
            stack.pop();
            removeAllElements(stack);
        }
    }
}
