package image;

import javafx.scene.paint.Color;

/**
 * Used to store an object representing a rectangle
 */
public class Rectangle implements Shape {

    private int x, y, width, height;
    private Color color;

    /**
     * Constructor for Rectangle
     * @param x : x coordinate of the upper right corner
     * @param y : y coordinate of the upper right corner
     * @param width : width of the rectangle
     * @param height : height of the rectangle
     * @param color : color of the rectangle
     */
    Rectangle(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public boolean contains(Point point) {
        return (point.x >= x && point.x < x + width) && (point.y >= y && point.y < y + height);
    }

    @Override
    public Color getColor() {
        return color;
    }
}
