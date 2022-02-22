package learn.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueApplication {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        QueueApplication queueApplication = new QueueApplication();
        //queueApplication.printQueue(queue);

        queueApplication.reverseAQueue(queue);
        //System.out.println();
        queueApplication.printQueue(queue);

        System.out.println("\nFirst n combinations ");
        queueApplication.printFirstN(6);
    }

    public void printQueue(Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }

    public void reverseAQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return;
        }
        int num = queue.peek();
        queue.remove();
        reverseAQueue(queue);
        queue.add(num);
    }

    public void printFirstN(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.add("5");
        queue.add("6");
        for(int i=0; i<n ;i++ ){
            String curr = queue.poll();
            System.out.print(curr+ " ");
            queue.add(curr+ "5");
            queue.add(curr+ "6");
        }
    }
}
