import java.util.Scanner;

class Poly {
    private int exop; // exop ������
    private int coeff; // coeff ���Y��
    public Poly(int ex, int co) {
        exop = ex;
        coeff = co;
    }
}

public class Hw05 {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        System.out.println("�п�JA���h���� : ");
        int a = input.nextInt();
        for (int i = 0; i < a; i++) {
            int ex = input.nextInt();
            int co = input.nextInt();
            Poly[i] A = new Poly(ex, op);
        }
        System.out.println("�п�JB���h���� : ");
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
        
        System.out.println("�h�����ۥ[���� :")
        for (int i = 0; i < n; i++) {
            System.out.println(C[i]);
        }
    }
}