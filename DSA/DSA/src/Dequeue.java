import java.util.Arrays;

public class Dequeue {

    private int[] ints;
    private int size;
    private int head;
    private int tail;

    public Dequeue(int capacity) {
        ints = new int[capacity];
        size = 0; head = tail = -1;
    }

    public void enqueueAtTail(int i) {
        if (size == ints.length) {
            System.out.println("This queue is full");
            return;
        }

        if (size == 0) {
            head = tail = 0;
            ints[tail] = i;
        }
        else {
            tail = (tail + 1) % ints.length;
            ints[tail] = i;
        }
        size++;
    }

    public int dequeueAtHead() {
        if (size == 0) {
            System.out.println("This queue is empty");
            return -1;
        }
        else {
            int valToDequeue = head;
            head = (head + 1) % ints.length;
            ints[valToDequeue] = 0;
            size--;
            if(this.isEmpty()) {
                head = tail = -1;
            }
            return ints[valToDequeue];
        }
    }


    /* insertion point -> [1][2][3][0][0],
    * move all the elements one index to the right,
    * keep the head pointing to the first(0) index,
    * move the tail one index to the right (circularly) */
    public void enqueueAtHead(int i) {
        if (size == ints.length) {
            System.out.println("This queue is full");
            return;
        }

        if (size == 0) {
            head = tail = 0;
            ints[head] = i;
        }
        else {
            shiftElements();
            ints[head] = i;
            tail = (tail + 1) % ints.length;
        }
        size++;
    }

    public int dequeueAtTail() {
        if (size == 0) {
            System.out.println("This queue is empty");
            return -1;
        }
        else {
            int valToDequeue = ints[tail];
            ints[tail] = 0;
            size--;
            if (size != 0 && tail == 0) {
                tail = ints.length - 1;
            }
            else if (this.isEmpty()){
                tail = head = -1;
            }
            else {
                tail -= 1;
            }
            return valToDequeue;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int[] shiftElements() {
        int[] temp = new int[ints.length];
        int boundary = (tail - head + ints.length) % ints.length;
        int indexFrom = head;
        for (int i = 0; i <= boundary; i++) {
           temp[(indexFrom+1) % ints.length] = ints[indexFrom];
           indexFrom = (indexFrom + 1) % ints.length;
        }
        ints = temp;
        return ints;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(ints);
    }

    public static void main(String[] args) {
        Dequeue q = new Dequeue(5);
        q.enqueueAtTail(1);
        q.enqueueAtTail(2);
        q.enqueueAtTail(3);
        q.enqueueAtTail(4);
        q.enqueueAtTail(5);
        System.out.println(q);

        q.dequeueAtHead();
        q.dequeueAtHead();
        q.enqueueAtTail(6);
        q.enqueueAtTail(7);
        System.out.println(q);

        q.enqueueAtHead(8);
        System.out.println(q);

    }

}
