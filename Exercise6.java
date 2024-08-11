class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        this(other.x,other.y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void print() {
        System.out.println(" the point is:("+this.x+","+this.y+")");
    }
}

class Line {

    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = new Point(start);
        this.end = new Point(end);
    }

    public Line(Line other) {
        this(other.start,other.end);
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = new Point(start);
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = new Point(end);
    }

    public double distance() {
        return Math.sqrt(Math.pow(end.getY()-start.getY(),2) + Math.pow(end.getX()-start.getX(),2));
    }

    public double M() {
        return (double)(end.getY()-start.getY())/(end.getX()-start.getX());
    }
}

public class Exercise6 {

    public static void main(String[] args) {
        Point a = new Point(-6, 5);
        Point b = new Point(-2, 9);
        Point c = new Point(1, 6);
        Point d = new Point(-3, 2);

        // it is malben?
        // if M(ab) * M(bc) == -1 && M(ad) * M(cd) == -1 => malben
        Line ab = new Line(a, b);
        Line bc = new Line(b, c);
        Line ad = new Line(a, d);
        Line cd = new Line(c, d);
        System.err.println(ab.M() * bc.M());
        System.err.println(bc.M());

        
        if(ab.M() * bc.M() == -1 && ad.M() * cd.M() == -1){
            System.err.println("this is malben");
        } else System.err.println("not malben");


        
    }
}