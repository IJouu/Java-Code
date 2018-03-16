import java.util.Scanner;

public class Tes {
    public static double factorial(double n) {
        double y = 1;
        for(int i = 1; i <= n; i++) {
            y = y * i;
        }
        return y;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();
        //double m = input.nextDouble();
        //double n = input.nextDouble();
        System.out.println(factorial(x));
    }
}