public class Triangle extends Shape2D {
    private double base, height;
    private String name; // �]�r��name���ʺ�
    public Triangle(String name, double b, double h) {
        base = b;
        height = h;
        this.name = name;
    }
    public double area() { // �p�⭱�n
        return base * height / 2;
    }
    public String getName() { // �Ǧ^�ʺ�
        return name;
    }
}