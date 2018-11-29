package image;

public abstract class ImageDuplicationLimiter implements Image {
    int width;
    int height;

    @Override
    public int getWidth() {
        return width;
    }

    protected void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    protected void setHeight(int height) {
        this.height = height;
    }
}
