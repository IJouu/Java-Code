import java.util.Scanner;
public class PrintFish {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); //�L�X���w�ƶq���Y�r��
        for (int i = 1; i <= n; i++) { //�L�X�W�b�q���ϧ�
            printNChar((n-i) * 3, ' '); //�L�X��������
            printNChar(i * 3 + 3 * (i-1), '*');
            printNChar((n-i) * 3 + (n-i), ' '); //�L�X��������
            printNChar(i-1, '*');
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i = i-1) { //�L�X�U�b�q���ϧ�
            printNChar((n-i) * 3, ' '); //�L�X��������
            printNChar(i*3 + 3 * (i-1), '*');
            printNChar((n-i) * 3 + (n-i), ' '); //�L�X��������
            printNChar(i-1, '*');
            System.out.println();
        }
    }
    public static void printNChar(int n, char c) { 
        for (int i = 1; i <= n; i++)
            System.out.print(c);
    }
}