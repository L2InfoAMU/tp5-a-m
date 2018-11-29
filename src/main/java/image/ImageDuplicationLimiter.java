package image;

/**
 * Abstract class to reduce code duplication between VectorImage and RasterImage classes
 */
public abstract class ImageDuplicationLimiter implements Image {
    int width;
    int height;

    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Setter for image width
     * @param width : new width of the image
     */
    protected void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Setter for image height
     * @param height : new height of the image
     */
    protected void setHeight(int height) {
        this.height = height;
    }
}
