package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage implements Image {
    private Color[][] colors;
    private Pixel[][] pixels;

    public BruteRasterImage(Color color, int width, int height) {
        this.colors = new Color[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.colors[i][j] = color;
            }
        }
    }

    public BruteRasterImage(Color[][] colors) {
        Matrices.requiresNonZeroDimensions(colors);
        Matrices.requiresNonNull(colors);
        Matrices.requiresRectangularMatrix(colors);
        this.colors = colors;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return colors[x][y];
    }

    @Override
    public int getWidth() {
        return colors.length;
    }

    @Override
    public int getHeight() {
        return colors[0].length;
    }

    public void createRepresentation() {
        pixels = new Pixel[getWidth()][getHeight()];
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                pixels[i][j] = new Pixel(i, j, colors[i][j]);
            }
        }
    }

    public void setPixelColor(Color color, int x, int y) {
        Matrices.requiresNonZeroDimensions(pixels);
        Matrices.requiresNonNull(pixels);
        Matrices.requiresRectangularMatrix(pixels);
        pixels[x][y] = new Pixel(x, y, color);
    }

    private void setPixelsColor(Color[][] pixels) {
        this.colors = pixels;
        createRepresentation();
    }

    private void setPixelsColor(Color color) {
        new BruteRasterImage(color, getWidth(), getHeight());
    }
}
