public class RegularOctagon extends Shape2D {
    private double length;
    private String name; // �]�r��name���ʺ�
    public RegularOctagon(String name, double l) {
        length = l;
        this.name = name;
    }
    public double area() { // �p�⭱�n
        return (2 + 2 * Math.sqrt(2)) * length * length;
    }
    public String getName() { // �Ǧ^�ʺ�
        return name;
    }
}