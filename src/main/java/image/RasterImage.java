package image;

import util.Matrices;

public abstract class RasterImage implements Image {

    int width;
    int height;

    Pixel[][] pixels;

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void checkArrayValidity(Object[][] o) {
        Matrices.requiresNonZeroDimensions(o);
        Matrices.requiresNonNull(o);
        Matrices.requiresRectangularMatrix(o);
    }

    public boolean checkCoordinatesInArray(int x, int y) {
        return (x >= 0 && x < width) && (y >= 0 && y < height);
    }
}
