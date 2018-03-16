import java.util.*;

public class TestTriangle {
    // 判斷邊長
    public static boolean testLen(int l1, int l2, int l3) {
        if (l1 > 20 || l2 > 20 || l3 > 20) {
            System.out.println("邊長不可大於20");
            return false;
        } else if (l1 + l2 <= l3) {
            System.out.println("兩邊之和大於第三邊");
            return false;
        } else {
            return true;
        }
    }
    // 判斷類型
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
        // 排列(小到大)
        for (int i = 1; i < len.length; i++) {
            tmp = len[i];
            int j = i - 1;
            while (j > -1 && tmp < len[j]) {
                len[j + 1] = len[j];
                j--;
            }
            len[j + 1] = tmp;
        }
        // 判斷三角形
        if (testLen(len[0], len[1], len[2])) {
            type(len[0], len[1], len[2]);
        }
    }
}
