import java.lang.*; 
public class TestPen extends Thread {
    private static Pen p = new Pen();
    private int x, y;
    private double h, r;
    public TestPen(int x, int y, double h, double r) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.r = r;
    }
    public void run() {
        fractalLine(x, y, h, r);
    }
    public synchronized static void drawPoint(int x, int y) {
        p.flyTo(x, y);
        p.runTo(x, y);
    }
    public static void fractalLine(int x, int y, double h, double r) {
        if (h <= 1) {
            drawPoint(x, y);
            try {
                Thread.currentThread().sleep(10);
            } catch(Exception err) {   
            }
            return;
        }
        // 劃出4個小fractalLine
        // 第一段，起點(x, y)，長度h/3，角度r
        fractalLine(x, y, h/3, r);
        // 第二段，起點(x, y)+h/3*(cos(r), sin(r)),長度h/3，角度r
        int nextX = x + (int)(h/3.0*Math.cos(Math.toRadians(r)));
        int nextY = y + (int)(h/3.0*Math.sin(Math.toRadians(r)));
        fractalLine(nextX, nextY, h/3, r-60);
        // 第三段，起點....，長度h/3，角度r-60
        nextX = nextX + (int)(h/3.0*Math.cos(Math.toRadians(r-60)));
        nextY = nextY + (int)(h/3.0*Math.sin(Math.toRadians(r-60)));
        fractalLine(nextX, nextY, h/3, r+60);
        // 第四段，起點....，長度h/3，角度r
        nextX = x + (int)(h/3.0*2*Math.cos(Math.toRadians(r)));
        nextY = y + (int)(h/3.0*2*Math.sin(Math.toRadians(r)));
        fractalLine(nextX, nextY, h/3, r);
    }
    public static void polygon(int x, int y, int h, int n) {
        // 中心(x, y)半徑為h的正n邊形
        double 等分角 = 360.0/n;
        double 內角 = 180.0 - 等分角;
        double 邊長 = 2 * h * Math.sin(Math.toRadians(等分角/2));
        // 先到第一個頂點
        p.flyTo((int)(x + h * Math.cos(Math.toRadians(-90))),
                (int)(y + h * Math.sin(Math.toRadians(-90))));
        // 算出n個頂點的座標
        double r;
        int i;
        for (i = 1, r = -90+等分角; i <= n; i++, r += 等分角) {
            int topX = (int)(x + h * Math.cos(Math.toRadians(r)));
            int topY = (int)(y + h * Math.sin(Math.toRadians(r)));
            p.runTo(topX, topY);
        }
    }
    public static void fractalPolygon(int x, int y, int h, int n) {
        // 中心(x, y)半徑為h的正n邊形
        double 等分角 = 360.0/n;
        double 邊長 = 2 * h * Math.sin(Math.toRadians(等分角/2));
        // 先到第一個頂點
        p.flyTo((int)(x + h * Math.cos(Math.toRadians(-90))),
                (int)(y + h * Math.sin(Math.toRadians(-90))));
        // 算出n個頂點的座標
        for (int i = 0; i < n; i++){
            int topX = (int)(x + h * Math.cos(Math.toRadians(i * 等分角-90)));
            int topY = (int)(y + h * Math.sin(Math.toRadians(i * 等分角-90)));
            Thread t = new TestPen(topX, topY, 邊長, (i + 0.5) * 等分角);
            t.start();
        }
    }
        public static void triangle(int x, int y, int h) {
        p.flyTo(x, y);
        p.runTo((int)(x + h/ Math.sqrt(3) + 0.5), y + h);
        p.runTo((int)(x - h/ Math.sqrt(3) + 0.5), y + h);
        p.runTo(x, y);
    }
    public static void fractalTriangle(int x, int y, int h) {
        if (h <= 1) {
            p.flyTo(x, y);
            p.runTo(x, y);
            return;
        }
        fractalTriangle(x, y, h/2);
        fractalTriangle((int)(x + h / Math.sqrt(3) / 2 + 0.5), y + h / 2, h / 2 );
        fractalTriangle((int)(x - h / Math.sqrt(3) / 2 + 0.5), y + h / 2, h / 2 );
    }
    public static void fractalSquare(int x, int y, int h) {
        if (h <= 1) {
            p.flyTo(x, y);
            p.runTo(x, y);
            return;
        }
        fractalSquare(x, y, h / 3);
        fractalSquare(x + h / 3, y, h / 3);
        fractalSquare(x + h * 2 / 3, y , h / 3);
        fractalSquare(x, y + h / 3, h / 3);
        fractalSquare(x + h * 2 / 3, y + h / 3, h / 3);
        fractalSquare(x, y + h * 2 / 3, h / 3);
        fractalSquare(x + h / 3, y + h * 2 / 3, h / 3);
        fractalSquare(x + h * 2 / 3, y + h * 2 / 3, h / 3);
    } 
    public static void main(String[] argv) {
        // fractalPolygon(300, 300, 250, 3);
        long start = System.currentTimeMillis();
        // do sth
        long stop = System.currentTimeMillis();
        System.out.println("used " + (stop - start) + " ms");
        int i, n = 100003;
        for (i = 2; i * i <= n; i++) 
            if (n % i == 0) {
                System.out.println(n + " is not a prime");
                break;
            }
        if (i * i > n)
            System.out.println(n + " is a prime");
    }
}



/** 碎形正方形
import java.lang.*; 
public class TestPen {
    private static Pen p = new Pen();
    public static void triangle(int x, int y, int h) {
        p.flyTo(x, y);
        p.runTo((int)(x + h/ Math.sqrt(3) + 0.5), y + h);
        p.runTo((int)(x - h/ Math.sqrt(3) + 0.5), y + h);
        p.runTo(x, y);
    }
    public static void fractalSquare(int x, int y, int h) {
        if (h <= 1) {
            p.flyTo(x, y);
            p.runTo(x, y);    
            try {
                Thread.currentThread().sleep(30);
            } catch(Exception err) {   
            }

            return;
        }
        fractalSquare(x, y, h / 3);
        fractalSquare(x + h / 3, y, h / 3);
        fractalSquare(x + h * 2 / 3, y , h / 3);
        fractalSquare(x, y + h / 3, h / 3);
        fractalSquare(x + h * 2 / 3, y + h / 3, h / 3);
        fractalSquare(x, y + h * 2 / 3, h / 3);
        fractalSquare(x + h / 3, y + h * 2 / 3, h / 3);
        fractalSquare(x + h * 2 / 3, y + h * 2 / 3, h / 3);
    }
    public static void main(String[] argv) {
        fractalSquare(50, 50, 243);
    }
}
**/

/** 碎形三角形
import java.lang.*; 
public class TestPen {
    private static Pen p = new Pen();
    public static void triangle(int x, int y, int h) {
        p.flyTo(x, y);
        p.runTo((int)(x + h/ Math.sqrt(3) + 0.5), y + h);
        p.runTo((int)(x - h/ Math.sqrt(3) + 0.5), y + h);
        p.runTo(x, y);
    }
    public static void fractalTriangle(int x, int y, int h) {
        if (h <= 1) {
            p.flyTo(x, y);
            p.runTo(x, y);
            return;
        }
        fractalTriangle(x, y, h/2);
        fractalTriangle((int)(x + h / Math.sqrt(3) / 2 + 0.5), y + h / 2, h / 2 );
        fractalTriangle((int)(x - h / Math.sqrt(3) / 2 + 0.5), y + h / 2, h / 2 );
    }
    public static void main(String[] argv) {
        fractalTriangle(400, 50, 512);
    }
} 
**/   




/** 正方形
    p.flyTo(50, 50);
    p.runTo(150, 50);
    p.runTo(150, 150);
    p.runTo(50, 150);
    p.runTo(50, 50);
**/


/**
    public static void polygon(int x, int y, int h, int n) {
        // 中心(x, y)半徑為h的正n邊形
        double 等分角 = 360.0/n;
        double 內角 = 180.0 - 等分角;
        double 邊長 = 2 * h * Math.sin(Math.toRadians(等分角/2));
        // 先到第一個頂點
        p.flyTo((int)(x + h * Math.cos(Math.toRadians(-90))),
                (int)(y + h * Math.sin(Math.toRadians(-90))));
        // 算出n個頂點的座標
        double r;
        int i;
        for (i = 1, r = -90+等分角; i <= n; i++, r += 等分角) {
            int topX = (int)(x + h * Math.cos(Math.toRadians(r)));
            int topY = (int)(y + h * Math.sin(Math.toRadians(r)));
            p.runTo(topX, topY);
        }
    }
**/