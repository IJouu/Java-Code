public class Trapezoid extends Shape2D {
    private double up, down, height;
    private String name; // 設字串name為暱稱
    public Trapezoid(String name, double u, double d, double h) {
        up = u;
        down = d;
        height = h;
        this.name = name;
    }
    public double area() { // 計算面積
        return (up + down) * height / 2;
    }
    public String getName() { // 傳回暱稱
        return name;
    }
}