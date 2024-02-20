import java.util.LinkedList;
import java.util.Queue;

public class JosephusProblem {
    public static int josephus(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        // Enqueue all people into the queue
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            // Skip k-1 people
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.remove());
            }

            // Dequeue and eliminate the k-th person
            queue.remove();
        }

        // Return the last remaining person
        return queue.peek();
    }

    public static void main(String[] args) {
        int n = 7; // Number of people
        int k = 3; // Skip k-1 people in the elimination process

        int lastPerson = josephus(n, k);
        System.out.println("The last person remaining is: " + lastPerson);
    }
}