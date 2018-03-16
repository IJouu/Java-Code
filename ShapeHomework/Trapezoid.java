public class Trapezoid extends Shape2D {
    private double up, down, height;
    private String name; // �]�r��name���ʺ�
    public Trapezoid(String name, double u, double d, double h) {
        up = u;
        down = d;
        height = h;
        this.name = name;
    }
    public double area() { // �p�⭱�n
        return (up + down) * height / 2;
    }
    public String getName() { // �Ǧ^�ʺ�
        return name;
    }
}