import java.util.Scanner;

public class Count1 {
    public static int get(int A, int B) {
        int a, b, add = 0;
        a = A % 10;
        b = B % 10;
        while(a != 0 || b != 0) {
            a = A % 10;
            b = B % 10;
            if(a + b >= 10) {
                add = add + 1;
                A = A / 10 + 1;
                if ((A / 10 + 1) >= 10) {
                    add++;
                }
            } else {
                A = A / 10;
            }
            B = B / 10;
        }
        return add;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        int result = x + y;
        System.out.println(result + " " + get(x, y));
    }
}
