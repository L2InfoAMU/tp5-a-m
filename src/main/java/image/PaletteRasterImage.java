package image;

import javafx.scene.paint.Color;
import util.Matrices;

import java.util.ArrayList;
import java.util.List;

public class PaletteRasterImage implements Image {

    private List<Color> palette = new ArrayList<>();
    private byte[][] indexOfColors;
    private int width;
    private int height;

    private Pixel[][] pixels;

    public PaletteRasterImage(Color color, int width, int height) {
        this.width = width;
        this.height = height;
        this.indexOfColors = new byte[width][height];
        palette.add(color);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                addColorToPalette(color);
                indexOfColors[i][j] = (byte) getColorIndexFromPalette(color);
            }
        }
    }

    public PaletteRasterImage(Color[][] pixels) {
        Matrices.requiresNonZeroDimensions(pixels);
        Matrices.requiresNonNull(pixels);
        Matrices.requiresRectangularMatrix(pixels);
        this.width = pixels.length;
        this.height = pixels[0].length;
        this.indexOfColors = new byte[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                addColorToPalette(pixels[i][j]);
                indexOfColors[i][j] = (byte) getColorIndexFromPalette(pixels[i][j]);
            }
        }
    }

    @Override
    public Color getPixelColor(int x, int y) {
        return palette.get(indexOfColors[x][y]);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    private boolean isColorInPalette(Color color) {
        for (Color aPalette : palette) {
            if (color.equals(aPalette)) {
                return true;
            }
        }
        return false;
    }

    private int getColorIndexFromPalette(Color color) {
        for (int i = 0; i < palette.size(); i++) {
            if (color.equals(palette.get(i))) {
                return i;
            }
        }
        return -1;
    }

    private void addColorToPalette(Color color) {
        if (!isColorInPalette(color)) {
            if (palette.size() == 128) {
                throw new NotSupportedException("Palette is full");
            }
            palette.add(color);
        }
    }

    private Color getColorFromPalette(int index) {
        return palette.get(index);
    }

    public void createRepresentation() {
        pixels = new Pixel[getWidth()][getHeight()];
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                pixels[i][j] = new Pixel(i, j, getColorFromPalette((int) indexOfColors[i][j]));
            }
        }
    }

    public void setPixelColor(Color color, int x, int y) {
        addColorToPalette(color);
        indexOfColors[x][y] = (byte) getColorIndexFromPalette(color);
    }

    private void setPixelsColor(Color color) {
        new PaletteRasterImage(color, width, height);
    }
}
