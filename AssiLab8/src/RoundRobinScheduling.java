import java.util.LinkedList;
import java.util.Queue;

public class RoundRobinScheduling {
    public static void schedule(Queue<String> readyQueue, int timeQuantum) {
        while (!readyQueue.isEmpty()) {
            String process = readyQueue.poll(); // Dequeue the process from the front of the ready queue

            // Execute the process for the time quantum
            System.out.println("Executing process: " + process);
            // Simulate process execution by delaying for a fixed time period
            try {
                Thread.sleep(timeQuantum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Check if the process has completed within the time quantum
            if (Math.random() > 0.5) {
                System.out.println("Process " + process + " completed.");
            } else {
                System.out.println("Process " + process + " did not complete within the time quantum.");
                readyQueue.offer(process); // Enqueue the process back into the ready queue
            }
        }
    }

    public static void main(String[] args) {
        Queue<String> readyQueue = new LinkedList<>();
        readyQueue.offer("Process A");
        readyQueue.offer("Process B");
        readyQueue.offer("Process C");
        readyQueue.offer("Process D");

        int timeQuantum = 100; // Time quantum in milliseconds

        schedule(readyQueue, timeQuantum);
    }
}