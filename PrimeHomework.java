/*
*104213027
*�����X
*/
import java.util.Scanner;
import java.lang.*;
public class PrimeHomework {
    // ���ժk
    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) // �p�Gn��Qi�㰣
                return false; // i�N���O���
        return true; // �^�ǯu��
    } 
    // �p��X���X�ӽ��
    public static int primes(int n) {
        int counter = 0; // �]�ܼ�counter��0
        for (int i = 2; i <= n; i++)
            if (isPrime(i)) // �P�_�O�_�����
                counter++; // �p�G�O�N�[1
        return counter;
    }
    // �R���k
    public static int primesieve(int n) {
        boolean[] x = new boolean[n + 1]; // �]�@�Ӱ}�C����
        for (int i = 2; i <= n; i++) { // ���]�Ҧ����Ƴ��O���
            x[i] = true;
        }
        for (int i = 2; i * i <= n; i++) { 
            if (x[i]) {
                for (int j = i; i * j <= n; j++)
                    x[i * j] = false; // �p�G�Oi*j���ȡA�N���O���
            }
        }
        // �p��X���X�ӽ��
        int counter = 0;
        for (int i = 2; i <= n; i++) // �P�_�O�_�����
            if (x[i])
                counter++; // �p�G�O�N�[1
            return counter;
    }
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // �]�ܼ�n����J�p���ƪ���
        long primesStart = System.currentTimeMillis(); // �}�l�p����ժk���ɶ�
        System.out.print("���ժk " + primes(n) + "�� "); // �L�X���ժk�����G
        long primesStop = System.currentTimeMillis(); // �����p����ժk���ɶ�
        System.out.println(" " + (primesStop - primesStart) + " ms"); // �L�X���ժk���ɶ�
        long primesieveStart = System.currentTimeMillis(); // �}�l�p��R���k���ɶ�
        System.out.print("�R���k " + primesieve(n) + "�� "); // �L�X�R���k�����G
        long primesieveStop = System.currentTimeMillis(); // �����p��R���k���ɶ�
        System.out.println(" " + (primesieveStop - primesieveStart) + " ms"); // �L�X�R���k���ɶ�
    }
}