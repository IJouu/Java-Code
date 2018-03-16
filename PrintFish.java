import java.util.Scanner;
public class PrintFish {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); //印出指定數量的某字元
        for (int i = 1; i <= n; i++) { //印出上半段的圖形
            printNChar((n-i) * 3, ' '); //印出魚的身體
            printNChar(i * 3 + 3 * (i-1), '*');
            printNChar((n-i) * 3 + (n-i), ' '); //印出魚的尾巴
            printNChar(i-1, '*');
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i = i-1) { //印出下半段的圖形
            printNChar((n-i) * 3, ' '); //印出魚的身體
            printNChar(i*3 + 3 * (i-1), '*');
            printNChar((n-i) * 3 + (n-i), ' '); //印出魚的尾巴
            printNChar(i-1, '*');
            System.out.println();
        }
    }
    public static void printNChar(int n, char c) { 
        for (int i = 1; i <= n; i++)
            System.out.print(c);
    }
}