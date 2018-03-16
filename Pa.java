import java.util.Scanner;

public class Pa {
    public static int fnum(int n) { // »¼°j
        int pas[][] = new int[n][n];
        pas[0][0] = 1;
        for (int l = 0; l < n; l++) {
            for(int r = 0; r <= l; r++) {
                if (r == 0) {
                    pas[l][0] = 1;
                    System.out.println();
                } else {
                    pas[l][r] = pas[l - 1][r - 1] + pas[l - 1][r];
                }
                System.out.print(" " + pas[l][r] + " ");
            }
        }
        return n;
    }

    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        //System.out.println();
        fnum(n);
    }
}
