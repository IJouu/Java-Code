public class Rectangle extends Shape2D { // �~�ө�H���O
    private double width, height; // �]�ܼ�width���e�Alength����
    private String name; // �]�r��name���ʺ�
    public Rectangle(String name, double w, double h) {
        width = w; // width��w
        height = h; // height��h
        this.name = name; // ���Ϋe����name
    }
    public double area() { // �p�⭱�n
        return width * height;
    }
    public String getName() { // �Ǧ^�ʺ�
        return name;
    }
}