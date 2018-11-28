package image;

import javafx.scene.paint.Color;
import util.Matrices;

public class BruteRasterImage extends RasterImage {
    private Color[][] colors;

    public BruteRasterImage(Color color, int width, int height) {
        this.width = width;
        this.height = height;
        this.colors = new Color[this.width][this.height];
        for (int i = 0; i < this.width; i++) {
            for (int j = 0; j < this.height; j++) {
                this.colors[i][j] = color;
            }
        }
    }

    public BruteRasterImage(Color[][] colors) {
        checkArrayValidity(colors);
        this.width = colors.length;
        this.height = colors[0].length;
        this.colors = colors;
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return colors[x][y];
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
        checkArrayValidity(colors);
        colors[x][y] = color;
        createRepresentation();
    }

    private void setPixelsColor(Color[][] pixels) {
        checkArrayValidity(pixels);
        this.colors = pixels;
        createRepresentation();
    }

    private void setPixelsColor(Color color) {
        new BruteRasterImage(color, getWidth(), getHeight());
    }
}
