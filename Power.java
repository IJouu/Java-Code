import java.util.Scanner;
import java.lang.*;

public class Power {
    public static double power(double x, double m) { // 砞ㄧ计power, のㄢ跑计x㎝m, だㄧ计┏计㎝计
        int i;
        double y = 1; // y眖1秨﹍
        for (i = 1; i <= m; i = i+1) // 癹伴,眖1璸计单 m
        {
            y = y * x; // yxi=m, yxmΩよ
        }
        return y; // 肚y
    }
    
    public static double root(double x, double n) { // 砞ㄧ计 root, のㄢ跑计x㎝n, n琌x1/nΩよ
        double left = 0;
        double right = 0;
        double mid;        
        if (x >= 1) // 耞x单1
        {
            left = 1; // オ伐=1
            right = x; // 伐=x
        }
        else if (x < 1) // 耞x1
        {
            left = x; // オ伐=x
            right = 1; // 伐=1
        }
        mid = (left + right) / 2; // mid单オ伐キだ 
        while (mid > left && mid < right) // 讽midleft,right
        {
            if (power(mid, n) > x) // 耞power(mid, n)x
            {
                right = mid; // answer at left
            } else if (power(mid, n) < x) // 耞power(mid, n)x
            {
                left = mid; // answer at right
            } else
                return mid; // 肚mid
            mid = (left + right) / 2; // mid单オ伐キだ
        } 
        return mid;
    } // ノだ笹猭笹x1/nΩよ
    
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();
        double m = input.nextDouble();
        double n = input.nextDouble();
        System.out.println(root(power(x, m), n)); // xm/nΩよ
    }
}