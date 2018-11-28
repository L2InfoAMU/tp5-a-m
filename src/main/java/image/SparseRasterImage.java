package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        for (Point nonWhitePixel : nonWhitePixels) {
            if (nonWhitePixel.x == x && nonWhitePixel.y == y) {
                return hashMap.getOrDefault(nonWhitePixel, Color.WHITE);
            }
        }
        return Color.WHITE;
    }
}
