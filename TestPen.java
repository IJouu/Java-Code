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
        // ���X4�ӤpfractalLine
        // �Ĥ@�q�A�_�I(x, y)�A����h/3�A����r
        fractalLine(x, y, h/3, r);
        // �ĤG�q�A�_�I(x, y)+h/3*(cos(r), sin(r)),����h/3�A����r
        int nextX = x + (int)(h/3.0*Math.cos(Math.toRadians(r)));
        int nextY = y + (int)(h/3.0*Math.sin(Math.toRadians(r)));
        fractalLine(nextX, nextY, h/3, r-60);
        // �ĤT�q�A�_�I....�A����h/3�A����r-60
        nextX = nextX + (int)(h/3.0*Math.cos(Math.toRadians(r-60)));
        nextY = nextY + (int)(h/3.0*Math.sin(Math.toRadians(r-60)));
        fractalLine(nextX, nextY, h/3, r+60);
        // �ĥ|�q�A�_�I....�A����h/3�A����r
        nextX = x + (int)(h/3.0*2*Math.cos(Math.toRadians(r)));
        nextY = y + (int)(h/3.0*2*Math.sin(Math.toRadians(r)));
        fractalLine(nextX, nextY, h/3, r);
    }
    public static void polygon(int x, int y, int h, int n) {
        // ����(x, y)�b�|��h����n���
        double ������ = 360.0/n;
        double ���� = 180.0 - ������;
        double ��� = 2 * h * Math.sin(Math.toRadians(������/2));
        // ����Ĥ@�ӳ��I
        p.flyTo((int)(x + h * Math.cos(Math.toRadians(-90))),
                (int)(y + h * Math.sin(Math.toRadians(-90))));
        // ��Xn�ӳ��I���y��
        double r;
        int i;
        for (i = 1, r = -90+������; i <= n; i++, r += ������) {
            int topX = (int)(x + h * Math.cos(Math.toRadians(r)));
            int topY = (int)(y + h * Math.sin(Math.toRadians(r)));
            p.runTo(topX, topY);
        }
    }
    public static void fractalPolygon(int x, int y, int h, int n) {
        // ����(x, y)�b�|��h����n���
        double ������ = 360.0/n;
        double ��� = 2 * h * Math.sin(Math.toRadians(������/2));
        // ����Ĥ@�ӳ��I
        p.flyTo((int)(x + h * Math.cos(Math.toRadians(-90))),
                (int)(y + h * Math.sin(Math.toRadians(-90))));
        // ��Xn�ӳ��I���y��
        for (int i = 0; i < n; i++){
            int topX = (int)(x + h * Math.cos(Math.toRadians(i * ������-90)));
            int topY = (int)(y + h * Math.sin(Math.toRadians(i * ������-90)));
            Thread t = new TestPen(topX, topY, ���, (i + 0.5) * ������);
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



/** �H�Υ����
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

/** �H�ΤT����
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




/** �����
    p.flyTo(50, 50);
    p.runTo(150, 50);
    p.runTo(150, 150);
    p.runTo(50, 150);
    p.runTo(50, 50);
**/


/**
    public static void polygon(int x, int y, int h, int n) {
        // ����(x, y)�b�|��h����n���
        double ������ = 360.0/n;
        double ���� = 180.0 - ������;
        double ��� = 2 * h * Math.sin(Math.toRadians(������/2));
        // ����Ĥ@�ӳ��I
        p.flyTo((int)(x + h * Math.cos(Math.toRadians(-90))),
                (int)(y + h * Math.sin(Math.toRadians(-90))));
        // ��Xn�ӳ��I���y��
        double r;
        int i;
        for (i = 1, r = -90+������; i <= n; i++, r += ������) {
            int topX = (int)(x + h * Math.cos(Math.toRadians(r)));
            int topY = (int)(y + h * Math.sin(Math.toRadians(r)));
            p.runTo(topX, topY);
        }
    }
**/