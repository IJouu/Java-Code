import java.util.*;

class ���� implements Runnable {
    private int[] a;
    
    public ����(int[] a) {
        this.a = a;
    }
    
    public void run() {
        ��m.������m(a);
    }
}

public class ��m {

    public static void main(String[] args) throws Throwable {
        int length = Integer.parseInt(args[0]);
        int[] a = createRandomArray(length);

        long startTime1 = System.currentTimeMillis();
        �����m(a);
        long endTime1 = System.currentTimeMillis();

        if (!isSorted(a)) {
            throw new RuntimeException("�y�ϰڡI�m�l���ǶäF�I: " + Arrays.toString(a));
        }
        System.out.println(length + " �Ӧm�l�ӿ�@��F " + (endTime1 - startTime1) + " �@�� ");
        System.out.println("���W�������B�������F�I");
    }

    // for thread
    public static void �����m(int[] a) {
        // split array in half
        int[] �褻�c = ArrayCopy(a, 0, a.length / 2);
        int[] �F���c = ArrayCopy(a, a.length / 2, a.length);

        Thread ������ = new Thread(new ����(�褻�c));
        Thread ������ = new Thread(new ����(�F���c));
        ������.start();
        ������.start();

        try {
            ������.join();
            ������.join();
        } catch (InterruptedException ie) {}

        // merge them back together
        merge(�褻�c, �F���c, a);
    }

    public static void ������m(int[] �m�l��) {
        if (�m�l��.length >= 2) {
            // split array in half
            int[] left  = ArrayCopy(�m�l��, 0, �m�l��.length / 2);
            int[] right = ArrayCopy(�m�l��, �m�l��.length / 2, �m�l��.length);

            // sort the halves
            ������m(left);
            ������m(right);

            // merge them back together
            merge(left, right, �m�l��);
        }
    }
    
    public static void merge(int[] left, int[] right, int[] a) {
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < a.length; i++) {
            if (i2 >= right.length || (i1 < left.length && left[i1] < right[i2])) {
                a[i] = left[i1];
                i1++;
            } else {
                a[i] = right[i2];
                i2++;
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        if (i != j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
    
    public static boolean isSorted(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] createRandomArray(int length) {
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int)(Math.random()*60+39);
        }
        return a;
    }
    public static int[] ArrayCopy(int[] a, int start, int end) {
        int[] result = new int[end-start];
        for (int i = 0; i < (end-start); i++) {
            result[i] = a[start + i];
        }
        return result;
    }
}