package CoffeeShop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CoffeeOrderBoard implements Iterable<Order> {

    private static int orderNumber;
    private final ArrayList<Order> orders;
    private int N; // current number of orders

    public CoffeeOrderBoard() {
        orders = new ArrayList<>();
        orderNumber = N = 0;
    }

    public void add(final String personName) {
        orders.add(new Order(personName, ++orderNumber));
        N++;
    }

    private boolean isEmpty() {
        return N == 0;
    }

    public Order deliver() throws NullPointerException {
        if (isEmpty()) throw new NullPointerException("The queue is empty.");
        Order orderToDeliver = orders.getFirst();
        orders.removeFirst();
        N--;
        if (isEmpty()) {
            orderNumber = 0;
        }
        return orderToDeliver;
    }

    public Order deliver(final String name, final int orderNumber) throws NullPointerException, IllegalArgumentException {
        if (isEmpty()) throw new NullPointerException("The queue is empty.");
        Order orderToDeliver = null;
        boolean flag = false;
        int i = -1;
        for (Order order: orders) {
            if (name.equals(order.getPersonName()) && orderNumber == order.getOrderNumber()) {
                orderToDeliver = order;
                i = orders.indexOf(order);
                flag = true;
            }
        }
        if (flag) {
            orders.remove(i);
        }
        if (isEmpty()) {
            CoffeeOrderBoard.orderNumber = 0;
        }
        if (orderToDeliver == null) {
            throw new IllegalArgumentException("Such an order is not in the queue.");
        }
        return orderToDeliver;
    }

    public void draw() {
        if (isEmpty()) {
            System.out.println("No orders");
            return;
        }
        System.out.println("The list of all orders in an insertion order:");
        for (Order order: orders) {
            System.out.println(order);
        }
    }

    @Override
    public Iterator<Order> iterator() {

        return new Iterator<Order>() {

            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < N;
            }

            @Override
            public Order next() {
                return orders.get(i++);
            }

        };
    }

    @Override
    public void forEach(Consumer<? super Order> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Order> spliterator() {
        return Iterable.super.spliterator();
    }

}
