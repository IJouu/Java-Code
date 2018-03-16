import java.util.Scanner;
public class Test {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) { 
            printNChar(i, '*');
            System.out.println();
        }
    }
    public static void printNChar(int n, char c) {
        for (int i = 1; i <= n; i++)
            System.out.print(c);
    }
}