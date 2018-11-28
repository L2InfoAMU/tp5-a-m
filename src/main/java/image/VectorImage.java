package image;

import javafx.scene.paint.Color;

import java.util.List;

public class VectorImage implements Image {

    private List<Shape> shapes;
    int width;
    int height;

    public VectorImage(List<Shape> shapes, int width, int height) {
        this.shapes = shapes;
        this.width = width;
        this.height = height;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
