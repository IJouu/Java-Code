/*
*104213027
*黃奕柔
*/
import java.util.Scanner;
import java.lang.*;
public class PrimeHomework {
    // 測試法
    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) // 如果n能被i整除
                return false; // i就不是質數
        return true; // 回傳真值
    } 
    // 計算出有幾個質數
    public static int primes(int n) {
        int counter = 0; // 設變數counter為0
        for (int i = 2; i <= n; i++)
            if (isPrime(i)) // 判斷是否為質數
                counter++; // 如果是就加1
        return counter;
    }
    // 刪除法
    public static int primesieve(int n) {
        boolean[] x = new boolean[n + 1]; // 設一個陣列放質數
        for (int i = 2; i <= n; i++) { // 假設所有的數都是質數
            x[i] = true;
        }
        for (int i = 2; i * i <= n; i++) { 
            if (x[i]) {
                for (int j = i; i * j <= n; j++)
                    x[i * j] = false; // 如果是i*j的值，就不是質數
            }
        }
        // 計算出有幾個質數
        int counter = 0;
        for (int i = 2; i <= n; i++) // 判斷是否為質數
            if (x[i])
                counter++; // 如果是就加1
            return counter;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // 設變數n為輸入計算質數的值
        long primesStart = System.currentTimeMillis(); // 開始計算測試法的時間
        System.out.print("測試法 " + primes(n) + "個 "); // 印出測試法的結果
        long primesStop = System.currentTimeMillis(); // 結束計算測試法的時間
        System.out.println(" " + (primesStop - primesStart) + " ms"); // 印出測試法的時間
        long primesieveStart = System.currentTimeMillis(); // 開始計算刪除法的時間
        System.out.print("刪除法 " + primesieve(n) + "個 "); // 印出刪除法的結果
        long primesieveStop = System.currentTimeMillis(); // 結束計算刪除法的時間
        System.out.println(" " + (primesieveStop - primesieveStart) + " ms"); // 印出刪除法的時間
    }
}