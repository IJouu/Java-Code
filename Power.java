import java.util.Scanner;
import java.lang.*;

public class Power {
    public static double power(double x, double m) { // �]�@�Ө��power, �Ψ���ܼ�x�Mm, ���O����ƪ����ƩM����
        int i;
        double y = 1; // y�q1�}�l
        for (i = 1; i <= m; i = i+1) // �j��,�q1�@����p�ƪ��ȵ��� m
        {
            y = y * x; // y���Hx����i=m, y���ȧY��x��m����
        }
        return y; // �^��y��
    }
    
    public static double root(double x, double n) { // �]�@�Ө�� root, �Ψ���ܼ�x�Mn, n�Ox��1/n����
        double left = 0;
        double right = 0;
        double mid;        
        if (x >= 1) // �P�_x�j�󵥩�1
        {
            left = 1; // ������=1
            right = x; // �k����=x
        }
        else if (x < 1) // �P�_x�p��1
        {
            left = x; // ������=x
            right = 1; // �k����=1
        }
        mid = (left + right) / 2; // mid���󥪥k���������� 
        while (mid > left && mid < right) // ��mid�j��left,�p��right
        {
            if (power(mid, n) > x) // �P�_power(mid, n)�j��x
            {
                right = mid; // answer at left
            } else if (power(mid, n) < x) // �P�_power(mid, n)�p��x
            {
                left = mid; // answer at right
            } else
                return mid; // �^��mid
            mid = (left + right) / 2; // mid���󥪥k����������
        } 
        return mid;
    } // �ΤQ���G��k�G��x��1/n���誺��
    
    public static void main(String[] argv) {
        Scanner input = new Scanner(System.in);
        double x = input.nextDouble();
        double m = input.nextDouble();
        double n = input.nextDouble();
        System.out.println(root(power(x, m), n)); // �L�Xx��m/n����
    }
}