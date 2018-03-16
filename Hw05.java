import java.util.Scanner;

class Poly {
    public int exop = 0; // exop 為次方
    public int coeff = 0; // coeff 為係數
    public Poly(int ex, int co) {
        exop = ex;
        coeff = co;
    }
}

public class Hw05 {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        System.out.print("請輸入A的多項式 : ");
        int a = input.nextInt();
        Poly[] A = new Poly[a];
        for (int i = 0; i < a; i++) {
            int ex = input.nextInt();
            int co = input.nextInt();
            A[i] = new Poly(ex, co);
        }
        
        System.out.print("請輸入B的多項式 : ");
        int b = input.nextInt();
        Poly[] B = new Poly[b];
        for (int j = 0; j < b; j++) {
            int ex = input.nextInt();
            int co = input.nextInt();
            B[j] = new Poly(ex, co);
        }
        
        // input complete
        
        int n = 0;
        int x = 0;
        if (A[0].exop > B[0].exop)
            n = A[0].exop + 1;
        else
            n = B[0].exop + 1;
        
        if (A[a - 1].exop > B[b - 1].exop)
            x = B[b - 1].exop;
        else
            x = A[a - 1].exop;
        
        Poly[] C = new Poly[n];
        for (int i = 0; i < n; i++) {
            C[i] = new Poly(0, 0);
        }
        
        for (int i = 0; i < n; i++) { // c
            for (int j = 0; j < a; j++) { // a
                if (i == A[j].exop) {
                    C[i].exop = A[j].exop;
                    C[i].coeff = A[j].coeff;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < b; j++) {
                if (i == B[j].exop) {
                    C[i].exop = B[j].exop;
                    C[i].coeff = C[i].coeff + B[j].coeff;
                }
            }
        }
        
        System.out.println("\r\n");
        // 印出A的多項式
        System.out.print("A的多項式 : " );
        for (int i = 0; i < a - 1; i++) {
            System.out.print("(" + A[i].coeff + ")X^" + A[i].exop + " " + "+ ");
        }
        if (A[a - 1].exop == 0 && A[a - 1].coeff != 0)
            System.out.print("(" + A[a - 1].coeff + ")");
        else if (A[a - 1].coeff != 0 && A[a - 1].exop != 0)
            System.out.print("(" + A[a - 1].coeff + ")X^" + A[a - 1].exop);
        System.out.println();
        
        // 印出B的多項式
        System.out.print("B的多項式 : " );
        for (int i = 0; i < b - 1; i++) {
            System.out.print("(" + B[i].coeff + ")X^" + B[i].exop + " " + "+ ");
        }
        if (B[b - 1].exop == 0 && B[b - 1].coeff != 0)
            System.out.print("(" + B[b - 1].coeff + ")");
        else if (B[b - 1].coeff != 0 && B[b - 1].exop != 0)
            System.out.print("(" + B[b - 1].coeff + ")X^" + B[b - 1].exop);
        
        System.out.println("\r\n");
        System.out.println("多項式相加結束 :");
        for (int i = n - 1; i > x; i--) {
            if (C[i].exop != 0) {
                System.out.print("(" + C[i].coeff + ")X^" + C[i].exop + " " + "+ ");
            }
        }
        if (C[x].exop == 0 && C[x].coeff != 0)
            System.out.print("(" + C[x].coeff + ")");
        else if (C[x].coeff != 0 && C[x].exop != 0)
            System.out.print("(" + C[x].coeff + ")X^" + C[x].exop);
        System.out.println();
    }
}