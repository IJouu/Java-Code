/*
*104213027
*�����X
*/
import java.util.Scanner;

public class StringReverse {
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        String str = input.next(); // ��J�@���r
        int n = input.nextInt(); // ���s�An�Ӭ��@�s
        String reversed = ""; // �]�@�ө����᪺�r��
        int remainder = str.length() % n; // �r������l�ƪ�����
        int divisible = str.length() - remainder; // �r������㰣������
        // ����r��㰣������
        for (int i = 0; i < divisible; i = i + n) { 
            for (int j = i + n - 1; j >= i; j--) // 
                reversed = reversed + str.charAt(j);
        }
        // ����r��l�ƪ�����
        for (int i = str.length() - 1; i > divisible - 1; i--) {
            reversed = reversed + str.charAt(i);
        }
        System.out.println(reversed); // �L�X����r��
    }
}