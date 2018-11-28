package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class SparseRasterImage extends RasterImage {

    private Color[][] colors;

    private List<Point> nonWhitePixels = new ArrayList<>();
    private HashMap<Point, Color> hashMap;

    public SparseRasterImage(Color color, int width, int height) {
        this.width = width;
        this.height = height;
        this.colors = new Color[width][height];
        if (!color.equals(Color.WHITE)) {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    colors[i][j] = color;
                }
            }
        }
    }

    public SparseRasterImage(Color[][] pixels) {
        checkArrayValidity(pixels);
        width = pixels.length;
        height = pixels[0].length;
        colors = new Color[width][height];
        for (int i = 0; i < width; i++) {
            if (height >= 0) System.arraycopy(pixels[i], 0, colors[i], 0, height);
        }
    }

    @Override
    public Color getPixelColor(int x, int y) {
        if (!checkCoordinatesInArray(x,y)) {
            throw new NoSuchElementException();
        }
        return hashMap.getOrDefault(new Point(x, y), Color.WHITE);
    }

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

    public void setPixelColor(Color color, int x, int y) {
        if (!checkCoordinatesInArray(x,y)) {
            throw new NoSuchElementException();
        }
        colors[x][y] = color;
        createRepresentation();
    }

    private void setPixelsColor(Color[][] pixels) {
        new SparseRasterImage(pixels);
    }

    private void setPixelsColor(Color color) {
        new SparseRasterImage(color, width, height);
    }
}
