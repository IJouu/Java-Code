public class Square extends Shape2D {
    private double length;
    private String name; // �]�r��name���ʺ�
    public Square(String name, double l){
        length = l;
        this.name = name;
    }
    public double area() { // �p�⭱�n
        return length * length;
    }
    public String getName() { // �Ǧ^�ʺ�
        return name;
    }
}