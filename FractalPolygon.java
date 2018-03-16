/*
*104213027
*�����X
*/
import java.lang.*;
import java.lang.Math; 
public class FractalPolygon {
    private static Pen p = new Pen();
    public static void fractalLine(int x, int y, double h, double r) {
        if (h <= 1) {
            p.flyTo(x, y);
            p.runTo(x, y);
            return;
        }
        // ���X4�ӤpfractalLine
        // �Ĥ@�q�A�_�I(x, y)�A����h/3�A����r
        fractalLine(x, y, h / 3, r);
        // �ĤG�q�A�_�I(x, y)+h/3*(cos(r), sin(r)),����h/3�A����r+60
        int nextX = x + (int)(h / 3.0 * Math.cos(Math.toRadians(r)));
        int nextY = y + (int)(h / 3.0 * Math.sin(Math.toRadians(r)));
        fractalLine(nextX, nextY, h / 3.0 , r - 60);
        // �ĤT�q�A�_�I....�A����h/3�A����r-60
        nextX = nextX + (int)(h / 3.0 * Math.cos(Math.toRadians(r - 60)));
        nextY = nextY + (int)(h / 3.0 * Math.sin(Math.toRadians(r - 60)));
        fractalLine(nextX, nextY, h / 3.0, r + 60);
        // �ĥ|�q�A�_�I....�A����h/3�A����r
        nextX = x + (int)(h / 3.0 * 2 * Math.cos(Math.toRadians(r)));
        nextY = y + (int)(h / 3.0 * 2 * Math.sin(Math.toRadians(r)));
        fractalLine(nextX, nextY, h / 3, r);
    } 
    public static void fractalPolygon(int x, int y, int h, int n) {
        // ����(x, y)�b�|��h����n���
        double ������ = 360.0 / n;
        double ��� = 2 * h * Math.sin(Math.toRadians(������ / 2));
        // ����Ĥ@�ӳ��I
        p.flyTo((int)(x + h * Math.cos(Math.toRadians(-90))),
                (int)(y + h * Math.sin(Math.toRadians(-90))));
        // ��Xn�ӳ��I���y��
        for (int i = 0; i < n; i++){
            int topX = (int)(x + h * Math.cos(Math.toRadians(i * ������ - 90)));
            int topY = (int)(y + h * Math.sin(Math.toRadians(i * ������ - 90)));
            fractalLine(topX, topY, ���, (i + 0.5) * ������);
        }
    }
    public static void main(String[] argv) { // ��J����ΰѼ�
        fractalPolygon(300, 300, 270, 3);
    }
}