public interface ShapeInterface { // 介面，為了解決多重繼承問題
    public static final double PI = 3.1415926536; // final 表示不能重新給值
    public abstract double area();
}
interface subShape extends ShapeInterface {
}
interface Strange {
    int varl;
    void fun();
}
interface Multi extends SubShape, Strange {
    double PI = 3.0;
    void fun();
}
interface Second {
}
public class TestInterface implements Multi, Second{
}