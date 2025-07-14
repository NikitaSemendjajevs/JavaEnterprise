package Geometry;

public class Triangle implements Shape {

    private final double sideA;
    private final double sideB;
    private final double sideC;
    private final double area;

    Triangle(final double sideA, final double sideB, final double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.area = computeArea();
    }

    @Override
    public double computeArea() {
        double s = (sideA + sideB + sideC) / 2.0; // semi-perimeter
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }
    
}
