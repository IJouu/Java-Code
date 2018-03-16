import java.util.Scanner;
public class Hello {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.println("Your input is "+n);
    }
    public static int power(int x, int n) {
        int result = 1;
        for (int i = 1; i <= n; i++)
            result = result * x;
        return result;
    }
}