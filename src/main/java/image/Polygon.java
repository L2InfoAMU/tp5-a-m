package image;

import javafx.scene.paint.Color;

import java.util.List;

public class Polygon implements Shape {

    private Color color;
    private List<Point> points;

    public Polygon(Color color, List<Point> points) {
        this.color = color;
        this.points = points;
    }

    @Override
    public boolean contains(Point point) {
        return false;
    }

    @Override
    public Color getColor() {
        return color;
    }
}
