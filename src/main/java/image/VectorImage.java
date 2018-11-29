package image;

import javafx.scene.paint.Color;

import java.util.List;

public class VectorImage extends ImageDuplicationLimiter {

    private List<Shape> shapes;

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
}
