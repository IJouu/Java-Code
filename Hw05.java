import java.util.Scanner;

class Poly {
    public int exop = 0; // exop ������
    public int coeff = 0; // coeff ���Y��
    public Poly(int ex, int co) {
        exop = ex;
        coeff = co;
    }
}

public class Hw05 {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        System.out.print("�п�JA���h���� : ");
        int a = input.nextInt();
        Poly[] A = new Poly[a];
        for (int i = 0; i < a; i++) {
            int ex = input.nextInt();
            int co = input.nextInt();
            A[i] = new Poly(ex, co);
        }
        
        System.out.print("�п�JB���h���� : ");
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
        // �L�XA���h����
        System.out.print("A���h���� : " );
        for (int i = 0; i < a - 1; i++) {
            System.out.print("(" + A[i].coeff + ")X^" + A[i].exop + " " + "+ ");
        }
        if (A[a - 1].exop == 0 && A[a - 1].coeff != 0)
            System.out.print("(" + A[a - 1].coeff + ")");
        else if (A[a - 1].coeff != 0 && A[a - 1].exop != 0)
            System.out.print("(" + A[a - 1].coeff + ")X^" + A[a - 1].exop);
        System.out.println();
        
        // �L�XB���h����
        System.out.print("B���h���� : " );
        for (int i = 0; i < b - 1; i++) {
            System.out.print("(" + B[i].coeff + ")X^" + B[i].exop + " " + "+ ");
        }
        if (B[b - 1].exop == 0 && B[b - 1].coeff != 0)
            System.out.print("(" + B[b - 1].coeff + ")");
        else if (B[b - 1].coeff != 0 && B[b - 1].exop != 0)
            System.out.print("(" + B[b - 1].coeff + ")X^" + B[b - 1].exop);
        
        System.out.println("\r\n");
        System.out.println("�h�����ۥ[���� :");
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