public class Car {

    Car() {}

    public String start() {
        return this.startElectricity() + " \n" + this.startCommand() + " \n" + this.startFuelSystem();
    }

    private String startElectricity() {
        return "Electric system is on.";
    }

    private String startCommand() {
        return "Command received.";
    }

    private String startFuelSystem() {
        return "Fuel system is active.";
    }
}


class Test {
    public static void main(String[] args) {

        Car car = new Car();
        System.out.println(car.start());

    }
}