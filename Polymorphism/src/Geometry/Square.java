package Geometry;

public class Square implements Shape {

    private final double length;
    private final double area;

    Square(final double length) {
        this.length = length;
        this.area = computeArea();
    }

    @Override
    public double computeArea() {
        return Math.pow(length, 2);
    }
}
