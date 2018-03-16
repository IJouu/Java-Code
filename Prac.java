import java.util.Scanner;
import java.lang.*;

public class Prac {
    public static int test(int n) {
        int len = 0;
        while(n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            len = len + 1;
        }
        return len;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println(n + " " + test(n));
    }
}