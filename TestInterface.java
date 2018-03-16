interface ShapeInterface { // 介面，為了解決多重繼承問題
    public static final double PI = 3.1415926536; // final不能重新給值
    public abstract double area();
}
interface SubShape extends ShapeInterface {
}
interface Strange {
    double PI = 3.0;
    int varl = 10;
    void fun();
}
interface Multi extends SubShape, Strange {
    void fun();
}
interface Second {
}
public class TestInterface implements Multi, Second{
    public void fun() {
        System.out.println("TestInterface use print to implement to");
    }
    public double area() {
        return ShapeInterface.PI;
    }
    public static void main(String[] argv) {
        TestInterface t = new TestInterface();
        System.out.println(t.area());
    }
}