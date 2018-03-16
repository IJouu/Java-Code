public class Triangle extends Shape2D {
    private double base, height;
    private String name; // 設字串name為暱稱
    public Triangle(String name, double b, double h) {
        base = b;
        height = h;
        this.name = name;
    }
    public double area() { // 計算面積
        return base * height / 2;
    }
    public String getName() { // 傳回暱稱
        return name;
    }
}