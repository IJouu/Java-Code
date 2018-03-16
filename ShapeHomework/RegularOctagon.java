public class RegularOctagon extends Shape2D {
    private double length;
    private String name; // 設字串name為暱稱
    public RegularOctagon(String name, double l) {
        length = l;
        this.name = name;
    }
    public double area() { // 計算面積
        return (2 + 2 * Math.sqrt(2)) * length * length;
    }
    public String getName() { // 傳回暱稱
        return name;
    }
}