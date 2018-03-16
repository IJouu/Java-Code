/*
*104213027
*黃奕柔
*/
import java.util.Scanner;

public class Fibonacci {
    public static long fnum(long n) { // 遞迴
        if (n == 1 || n == 0) { // 停止條件
            return n; // F0 = 0; F1 = 1
        }
        return fnum(n - 1) + fnum(n - 2); // 找出第n個數
    }

    public static long sum(long n) { // 把0~n的費氏數列加起來
        long total = 0;
        for(int i = 0; i <= n; i++)
            total = total + fnum(i);
        return total;
    }

    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入你要找的數: ");
        long n = input.nextLong(); // 設變數n為要找的個數
        System.out.println("第 " + n + " 個數為: " + fnum(n)); // 印出第n個數
        System.out.println("總共的值: " + sum(n)); // 印出加總
    }
}
