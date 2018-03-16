/*
*104213027
*黃奕柔
*/
import java.util.Scanner;

public class StringReverse {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        String str = input.next(); // 輸入一串文字
        int n = input.nextInt(); // 分群，n個為一群
        String reversed = ""; // 設一個放反轉後的字串
        int remainder = str.length() % n; // 字串分堆後餘數的部分
        int divisible = str.length() - remainder; // 字串分堆後整除的部分
        // 反轉字串整除的部分
        for (int i = 0; i < divisible; i = i + n) { 
            for (int j = i + n - 1; j >= i; j--) // 
                reversed = reversed + str.charAt(j);
        }
        // 反轉字串餘數的部分
        for (int i = str.length() - 1; i > divisible - 1; i--) {
            reversed = reversed + str.charAt(i);
        }
        System.out.println(reversed); // 印出反轉字串
    }
}