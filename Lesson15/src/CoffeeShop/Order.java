package CoffeeShop;

public class Order {

    private final int orderNumber;
    private final String personName;

    public Order(final String personName, final int orderNumber) {
        this.orderNumber = orderNumber;
        this.personName = personName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getPersonName() {
        return personName;
    }

    @Override
    public String toString() {
        return "Order number " + orderNumber + " for " + personName + ".";
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(orderNumber);
        return result * 31 * result + personName.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Order order) {
            return orderNumber == order.orderNumber && personName.equals(order.personName);
        }
        return false;
    }

}
