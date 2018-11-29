package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Generates and image with a maximum of 128 colors stored in
 */
public class PaletteRasterImage extends RasterImage {

    private List<Color> palette = new ArrayList<>();
    private byte[][] indexOfColors;

    private static final int MAX_COLORS = 128;

    /**
     * Constructor for PaletteRasterImage
     * Creates a single color image
     * @param color : color of the image
     * @param width : image width
     * @param height : image height
     */
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

    /**
     * Contructor for PaletteRasterImage
     * Creates an image with colors specified in the array passed
     * @param pixels : 2 dimension array of colors of each individual pixel
     */
    public PaletteRasterImage(Color[][] pixels) {
        checkArrayValidity(pixels);
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
        if (!areCoordinatesInArray(x,y)) {
            throw new NoSuchElementException();
        }
        return palette.get(indexOfColors[x][y]);
    }

    /**
     * Private method to check if color is already in list of colors
     * @param color : color to check
     * @return true if the color is in the palette
     */
    private boolean isColorInPalette(Color color) {
        for (Color aPalette : palette) {
            if (color.equals(aPalette)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the color index in the palette
     * @param color : color which index has to be returned
     * @return index of the color in the palette
     */
    private int getColorIndexFromPalette(Color color) {
        for (int i = 0; i < palette.size(); i++) {
            if (color.equals(palette.get(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Adds the specified color to the palette
     * @param color : color to add
     */
    private void addColorToPalette(Color color) {
        if (!isColorInPalette(color)) {
            if (palette.size() == MAX_COLORS) {
                throw new NotSupportedException("Palette is full");
            }
            palette.add(color);
        }
    }

    /**
     * Gets the color at a specified index from the palette
     * @param index : integer, index of the color to get
     * @return color at the specified index
     */
    private Color getColorFromPalette(int index) {
        return palette.get(index);
    }

    /**
     * Creates 2 dimensional array of pixels to display
     */
    public void createRepresentation() {
        pixels = new Pixel[getWidth()][getHeight()];
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                pixels[i][j] = new Pixel(i, j, getColorFromPalette((int) indexOfColors[i][j]));
            }
        }
    }

    /**
     * Sets the color of the pixel which coordinates are specified in the parameters
     * @param color : new color of the pixel
     * @param x : x coordinate of the pixel
     * @param y : y coordinate of the pixel
     */
    public void setPixelColor(Color color, int x, int y) {
        if (!areCoordinatesInArray(x,y)) {
            throw new NoSuchElementException();
        }
        addColorToPalette(color);
        indexOfColors[x][y] = (byte) getColorIndexFromPalette(color);
    }

    /**
     * Resets the image to be single color
     * @param color : color of the image
     */
    private void setPixelsColor(Color color) {
        new PaletteRasterImage(color, width, height);
    }
}
