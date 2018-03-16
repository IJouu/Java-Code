public class Circle extends Shape2D { // �~�ө�H���O
    private double radius; // �]�ܼ�radius���b�|
    private String name; // �]�r��name���ʺ�
    private static final double PI = 3.141592654;
    public Circle(String name, double r) {
        radius = r; 
        this.name = name;
    }
    public double area() { // �p�⭱�n
        return PI * radius * radius;
    }
    public String getName() { // �Ǧ^�ʺ�
        return name;
    }
}