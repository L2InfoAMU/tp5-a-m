package image;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SparseRasterImage extends RasterImage {

    private List<Point> nonWhitePixels = new ArrayList<>();
    private HashMap<Point, Color> hashMap = new HashMap<>();

    public SparseRasterImage(Color color, int width, int height) {
        hashMap.clear();
        this.width = width;
        this.height = height;
        if (!color.equals(Color.WHITE)) {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    Point point = new Point(i, j);
                    nonWhitePixels.add(point);
                    hashMap.put(point, color);
                }
            }
        }
    }

    public SparseRasterImage(Color[][] pixels) {
        hashMap.clear();
        checkArrayValidity(pixels);
        width = pixels.length;
        height = pixels[0].length;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (!pixels[i][j].equals(Color.WHITE)) {
                    Point point = new Point(i, j);
                    nonWhitePixels.add(point);
                    hashMap.put(point, pixels[i][j]);
                }
            }
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
