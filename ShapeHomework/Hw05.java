import java.util.Scanner;

class Poly {
    private int exop; // exop 為次方
    private int coeff; // coeff 為係數
    public Poly(int ex, int co) {
        exop = ex;
        coeff = co;
    }
}

public class Hw05 {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        System.out.println("請輸入A的多項式 : ");
        int a = input.nextInt();
        for (int i = 0; i < a; i++) {
            int ex = input.nextInt();
            int co = input.nextInt();
            Poly[i] A = new Poly(ex, op);
        }
        System.out.println("請輸入B的多項式 : ");
        int b = input.nextInt();
        for (int j = 0; j < b; j++) {
            int ex = input.nextInt();
            int co = input.nextInt();
            Poly[j] B = new Poly(ex, op);
        }
        
        int n;
        Poly[] C = new Poly[n];
        if (A[0].exop > B[0].exop)
            n = A[0].exop + 1;
        else
            n = B[0].exop + 1;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < a; j++) {
                if (A[j].exop == i)
                    C[i].coeff = A[j].coeff;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < b; j++) {
                if (B[j].exop == i)
                    C[i].coeff = C[i].coeff + B[j].coeff;
            }
        }
        
        System.out.println("多項式相加結束 :")
        for (int i = 0; i < n; i++) {
            System.out.println(C[i]);
        }
    }
}