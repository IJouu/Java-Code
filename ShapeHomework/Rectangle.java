public class Rectangle extends Shape2D { // 繼承抽象類別
    private double width, height; // 設變數width為寬，length為長
    private String name; // 設字串name為暱稱
    public Rectangle(String name, double w, double h) {
        width = w; // width為w
        height = h; // height為h
        this.name = name; // 指用前面的name
    }
    public double area() { // 計算面積
        return width * height;
    }
    public String getName() { // 傳回暱稱
        return name;
    }
}