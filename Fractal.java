import java.lang.Math;

public class Fractal extends Thread {
    static Pen p = new Pen();
    public static void draw(int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) {
            // draw a point at(x1, y1)
            p.flyTo(x1, y1);
            p.runTo(x1, y1);
            try{
                Thread.currentThread().sleep(1);
            } catch(Exception err) {
            }
            return;
        }
        int offsetx = (x2 - x1) / 3;
        int offsety = (y2 - y1) / 3;
        draw(x1, y1, x1 + offsetx, y1 + offsety);
        draw(x1 + 2 * offsetx, y1, x1 + 3 * offsetx, y1 + offsety);
        draw(x1 + offsetx, y1 + offsety, x1 + 2 * offsetx, y1 + 2 * offsety);
        draw(x1, y1 + 2 * offsety, x1 + offsetx, y1 + 3 * offsety);
        draw(x1 + 2 * offsetx, y1 + 2 * offsety, x1 + 3 * offsetx, y1 + 3 * offsety);
    }
    public static void tri(int x1, int y1, int len) {
        if (len <= 1) {
            p.flyTo(x1, y1);
            p.runTo(x1, y1);
            return;
        }
        tri(x1, y1, len / 2);
        tri(x1 + len / 2, y1, len / 2);
        tri(x1 + len / 4, (int)(y1 - len * Math.sin(60 * Math.PI / 360)), len / 2);
    }
    public static void line(int x1, int y1, int len, int degree) {
        int x2, y2, x3, y3, x4, y4;
        if (len <= 1) {
            try {
                Thread.currentThread().sleep(10);
            } catch(Exception err) {
            }
            point(x1, y1);
            return;
        }
        x2 = (int)(x1 + len * Math.cos(Math.PI * degree / 180) / 3);
        y2 = (int)(y1 - len * Math.sin(Math.PI * degree / 180) / 3);
        x4 = (int)(x1 + 2 * len * Math.cos(Math.PI * degree / 180) / 3);
        y4 = (int)(y1 - 2 * len * Math.sin(Math.PI * degree / 180) / 3);
        x3 = (int)(x2 + len * Math.cos(Math.PI * (degree + 60) / 180) / 3);
        y3 = (int)(y2 - len * Math.sin(Math.PI * (degree + 60) / 180) / 3);
        line(x1, y1, len / 3, degree);
        line(x2, y2, len / 3, degree + 60);
        line(x3, y3, len / 3, degree - 60);
        line(x4, y4, len / 3, degree);
    }
    public static void line1(int x1, int y1, int len, int degree) {
        int x2, y2, x3, y3, x4, y4, x5, y5;
        if (len <= 1) {
            try {
                Thread.currentThread().sleep(10);
            } catch(Exception err) {
            }
            p.flyTo(x1, y1);
            p.runTo(x1, y1);
            return;
        }
        x2 = (int)(x1 + 0.4 * len * Math.cos(Math.PI * degree / 180));
        y2 = (int)(y1 - 0.4 * len * Math.sin(Math.PI * degree / 180));
        x5 = (int)(x1 + 0.6 * len * Math.cos(Math.PI * degree / 180));
        y5 = (int)(y1 - 0.6 * len * Math.sin(Math.PI * degree / 180));
        x3 = (int)(x2 + 0.2 * len * Math.cos(Math.PI * (degree + 90) / 180));
        y3 = (int)(y2 - 0.2 * len * Math.sin(Math.PI * (degree + 90) / 180));
        x4 = (int)(x3 + 0.2 * len * Math.cos(Math.PI * degree / 180));
        y4 = (int)(y3 - 0.2 * len * Math.sin(Math.PI * degree / 180));
        line1(x1, y1, (int)(0.4 * len), degree);
        line1(x2, y2, (int)(0.2 * len), degree + 90);
        line1(x3, y3, (int)(0.2 * len), degree);
        line1(x4, y4, (int)(0.2 * len), degree - 90);
        line1(x5, y5, (int)(0.4 * len), degree);
    }
    public static void square(int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) {
            // draw a point at(x1, y1)
            p.flyTo(x1, y1);
            p.runTo(x1, y1);
            return;
        }
        int offsetx = (x2 - x1) / 3;
        int offsety = (y2 - y1) / 3;
        square(x1, y1, x1 + offsetx, y1 + offsety);
        square(x1 + offsetx, y1, x1 + 2 * offsetx, y1 + offsety);
        square(x1 + 2 * offsetx, y1, x1 + 3 * offsetx, y1 + offsety);
        square(x1, y1 + offsety, x1 + offsetx, y1 + 2 * offsety);
        square(x1 + 2 * offsetx, y1 + offsety, x1 + 3 * offsetx, y1 + 2 * offsety);
        square(x1, y1 + 2 * offsety, x1 + offsetx, y1 + 3 * offsety);
        square(x1 + offsetx, y1 + 2 * offsety, x1 + 2 * offsetx, y1 + 3 * offsety);
        square(x1 + 2 * offsetx, y1 + 2 * offsety, x1 + 3 * offsetx, y1 + 3 * offsety);
    }
    public synchronized static void point(int x, int y) {
        p.flyTo(x, y);
        p.runTo(x, y);
    }
    private int x, y, len, degree;
    public Fractal(int x, int y, int len, int d) {
        this.x = x;
        this.y = y;
        this.len = len;
        degree = d;
    }
    public void run() {
        line(x, y, len, degree);
    }
    public static void main(String[] data) {
        (new Fractal(500, 500, 300, 180)).start();
        (new Fractal(200, 500, 300, 90)).start();
        (new Fractal(200, 200, 300, 0)).start();
        (new Fractal(500, 200, 300, -90)).start();
        /*square(100, 100, 300, 300);
        tri(100, 500, 200);
        line1(100, 300, 400, 0);*/
    }
} 