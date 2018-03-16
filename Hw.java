import java.util.Scanner;
public class Hw {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 1; i <= n; i++) { 
            printNChar(n-i, ' ');
            printNChar(2*i-1, '*');
            System.out.println();
        }
        for (int i = n; i >= 1; i = i-1) { 
            printNChar(n-i, ' ');
            printNChar(2*i-1, '*');
            System.out.println();
        }
    }
    public static void printNChar(int n, char c) {
        for (int i = 1; i <= n; i++)
            System.out.print(c);
    }
}

//印出菱形