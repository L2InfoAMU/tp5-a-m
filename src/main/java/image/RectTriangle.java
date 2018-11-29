package image;

import javafx.scene.paint.Color;

/**
 * Used to store and object representing a right-angled triangle
 */
public class RectTriangle implements Shape {

    private int x;
    private int y;
    private int x_size;
    private int y_size;
    private Color color;

    /**
     * Constructor for RectTriangle
     * @param x : x coordinate of the point where the right angle is placed
     * @param y : y coordinate of the point where the right angle is placed
     * @param x_size : x size of the triangle (can be negative to allow all right triangles)
     * @param y_size : y size of the triangle (can be negative to allow all right triangles)
     * @param color : color of the triangle
     */
    RectTriangle(int x, int y, int x_size, int y_size, Color color) {
        this.x = x;
        this.y = y;
        this.x_size = x_size;
        this.y_size = y_size;
        this.color = color;
    }

    /**
     * Computes the area of a right-angled triangle
     * @return area of the triangle
     */
    double getArea() {
        return x_size * y_size / 2.;
    }

    @Override
    public boolean contains(Point point) {
        Point a = new Point(x, y);
        Point b = new Point(x + x_size, y);
        Point c = new Point(x, y + y_size);

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
