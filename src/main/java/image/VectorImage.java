package image;

import javafx.scene.paint.Color;

import java.util.List;

/**
 * Used to generate an image with vector graphics
 */
public class VectorImage extends ImageDuplicationLimiter {

    private List<Shape> shapes;

    /**
     * Constructor for VectorImage
     * @param shapes : list of all shapes to display in the image
     * @param width : width of the image to display
     * @param height : height of the image to display
     */
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
