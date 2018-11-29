package image;

import javafx.scene.paint.Color;

/**
 * Used to store an object representing a random triangle
 */
public class Triangle implements Shape {

    private Color color;

    private Point a;
    private Point b;
    private Point c;

    /**
     * Constructor for Triangle
     * @param color : color of the triangle
     * @param a : point A of the triangle
     * @param b : point B of the triangle
     * @param c : point C of the triangle
     */
    Triangle(Color color, Point a, Point b, Point c) {
        this.color = color;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Computes the area of a triangle
     * @return area of the triangle
     */
    double getArea() {
        return Math.abs(a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) /2.;
    }

    @Override
    public boolean contains(Point point) {
        double areaABC = getArea();
        double areaABP = new Triangle(color, a, b, point).getArea();
        double areaAPC = new Triangle(color, a, point, c).getArea();
        double areaPBC = new Triangle(color, point, b, c).getArea();

        return areaABC == areaABP + areaAPC + areaPBC;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
