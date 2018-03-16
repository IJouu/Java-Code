public class Base {
    public static String toString(int val, int b) {
        String y = "";
        while (val != 0) {
            y = val % b + y;
            val = val / b;
        }
        return y;
    }
    public static int reverse(int x) {
        int y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x = x / 10;
        }
        return y;
    }
    public static void main(String[] argv) {
        // System.out.println(reverse(12345));
        System.out.println(toString(10, 2));
    }
}
