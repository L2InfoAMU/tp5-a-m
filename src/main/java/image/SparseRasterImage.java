package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Generates and image by storing only the non white pixels
 */
public class SparseRasterImage extends RasterImage {

    private Color[][] colors;

    private List<Point> nonWhitePixels = new ArrayList<>();
    private HashMap<Point, Color> hashMap = new HashMap<>();

    /**
     * Constructor for SparseRasterImage
     * Creates a single color image with the specified dimensions
     * @param color : color of the image
     * @param width : width of the image
     * @param height : height of the image
     */
    public SparseRasterImage(Color color, int width, int height) {
        this.width = width;
        this.height = height;
        this.colors = new Color[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                colors[i][j] = color;
            }
        }
        createRepresentation();
    }

    /**
     * Constructor for SparseRasterImage
     * Creates an image with the colors specified in the array passed
     * @param pixels : 2 dimension array of colors for each individual pixel
     */
    public SparseRasterImage(Color[][] pixels) {
        checkArrayValidity(pixels);
        width = pixels.length;
        height = pixels[0].length;
        colors = new Color[width][height];
        for (int i = 0; i < width; i++) {
            if (height >= 0) System.arraycopy(pixels[i], 0, colors[i], 0, height);
        }
        createRepresentation();
    }

    @Override
    public Color getPixelColor(int x, int y) {
        if (!areCoordinatesInArray(x,y)) {
            throw new NoSuchElementException();
        }
        return hashMap.getOrDefault(new Point(x, y), Color.WHITE);
    }

    /**
     * Creates 2 dimensional array of pixels to display
     */
    public void createRepresentation() {
        hashMap = new HashMap<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (!colors[i][j].equals(Color.WHITE)) {
                    Point point = new Point(i, j);
                    nonWhitePixels.add(point);
                    hashMap.put(point, colors[i][j]);
                }
            }
        }
    }

    /**
     * Sets the color of a single pixel
     * @param color : new color of the pixel
     * @param x : x coordinate of the pixel
     * @param y : y coordinate of the pixel
     */
    public void setPixelColor(Color color, int x, int y) {
        if (!areCoordinatesInArray(x,y)) {
            throw new NoSuchElementException();
        }
        colors[x][y] = color;
    }

    /**
     * Refreshes all the pixels
     * @param pixels : 2 dimension array of color for each individual pixel
     */
    private void setPixelsColor(Color[][] pixels) {
        new SparseRasterImage(pixels);
    }

    /**
     * Refreshes image as a single color image
     * @param color : color of the new image
     */
    private void setPixelsColor(Color color) {
        new SparseRasterImage(color, width, height);
    }
}
