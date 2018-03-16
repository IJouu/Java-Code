import java.util.Scanner;

public class Count {
    public static int fun(int n) {
        int num = 0;
        String co;
        co = Integer.toString(n);
        for (int i = 0; i < co.length() - 1; i++) {
            num++;
        }
        return num;
    }
    public static int reverse(int x) {
        int y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return y;
    }
    public static int fun2(int m, int n) {
        int num = 0;
        String ms = Integer.toString(m);
        String ns = Integer.toString(n);
        if (m > n) {
            for (int i = 0; i < ns.length(); i++) {
                if ((Integer.parseInt(String.valueOf(ms.charAt(i))) + Integer.parseInt(String.valueOf(ns.charAt(i)))) < 10) {
                    num++;
                } else {
                    int y = 0;
                    for (int j = 0; j < i + 1; j++) {
                        y = 10 * (i + 1);
                    }
                    ms = Integer.toString(reverse(reverse(m) + y));
                }
            }
        } else {
            for (int i = 0; i < ms.length(); i++) {
                if ((Integer.parseInt(String.valueOf(ms.charAt(i))) + Integer.parseInt(String.valueOf(ns.charAt(i)))) < 10) {
                    num++;
                } else {
                    int y = 0;
                    for (int j = 0; j < i + 1; j++) {
                        y = 10 * (i + 1);
                    }
                    ns = Integer.toString(reverse(reverse(n) + y));
                }
            }
        }
        return num;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        int result;
        result = x + y;
        System.out.print(result + " ");
        System.out.println(fun2(reverse(x), reverse(y)));
        System.out.println(fun(result) - fun2(reverse(x), reverse(y)));
    }
}
