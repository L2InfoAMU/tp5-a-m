package image;

import javafx.scene.paint.Color;

public class Rectangle implements Shape {

    private int x, y, width, height;
    private Color color;

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
