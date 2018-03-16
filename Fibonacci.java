/*
*104213027
*�����X
*/
import java.util.Scanner;

public class Fibonacci {
    public static long fnum(long n) { // ���j
        if (n == 1 || n == 0) { // �������
            return n; // F0 = 0; F1 = 1
        }
        return fnum(n - 1) + fnum(n - 2); // ��X��n�Ӽ�
    }

    public static long sum(long n) { // ��0~n���O��ƦC�[�_��
        long total = 0;
        for(int i = 0; i <= n; i++)
            total = total + fnum(i);
        return total;
    }

    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        System.out.print("�п�J�A�n�䪺��: ");
        long n = input.nextLong(); // �]�ܼ�n���n�䪺�Ӽ�
        System.out.println("�� " + n + " �ӼƬ�: " + fnum(n)); // �L�X��n�Ӽ�
        System.out.println("�`�@����: " + sum(n)); // �L�X�[�`
    }
}
