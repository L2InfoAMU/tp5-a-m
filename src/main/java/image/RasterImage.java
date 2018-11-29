package image;

import util.Matrices;

public abstract class RasterImage extends ImageDuplicationLimiter {

    Pixel[][] pixels;

    public void checkArrayValidity(Object[][] o) {
        Matrices.requiresNonZeroDimensions(o);
        Matrices.requiresNonNull(o);
        Matrices.requiresRectangularMatrix(o);
    }

    public boolean areCoordinatesInArray(int x, int y) {
        return (x >= 0 && x < width) && (y >= 0 && y < height);
    }
}
