import java.util.*;

public class TestTriangle {
    // �P�_���
    public static boolean testLen(int l1, int l2, int l3) {
        if (l1 > 20 || l2 > 20 || l3 > 20) {
            System.out.println("������i�j��20");
            return false;
        } else if (l1 + l2 <= l3) {
            System.out.println("���䤧�M�j��ĤT��");
            return false;
        } else {
            return true;
        }
    }
    // �P�_����
    public static void type(int l1, int l2, int l3) {
        if (l1 == l2 && l2 == l3) {
            System.out.println("equilateral");
        } else if (l1 == l2 || l2 == l3) {
            System.out.println("isosceles");
        } else {
            System.out.println("scalene");
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] len = new int[3];
        int tmp;
        for (int i = 0; i < 3; i++) {
            len[i] = input.nextInt();
        }
        // �ƦC(�p��j)
        for (int i = 1; i < len.length; i++) {
            tmp = len[i];
            int j = i - 1;
            while (j > -1 && tmp < len[j]) {
                len[j + 1] = len[j];
                j--;
            }
            len[j + 1] = tmp;
        }
        // �P�_�T����
        if (testLen(len[0], len[1], len[2])) {
            type(len[0], len[1], len[2]);
        }
    }
}
