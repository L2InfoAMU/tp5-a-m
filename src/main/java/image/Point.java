package image;

import java.util.Objects;

/**
 * Created by Arnaud Labourel on 09/11/2018.
 */
public class Point {
    public final int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Computes the distance between two points
     * @param p : point to calculate distance with
     * @return distance to point p
     */
    public double distanceTo(Point p) {
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(x, y);
    }


}
