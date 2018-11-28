package image;

import java.awt.*;

public class BruteRasterImage {
    private Color[][] colors;

    public BruteRasterImage(Color color, int width, int height) {
        this.colors = new Color[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.colors[i][j] = color;
            }
        }
    }
}
