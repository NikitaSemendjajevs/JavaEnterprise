package Geometry;

import java.math.BigDecimal;

public class Circle implements Shape {

    private final double radius;
    private final double area;

    Circle (final double radius) {
        this.radius = radius;
        this.area = computeArea();
    }

    @Override
    public double computeArea() {
        return Shape.PI * Math.pow(radius, 2);
    }

}
