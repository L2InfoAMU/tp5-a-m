package image;

import javafx.scene.paint.Color;

import java.util.List;

public class VectorImage implements Image {

    private List<Shape> shapes;
    private int width;
    private int height;

    public VectorImage(List<Shape> shapes, int width, int height) {
        this.shapes = shapes;
        this.width = width;
        this.height = height;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        for (Shape shape : shapes) {
            if (shape.contains(new Point(x, y))) {
                return shape.getColor();
            }
        }
        return Color.WHITE;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    protected void setHeight(int height) {
        this.height = height;
    }
}
