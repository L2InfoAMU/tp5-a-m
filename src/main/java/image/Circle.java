package image;

import javafx.scene.paint.Color;

/**
 * Used to store an object representing a circle
 */
public class Circle implements Shape {

    private int x, y;
    private int radius;
    private Color color;

    /**
     * Constructor for Circle
     * @param x : x coordinate of the center
     * @param y : y coordinate of the center
     * @param radius : radius of the circle
     * @param color : corlor of the circle
     */
    public Circle(int x, int y, int radius, Color color) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public boolean contains(Point point) {
        return (Math.pow(point.x - x, 2) + Math.pow(point.y - y, 2)) <= Math.pow(radius, 2);
    }

    @Override
    public Color getColor() {
        return color;
    }
}
