package image;

import javafx.scene.paint.Color;

public class Circle implements Shape {

    private int x, y;
    private int radius;
    private Color color;

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
