import java.util.Scanner;
import java.math.BigInteger;

public class Fibonacci() {
    public static long fnum(long n) {
        BigInteger f1 = new BigInteger("1");
        BigInteger f2 = new BigInteger("-1");
        for(int i = 0; i <= n; i++) {
            BigInteger tmp = f1;
            f1 = f1.add(f2);
            f2 = tmp;
        }
        return f1;
    }
     public static long sum(long n) {
        // 加總函式
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
    } 
}