package image;

import util.Matrices;

import java.awt.*;

public class BruteRasterImage {
    private Color[][] colors;

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


}
