package data;

/**
 *
 * @author NikitaShokorov
 */
public class GraphPoint {
    public long x;
    public long y;

    public GraphPoint() {
            this.x = 0;
            this.y = 0;
    }

    public GraphPoint(long x, long y) {
            this.x = x;
            this.y = y;
    }

    public long getX() {
            return x;
    }

    public void setX(long x) {
            this.x = x;
    }

    public long getY() {
            return y;
    }

    public void setY(long y) {
            this.y = y;
    }
}
