public class Circle extends Shape2D { // 繼承抽象類別
    private double radius; // 設變數radius為半徑
    private String name; // 設字串name為暱稱
    private static final double PI = 3.141592654;
    public Circle(String name, double r) {
        radius = r; 
        this.name = name;
    }
    public double area() { // 計算面積
        return PI * radius * radius;
    }
    public String getName() { // 傳回暱稱
        return name;
    }
}