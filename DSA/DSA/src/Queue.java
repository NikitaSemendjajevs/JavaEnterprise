import java.util.ArrayList;
import java.util.Arrays;

public class Queue {

    private int[] ints;
    private int size;
    private int head;
    private int tail;

    public Queue(int capacity) {
        ints = new int[capacity];
        size = 0; head = -1; tail = -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int i) {
        if (size == ints.length) {
            System.out.println("This queue is full.");
        }

        if (size == 0) {
            head = 0;
            tail = 0;
            ints[tail] = i;
        } else {
            tail = (tail + 1) % ints.length;
            ints[tail] = i;
        }

        size++;
    }

    public int dequeue() {
        if (size == 0) {
            return -1;
        }
        else {
            int val = ints[head];
            ints[head] = 0;
            head = (head + 1) % ints.length;
            size--;
            return val;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(ints);
    }

    public static void main(String[] args) {
        Queue queue = new Queue(5);
    }

}
