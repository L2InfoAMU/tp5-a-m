package image;

import javafx.scene.paint.Color;

import java.util.NoSuchElementException;

/**
 * Generates an image by setting all pixels individually in a RasterImage
 */
public class BruteRasterImage extends RasterImage {
    private Color[][] colors;

    /**
     * Constructor for BruteRasterImage
     * Creates a single color image with the specified dimensions
     * @param color : color of the image to display
     * @param width : width of the image
     * @param height : height of the image
     */
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

    /**
     * Constructor for BruteRasterImage
     * Creates an image with the colors specified in the 2 dimension array
     * The image dimensions are specified by the dimensions of the array
     * @param colors : 2 dimension array with the colors of each individual pixels
     */
    public BruteRasterImage(Color[][] colors) {
        checkArrayValidity(colors);
        this.width = colors.length;
        this.height = colors[0].length;
        this.colors = colors;
    }
    @Override
    public Color getPixelColor(int x, int y) {
        if (!areCoordinatesInArray(x,y)) {
            throw new NoSuchElementException();
        }
        return colors[x][y];
    }

    /**
     * Generates array of pixels to display
     */
    public void createRepresentation() {
        pixels = new Pixel[getWidth()][getHeight()];
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                pixels[i][j] = new Pixel(i, j, colors[i][j]);
            }
        }
    }

    /**
     * Changes a single pixel color
     * @param color : new pixel color
     * @param x : x pixel coordinate
     * @param y : y pixel coordinate
     */
    public void setPixelColor(Color color, int x, int y) {
        checkArrayValidity(colors);
        if (!areCoordinatesInArray(x,y)) {
            throw new NoSuchElementException();
        }
        colors[x][y] = color;
        createRepresentation();
    }

    /**
     * Changes the color of every pixel in the image
     * @param pixels : array 2 dimension array of colors for each pixel
     */
    private void setPixelsColor(Color[][] pixels) {
        checkArrayValidity(pixels);
        this.colors = pixels;
        createRepresentation();
    }

    /**
     * Fills image with a single color
     * @param color : new color of the image
     */
    private void setPixelsColor(Color color) {
        new BruteRasterImage(color, getWidth(), getHeight());
    }
}
